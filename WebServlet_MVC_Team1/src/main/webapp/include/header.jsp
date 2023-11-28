<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="header">
    <div class="title">
        <a href="${pageContext.request.contextPath}">DEMO WEBSITE</a>
    </div>
    <div class="links">
<%--        <a href="#">${pageContext.request.contextPath}</a>--%>
        <a href="#">추후등록</a>
        <a href="#">추후로그아웃</a>
    </div>
</div>

<div id="menu">
    <div>
        <ul>
<%--            <li><a href="${pageContext.request.contextPath}/board/board_list.jsp">BOARD LIST</a></li>--%>
<%--            <li><a href="${pageContext.request.contextPath}/board/board_write.jsp">BOARD WRITE</a></li>--%>
<%--            <li><a href="${pageContext.request.contextPath}/board.do?cmd=board_list.do">BOARD LIST</a></li>--%>
            <li><a href="board.do?cmd=board_list.do">BOARD LIST</a></li>
            <li><a href="board.do?cmd=board_write.do">BOARD WRITE</a></li>
        </ul>
    </div>
</div>

<div style="text-align:right; margin-top:1px; border:solid 1px; padding:5px">
    [ TOTAL : 명 ]
    [ CURRENT : 명 ]
</div>


<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>

<%--		<div id="header">--%>
<%--            <div class="title">--%>
<%--                <a href="/WebServlet_5_Board_Model1_Sample/">DEMO WEBSITE</a>--%>
<%--            </div>--%>
<%--            <div class="links">--%>
<%--                <a href="#"><%= request.getContextPath() %></a>--%>
<%--                <a href="#">추후등록</a>--%>
<%--                <a href="#">추후로그아웃</a>--%>

<%--            </div>--%>
<%--        </div>        --%>
<%--        <div id="menu">--%>
<%--            <div>--%>
<%--                <ul>--%>
<%--                	<!-- a : 페이지 이동을 처리하는 마크업 -->--%>
<%--                    <li><a href="<%= request.getContextPath() %>/board/board_list.jsp">BOARD LIST</a></li>--%>
<%--					<li><a href="<%= request.getContextPath() %>/board/board_write.jsp">BOARD WRITE</a></li>--%>
<%--					<li><a href="#"></a></li>--%>
<%--					<li><a href="#"></a></li>--%>
<%--                </ul>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div style="text-align:right;margin-top:1px;--%>
<%--        	border:solid 1px;padding:5px">--%>
<%--        	[ TOTAL : 명 ]--%>
<%--        	[ CURRENT : 명 ]--%>
<%--        </div>--%>
<%--        --%>
        
        
        
        
        
        
        
        
        
        
        