<%--
  Created by IntelliJ IDEA.
  User: KOSA
  Date: 2023-11-21
  Time: 오후 2:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach var="i" begin="0" end="10"> <!-- JSTL 의 변수 값은 EL 로 바로 표현 가능-->
        ${i} <br>
        <c:set var="sum" value="${sum+i}"/>
    </c:forEach>
    sum : ${sum}<br>

    <ul>
        <c:forEach var="i" begin="1" end="9">
            <li>3*${i}=${3*i}</li>
        </c:forEach>
    </ul>

    <h3>구구단 출력</h3>
    <c:forEach var="i" begin="2" end="9">
        <c:forEach var="j" begin="0" end="9">
            <c:choose>
                <c:when test="${j == 0}">
                    ${i}단
                </c:when>
                <c:otherwise>
                    <li>${i}*${j}=${i*j}</li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </c:forEach>

    <h3>JSTL forEach</h3>
    <%
        int[] arr = new int[]{10, 20, 30, 40, 50};
        for(int i : arr) {
            System.out.println(i);
        }
        // 문제는 EL 은 자바 객체에 접근이 불가능합니다. 그래서
        // request, session 과 같은 객체에 담게 됩니다. 그래서
        // 아래 있는 코드와 같이 적는 것은 정말 안 이쁜 코드입니다.

        // 대신 아래와 같이 합니다.
        request.setAttribute("intarr", arr); //이렇게 말이죠
    %>
    <c:set var="intarray" value="<%=arr %>" />

    <c:forEach var="data" items="${requestScope.intarr}" >
        배열 값 : ${data}<br>
    </c:forEach>
</body>
</html>
