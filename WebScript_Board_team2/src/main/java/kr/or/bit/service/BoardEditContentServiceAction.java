package kr.or.bit.service;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.Board;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardEditContentServiceAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws NamingException, IOException {
		ActionForward forward = new ActionForward();
        //수정하기
        String idx = request.getParameter("idx");
        if(idx == null || idx.trim().equals("")){
            System.out.println("idx is null");
			forward.setRedirect(true);
            forward.setPath("list.do"); //cpage=1 , ps=5
            return forward;
        }
        Board board = new BoardDao().getEditContent(idx);
        if(board == null){
            response.getWriter().println("데이터 오류");
            response.getWriter().println("<hr><a href='board_list.jsp'>목록가지</a>");
        }

        request.setAttribute("board",board);//board 를 담아서 화면에 넘겨줌
        forward.setPath("/board/board_edit.jsp");
//        forward.setRedirect(true);
        return forward;
    }
}
