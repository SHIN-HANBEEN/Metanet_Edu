package kr.or.bit.service;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.Board;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardDeleteContentServiceAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws NamingException, IOException {
        ActionForward forward = new ActionForward();

        forward.setPath("/board/board_delete.jsp");

        return forward;
    }
}
