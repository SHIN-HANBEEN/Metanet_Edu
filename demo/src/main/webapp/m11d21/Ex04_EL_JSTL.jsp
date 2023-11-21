<%--
  Created by IntelliJ IDEA.
  User: KOSA
  Date: 2023-11-21
  Time: 오전 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    EL parameter : ${param.id} - ${param.pwd} <br>
    <h3>param 값을 변수에 저장하려면? JSTL 사용</h3>
    <c:set var="userid" value="${param.id}" />
    <c:set var="userpwd" value="${param.pwd}" />

    <h3>담은 다음에 출력하는 것은 더 간단합니다</h3>
    id : ${userid} <br>
    pwd : ${userpwd} <br>

    <h3>변수값 출력</h3>
    id : ${userid} <br>
    pwd : ${userpwd} <br>

    <c:if test="${!empty userpwd}">
        <h3>not empty password</h3>
        <c:if test="${userpwd == '1004'}">
            <h3>welcome admin ^^</h3>
        </c:if>
    </c:if>
</body>
</html>
