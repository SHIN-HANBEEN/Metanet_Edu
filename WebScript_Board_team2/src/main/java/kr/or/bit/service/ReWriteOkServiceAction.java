package kr.or.bit.service;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.Board;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.sql.Date;

public class ReWriteOkServiceAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, NamingException {
        ActionForward forward = new ActionForward();

        request.setCharacterEncoding("utf-8");
        Board board = new Board();
        String idx = request.getParameter("idx");
        String writer = request.getParameter("writer");
        String pwd = request.getParameter("pwd");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");
        String filename = request.getParameter("filename");
        String homepage = request.getParameter("homepage");
        String email = request.getParameter("email");

        board.setIdx(Integer.parseInt(idx));
        board.setWriter(writer);
        board.setPwd(pwd);
        board.setSubject(subject);
        board.setContent(content);
        board.setFilename(filename);
        board.setHomepage(homepage);
        board.setEmail(email);

        int result = new BoardDao().reWriteOk(board);

        //list 이동시 현재 pagesize , cpage
        String cpage = request.getParameter("cp"); //current page
        String pagesize = request.getParameter("ps"); //pagesize
        //코드는 필요에 따라서  url ="board_list.jsp?cp=<%=cpage";
        String msg="";
        String url="";
        if(result > 0){
            msg ="rewrite insert success";
            url ="list.do";
        }else{
            msg="rewrite insert fail";
            url="content.do?idx="+board.getIdx();
        }

        request.setAttribute("board_msg",msg);
        request.setAttribute("board_url", url);

        forward.setPath("board/redirect.jsp");

        return forward;
    }
}
