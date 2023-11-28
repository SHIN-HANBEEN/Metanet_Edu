package kr.or.bit.service;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.Board;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

public class WriteOkServiceAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws NamingException {

        System.out.println("WriteOkServiceAction");
        ActionForward forward = new ActionForward();
        Board board = new Board();
        System.out.println("=======================");
        String writer = request.getParameter("writer");
        String pwd = request.getParameter("pwd");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");
        System.out.println("=======================");

        String filename = "";
        if (request.getParameter("filename") == null) {
            filename = "none";
        } else {
            filename = request.getParameter("filename");
        }
        String homepage = request.getParameter("homepage");
        String email = request.getParameter("email");

        board.setWriter(writer);
        board.setPwd(pwd);
        board.setSubject(subject);
        board.setContent(content);
        board.setFilename(filename);
        board.setHomepage(homepage);
        board.setEmail(email);


        int result = new BoardDao().writeok(board);
        System.out.println("write ok result : " + result);

        //write.jsp 화면  >> writeok.jsp 처리 >> service >> dao > DB 작업 >
        //return dao > return service >  writeok.jsp 결과처리 >> 이동 (공통) >> redirect.jsp

        String msg="";
        String url="";
        if(result > 0){
            msg ="insert success";
            url ="/board.do/list.do";
        }else{
            msg="insert fail";
            url="/board.do/write.do";
        }

        request.setAttribute("board_msg",msg);
        request.setAttribute("board_url", url);

        forward.setPath("/board/redirect.jsp");
        return forward;
    }
}
