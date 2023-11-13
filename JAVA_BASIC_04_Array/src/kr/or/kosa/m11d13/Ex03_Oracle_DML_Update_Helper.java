package kr.or.kosa.m11d13;

import kr.or.kosa.m11d13.utils.ConnectionHelper;

import java.sql.Connection;
import java.sql.SQLException;

public class Ex03_Oracle_DML_Update_Helper {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        conn = ConnectionHelper.getConnection("oracle");
        System.out.println(conn.toString());
        System.out.println(conn.getMetaData().getDatabaseProductName());
        System.out.println(conn.getMetaData().getDatabaseProductVersion());
        System.out.println(conn.isClosed()); //false 가 나오길 유도해야하죠.
        ConnectionHelper.close(conn); //연결 닫는 것도 너무 편리해지네요.
        System.out.println(conn.isClosed()); //여기서는 true 가 됩니다.
    }
}
