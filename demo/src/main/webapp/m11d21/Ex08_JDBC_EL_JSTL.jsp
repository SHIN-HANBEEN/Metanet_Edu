<%@ page import="kr.or.kosa.dao.DeptDao" %>
<%@ page import="java.util.List" %>
<%@ page import="kr.or.kosa.dto.Dept" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    DeptDao dao = new DeptDao();
    List<Dept> deptAllList = dao.getDeptAllList();
    request.setAttribute("dtoList", deptAllList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <tbody>
        <c:forEach var="dept" items="${requestScope.dtoList}">
            <tr>
                <td>${dept.deptno}</td>
                <td>${dept.dname}</td>
                <td>${dept.loc}</td>
            </tr>
        </c:forEach>
    </tbody>

</body>
</html>