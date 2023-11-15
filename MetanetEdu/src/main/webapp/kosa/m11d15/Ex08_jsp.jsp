<%@ page language

$>
<%
    //자바 코드는 여기에 구현합니다.
    //jsp 는 view 의 역할만 합니다.

    String userid = request.getParameter("id");
    String pwd = request.getParameter("pwd");

%>

<body>
    <%= userid %>
    <%= pwd %>
</body>