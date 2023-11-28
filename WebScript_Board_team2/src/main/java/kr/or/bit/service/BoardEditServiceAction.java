package kr.or.bit.service;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardEditServiceAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException, NamingException {
        ActionForward forward = new ActionForward();
        //1. board_edit.jsp > 입력값 받기 > board dto 객체에 담기

        //방법 1) request.getParameter("subject") > new Board > setter > request > return Board
        //가장 일반적인 방법

        //방법 2) usebean 액션태그 (property )통해서 setter  주입


        //방법 3) request 객체를 통으로 넘기는 방법 (이 방법) >> 실습코드 ...

        request.setCharacterEncoding("UTF-8");
        String idx = request.getParameter("idx");

        if (idx == null || idx.trim().equals("")) {
            response.getWriter().println("<script>");
            response.getWriter().println("alert('글번호 입력 오류')");
            response.getWriter().println("location.href='board_list.jsp'");
            response.getWriter().println("</script>");
        }

        int result = new BoardDao().boardEdit(request);

        String msg = "";
        String url = "";
        if (result > 0) {
            msg = "edit success";
            url = "list.do";
        } else {
            msg = "edit fail";
            url = "board_edit.jsp?idx=" + idx;
        }

        request.setAttribute("board_msg", msg);
        request.setAttribute("board_url", url);

        forward.setPath("board/redirect.jsp");
        return forward;
    }
}
