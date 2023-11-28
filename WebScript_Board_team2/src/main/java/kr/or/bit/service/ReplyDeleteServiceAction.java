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

public class ReplyDeleteServiceAction {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws NamingException, IOException {
//        ActionForward forward = new ActionForward();
        String idx_fk = request.getParameter("idx");//댓글의 원본 게시글 번호
        String no = request.getParameter("no");//댓글의 순번(PK)
        String pwd = request.getParameter("delPwd");//댓글의 암호
        System.out.println(idx_fk + "/" + no + "/" + pwd + "/");
//        if (idx_fk == null || no == null || pwd == null || no.trim().equals("")) {
//
//            forward.setRedirect(true);
//            forward.setPath("");
//            return forward;
//        }

        //parameter 정상인 경우
        int result = new BoardDao().replyDelete(no, pwd);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter outWriter = response.getWriter();
        if(result  > 0) {
            outWriter.print("{\"success\": true, \"message\": \"댓글 삭제 성공\"}");
        }
        else {
            outWriter.print("{\"success\": false, \"message\": \"댓글 삭제 실패\"}");
        }
        outWriter.close();

//        //처리하는 코드
//        String msg = "";
//        String url = "";
//
//        if (result > 0) {
//            msg = "댓글 삭제 성공";
//            url = "content.do?idx=" + idx_fk;
//        } else {
//            msg = "댓글 삭제 실패";
//            url = "content.do?idx=" + idx_fk;
//        }
//
//        request.setAttribute("board_msg", msg);
//        request.setAttribute("board_url", url);
//
//        forward.setPath("board/redirect.jsp");
//
//        return forward;
    }
}
