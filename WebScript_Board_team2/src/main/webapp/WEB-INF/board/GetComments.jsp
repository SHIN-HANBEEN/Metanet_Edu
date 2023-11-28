<%@page import="java.io.Console"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.bit.dto.Reply"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.bit.service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%

    String idx = request.getParameter("idx");
    BoardService service = BoardService.getInBoardService();
    List<Reply> replylist = service.replyList(idx);

    Gson gson = new Gson();
    String json = gson.toJson(replylist);
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(json);

%>