package kr.or.bit.service;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class ReplyWriteServiceAction  {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, NamingException {
        //한글처리
        System.out.println("ReplyWriteServiceAction start");
        ActionForward forward = new ActionForward();
        request.setCharacterEncoding("UTF-8");
        //데이터 받기
        String writer = request.getParameter("reply_writer");
        String content = request.getParameter("reply_content");
        String pwd = request.getParameter("reply_pwd");
        int idx_fk = Integer.parseInt(request.getParameter("idx"));
        String userid = "empty";
        //service 객체 생성
        int result = new BoardDao().replywrite(idx_fk, writer, userid, content, pwd);

        //처리하는 코드
        response.setContentType("application/json");
        request.setCharacterEncoding("UTF-8");
        PrintWriter outWriter = response.getWriter();
        if(result  > 0) {
            outWriter.print("{\"success\": true, \"message\": \"댓글 입력 성공\"}");
        }
        else {
            outWriter.print("{\"success\": false, \"message\": \"댓글 입력 실패\"}");
        }
        outWriter.close();



        //처리하는 코드
//        String msg="";
//        String url="";
//
//        if(result > 0){
//            msg ="댓글 입력 성공";
//            url ="content.do?idx="+idx_fk;
//        }else{
//            msg="댓글 입력 실패";
//            url="content.do?idx="+idx_fk;
//        }
//
//        request.setAttribute("board_msg",msg);
//        request.setAttribute("board_url", url);
//
//        forward.setPath("board/redirect.jsp");
//
//        System.out.println("ReplyWriteServiceAction end");
    }
}
