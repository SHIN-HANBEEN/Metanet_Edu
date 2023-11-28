package kr.or.bit.service;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class BoardDeleteServiceAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, NamingException {
        ActionForward forward = new ActionForward();
        request.setCharacterEncoding("UTF-8");
        String idx = request.getParameter("idx");
        String pwd = request.getParameter("pwd");

        int result = new BoardDao().deleteOk(idx, pwd);

        String msg="";
        String url="";
        if(result > 0){
            msg="delete success";
            url="list.do";
        }else{
            msg="delete fail";
            url="list.do";
        }

        request.setAttribute("board_msg",msg);
        request.setAttribute("board_url",url);

        forward.setPath("board/redirect.jsp");

        return forward;
    }
}
