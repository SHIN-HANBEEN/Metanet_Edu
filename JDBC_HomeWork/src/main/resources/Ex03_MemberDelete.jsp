<%@page import="kr.or.bit.utils.Singleton_Helper"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:set var="userid" value="${sessionScope.userid}" />
<c:choose>
	<c:when test="${empty userid or userid eq 'admin'}">
		<c:redirect url="Ex02_JDBC_Login.jsp" />
	</c:when>
	<c:otherwise>
		<%
			String id = request.getParameter("id");

			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = Singleton_Helper.getConnection("oracle");
				String sql = "delete from koreamember where id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);

				int row = pstmt.executeUpdate();
				if (row > 0) {
		%>
		<script>
			location.href = 'Ex03_Memberlist.jsp';
		</script>
		<%
				} else {
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				Singleton_Helper.close(pstmt);
			}
		%>
	</c:otherwise>
</c:choose>

