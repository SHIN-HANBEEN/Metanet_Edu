<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%
	String id = request.getParameter("ID");
	if(id.equals("hong")){
%>
	<%=id%><img src="images/1.jpg" style="width:100px;height:100px">
<%		
	}
%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>EL&JSTL</h3>
	<c:if test="${param.ID == 'hong'}">
		${param.ID}<img src="../images/1.jpg" style="width:100px;height:100px">
	</c:if>
	<!--  
	http://localhost:8090/WebJSP_EL_JSTL/Ex03_EL_JSTL.jsp?ID=hong&age=50
	age parameter  값이 20 보다 크면 나이 출력
	-->
	
	
</body>
</html>