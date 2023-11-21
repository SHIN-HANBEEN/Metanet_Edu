<%--
  Created by IntelliJ IDEA.
  User: KOSA
  Date: 2023-11-21
  Time: 오후 2:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    // ~?hobby=농구&hobby=야구 이렇게 해놓으면 배열로 받아옵니다.
    String[] hobbys = request.getParameterValues("hobby");
    // 그래서 위와 같이 받아오게 되는 것이죠.
    // EL 로는 어떻게 받게 될까요?

    // EL
    // getParameterValues >> EL 로는 ${paramValues.hobby} 로 받을 수 있습니다.
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>다중값처리</h3>
<c:choose>
    <c:when test="${not empty paramValues.hobby}">
        당신의 선택은
        <ul>
            <c:forEach var="hobby" items="${paramValues.hobby}" varStatus="status">
                <li>${hobby}-${status} :::: ${status.index}-${status.count}</li><!-- EL의 varStatus 를 통해 상태 정보를 볼 수 있다.-->
            </c:forEach>
        </ul>
    </c:when>
    <c:otherwise>
        선택을 하세요 <br>
    </c:otherwise>
</c:choose>
</body>
</html>
