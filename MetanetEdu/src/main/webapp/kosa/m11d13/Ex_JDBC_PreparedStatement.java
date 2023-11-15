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

    ================================================================
    PreparedStatement (준비된 Statement )

    (1) 설명

        미리 SQL문이 셋팅된 Statement 가 DB가 전송되어져서 컴파일되어지고,
        SQL문의 ?만 나중에 추가 셋팅해서 실행
        이 되어지는 준비된 Statement

    (2) 장점

        <1> Statement 에 비해서 반복적인 SQL문을 사용할 경우에 더 빠르다.
            ( 특히, 검색문 )

        <2> DB컬럼타입과 상관없이 ?하나로 표시하면 되므로 개발자가 헷깔리지 않고 쉽다.
            ( 특히, INSERT문 )
        (이유: ?를 제외한 SQL문이 DB에서 미리 컴파일되어져서 대기)

    (3) 단점

        SQL문마다 PreparedStatement 객체를 각각 생성해야 하므로 재사용불가
        (but, Statement 객체는 SQL문이 달라지더라도 한 개만 생성해서 재사용이 가능하다. )

    (4) 특징
        <1> Statement stmt = con.createStatement(); //생성 stmt.execute(sql);//실행
        <2> PreparedStatement pstmt = con.prepareStatement(sql); //생성 pstmt.execute(); //실행
 */

public class Ex_JDBC_PreparedStatement {
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
