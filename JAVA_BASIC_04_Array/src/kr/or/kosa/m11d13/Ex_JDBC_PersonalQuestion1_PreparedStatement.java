package kr.or.kosa.m11d13;

import kr.or.kosa.m11d13.utils.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
/*
    prepareStatement 를 쓰면 SQL을 좀더 유연하게 작성할 수 있다는 장점도 있지만,
    가장 큰 목적은 보안상의 이유입니다. 이것을 사용하지 않으면, createStatement 한 다음에,
    executeUpdate 를 해서 쿼리를 보내는데요. PreparedStatement 를 보내면,
    쿼리문장을 서버에 먼저 보내서 컴파일 해 놓고, 매개변수만 보내면 됩니다.
    그래서 해커가 중간에 가로채도 쿼리 문장을 모르기 때문에 뭐가 뭔지 모릅니다.
    그래서 성능도 좋고 보안도 좋습니다.
 */
public class Ex_JDBC_PersonalQuestion1_PreparedStatement {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = ConnectionHelper.getConnection("oracle");
            String sql = "update dmlemp set ename=?, sal=?, job=?, deptno=? where empno=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "홍길동");
            pstmt.setInt(2, 1000);
            pstmt.setString(3, "IT");
            pstmt.setInt(4, 10);
            pstmt.setInt(1, 100);

            int row = pstmt.executeUpdate();
            if(row>0) {
                System.out.println("row : " + row);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionHelper.close(pstmt);
        }



    }
}
