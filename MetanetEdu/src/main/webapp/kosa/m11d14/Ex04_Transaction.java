package kr.or.kosa.m11d14;

import kr.or.kosa.m11d13.utils.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
    JDBC >> default(DML) >> autocommit >> 실반영된다

    JDBC >> autocommit >> 변경(옵션) >> False >>
    개발자 직접(반드시) >> commit , rollback 제어 허락



 */
public class Ex04_Transaction {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;

        conn = ConnectionHelper.getConnection("oracle");

        String sql = "insert into trans_a(num, name) values(100, 'A')";
        String sql2 = "insert into trans_b(num, name) values(100, 'B')";

        try {
            /*
                업무상 하나의 트랜잭션으로 묶어야 한다면?
                위의 두 개의 쿼리가, 둘다 성공 하거나, 둘다 실패해야한다.
             */
            conn.setAutoCommit(false); //JDBC에게 commit, rollback 을 자동으로 하게 하지 않는다.
            pstmt = conn.prepareStatement(sql);
            pstmt2 = conn.prepareStatement(sql2);

            // 원래는 ? ? 로 받아주는 코드가 있어야 하는데, 수업상 생략

            pstmt.executeUpdate();
            pstmt2.executeUpdate();
            // 예외 발생하지 않으면 여기까지 정상 실행

            conn.commit();
            // 예외 블록으로 빠지지 않으면, 여기서 커밋을 실행합니다.
        } catch (Exception e) {
            /*
                롤백은 예외 처리 에서 합니다. 예외가 발생하면,
                자동으로 catch 구문으로 날아오기 때문이죠.
             */
            System.out.println("예외 발생 : " + e.getMessage());
            try {
                conn.rollback();
                /*
                    위의 try 구문에 들어있는 모든 작업들이 취소됩니다.
                 */
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally { //finally 구문에서 pstmt, conn 역순으로 닫아주기
            ConnectionHelper.close(pstmt2);
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
    }
}
