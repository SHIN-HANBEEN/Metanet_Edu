<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--scriptlet--%>
<%
//	String name= request.getParameter("name");
//	if(name.equals("kglim")){
//		out.print("<b>" + name + "</b>");
//	}else if(name.equals("hong")){
//		out.print("<i>" + name + "</i>");
//	}else{
//		out.print("<h3>" + name + "</h3>");
//	}
//	out.print("<hr>");


%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>EL & JSTL 으로 전환</h3>
	<c:set var="name" value="${param.name}" />

	<c:choose>
		<c:when test="${name eq 'kglim'}">
			<b>${name}</b>
		</c:when>
		<c:when test="${name eq 'hong'}">
			<i>${name}</i>
		</c:when>
		<c:otherwise>
			<h3>${name}</h3>
		</c:otherwise>
	</c:choose>
</body>



</html>