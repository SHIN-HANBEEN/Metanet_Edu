package kr.or.kosa.m11d14.mvc.utils;

import java.sql.*;

public class ConnectionHelper {
    //자주 쓰게 될 함수이니, static 을 가져갑니다.
    // 리턴 타입은 다형성을 위해 인터페이스인 Connection 을 반환합니다.
    public static Connection getConnection(String dsn) {
        Connection conn = null;
        try {
            if(dsn.equals("oracle")) {
                conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KOSA", "1004");
            } else if (dsn.equals("mariadb")) {
                conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KOSA", "1004");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn; //여기서 반환되는 conn 은 oracle 일수도, mariadb 일수도 있다.
    }

    //오버로딩 통해서 다른 아이디와 비번도 사용가능하도록 해주기
    public static Connection getConnection(String dsn, String id, String pw) {
        Connection conn = null;
        try {
            if(dsn.equals("oracle")) {
                conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", id, pw);
            } else if (dsn.equals("mariadb")) {
                conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", id, pw);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn; //여기서 반환되는 conn 은 oracle 일수도, mariadb 일수도 있다.
    }

    // Connection 닫아주는 코드도 반복되니까 여기다 만들어주자.
    public static void close(Connection conn) {
        if(conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void close(ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void close(Statement stmt) {
        if(stmt != null) {
            try {
                stmt.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void close(PreparedStatement pstmt) {
        if(pstmt != null) {
            try {
                pstmt.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
