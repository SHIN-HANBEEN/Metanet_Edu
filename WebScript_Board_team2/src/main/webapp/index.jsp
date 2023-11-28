<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="java.sql.SQLException" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="Stylesheet" href="style/default.css">
</head>
<body>
<jsp:include page="/include/header.jsp"/>

<div id="pageContainer">
    <h3>UI(Css 공통 페이지 적용 확인)</h3>
    <h3>DB연결 정보 확인</h3>
    <%
        Connection conn = null;

        try {
            Context context = new InitialContext();
            DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");

            conn = ds.getConnection();
            out.print("db 연결여부 : " + conn.isClosed() + "<br>");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        // Now, you cannot use 'conn' here after it's closed.
    %>
    <%--  <%--%>
    <%--    Connection conn = null;--%>

    <%--    Context context = new InitialContext(); //현재 프로젝트에 이름기반 검색--%>
    <%--    DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");//java:comp/env/ + name--%>

    <%--    //POOL안에서 connection 가지고 오기--%>
    <%--    conn = ds.getConnection();--%>

    <%--    out.print("db 연결여부 : " + conn.isClosed() + "<br>");--%>

    <%--    //POINT--%>
    <%--    //POOL에 connection 받환하기--%>
    <%--    conn.close(); //반환하기--%>

    <%--    out.print("db 연결여부 : " + conn.isClosed() + "<br>");--%>
    <%--  %>--%>
</div>
</body>
</html>