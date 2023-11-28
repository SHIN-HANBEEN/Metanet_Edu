<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  String msg = (String)request.getAttribute("board_msg");
  String url = (String)request.getAttribute("board_url");
  
  if(msg != null && url != null){
%>
	<script>
		alert('${requestScope.board_msg}');
	    location.href='${requestScope.board_url}';
	</script>
	
<%	  
  }
%>