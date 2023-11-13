package kr.or.kosa.m11d13;

import java.sql.*;

/*
    JDBC
    1. Java 언어(APP)를 통해서 Oracle(소프트웨어) 연결해서 CRUD작업

    2. Java App : Oracle , My-sql , MS-sql 등등 연결하고 작업(CRUD)
        2.1 각각의 제품에 맞는 드라이버를 가지고 있어야 합니다
            CASE 1: 삼성 노트북 >> HP 프린터 연결 >> HP프린터 사이트에서 드라이버 다운 >> 삼성 설치
            CASE 2: HP프린터 제조 회사는 ... 삼성, LG 회사마다 적용할 수 있는 드라이버를 별도 제작
            각 언어에 맞는 드라이버를 다운로드 해서 제품에 맞게 설치 .... 접속 ...
            Oracle (C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib)
            Mysql (https://dev.mysql.com/downloads/connector/j/)
            강사PC : D:\Duzon\DataBase\Connect Utils\OracleJDBC >> ojdbc6.jar

    3. 드라이버를 참조 (현재 프로젝트에서 사용) >> Java Project -> 속성 -> build path ->
        jar 파일 추가

        3.1 드라이버 사용 준비 완료 >> 메모리에 load 사용 ....

        3.2 Class.forName("oracle.jdbc.OracleDriver")..... new 객체 생성 ....

    4. JAVA CODE (CRUD) >> JDBC API 제공 받는다
        4.1 import java.sql.* >> interface , class 제공

        4.2 개발자는 interface 를 통해서 표준화된 DB 작업 수행
            POINT) why interface형태로 제공 >> JDBC API >> Oracle, Mysql , ....)
            //OracleConnection >> Connection 구현
            //MysqlConnection >> Connection 구현
            //다형성 Connection 부모타입 : 유연한 프로그래밍 작성
            >>다형성을 구현 (인터페이스 활용)
            import java.sql.Connection
            import java.sql.ResultSet
            import java.sql.Statement 등등

    5. 작업순서
        5.1 DB연결 -> 명령생성 -> 명령실행 -> 처리 -> 자원해제
        5.1 명령 : DDL (create , alter , drop)
            CRUD (insert , select , update , delete)
            실행 : 쿼리문을 DB서버에게 전달
            처리 : 결과를 받아서 화면 출력 , 또는 다른 프로그램에 전달 등등
            자원해제 : 연결해제

*/
public class Ex01_Oracle_Connection {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.OracleDriver"); //JVM 에 드라이버를 올리기. Class.forname( ) 활용
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("오라클 드라이버 로딩...");


        //Loading 된 드라이버를 통해서 Oracle 서버로 연결
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KOSA", "1004");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // 이렇게 하면 getConnection 까지는 나중에 다른 DB를 쓰면 매개변수만 바꿔주면 된다.

        try {
            System.out.println(conn.isClosed() + " : 결과로 false 가 나오면 연결 성공");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //명령객체를 거내오겠습니다.
        Statement stmt;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //CRUD를 명령 객체를 통해서 할 수 있습니다.
        String sql = "select empno, ename, sal from emp";
        ResultSet rs; //sql 결과를 ResultSet 이라는 객체를 통해서 받아오는데, 드라이버에서 생성됩니다.
        /*
            ResultSet 에는 데이터가 담겨 있지 않습니다.
            데이터는 DB Buffer 에 담겨 있구요.
            ResultSet 은 next( ) 함수를 통해서
            DB에 있는 정보를 가져오게 됩니다.
         */
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //실행 결과 처리
        while (true) {
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                System.out.println(
                        rs.getInt("empno") + " / " +
                        rs.getString("ename") + " / " +
                        rs.getInt("sal") + " / "
                        );
                ResultSetMetaData rsmd = rs.getMetaData(); //rs.getMetaData()를 이용하면, 결과에 대한 정보를 읽어들일 수 있습니다.
                System.out.println("Total columns : " + rsmd.getColumnCount());
                System.out.println("column name of 1st column : " + rsmd.getColumnName(1)); //column 의 index 는 1부터 시작합니다.
                System.out.println("column type name of 1st column : " + rsmd.getColumnTypeName(1));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        //자원해제
        try {
            stmt.close();
            rs.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println("DB연결 : " + conn.isClosed());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}











































