<%--
  Created by IntelliJ IDEA.
  User: KOSA
  Date: 2023-11-22
  Time: 오후 3:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>forward 된 페이지 (request 라는 객체를 공유해서 사용할 수 있다)</h3>
    결과출력 방법 <br>
    1. scriptlet : <%= request.getAttribute("result")%> <br>

    2. EL : ${requestScope.result}<br>
</body>
</html>
