package kr.or.kosa.controller;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.service.*;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.do")
public class BoardController extends HttpServlet {
    public BoardController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String command = request.getParameter("cmd");
        System.out.println(command);

        Action action = null;
        ActionForward forward = null;

        if (command.equals("content.do")) {
            action = new ContentServiceAction();
            forward = action.execute(request,response);
        } else if (command.equals("board_list.do")) {
            action = new Board_listServiceAction();
            forward = action.execute(request,response);
        } else if (command.equals("board_write.do")) {
            action = new Board_writeServiceAction();
            forward = action.execute(request,response);
        }


//        else if (command.equals("findAll.do")) {
//            action = new FindAllServiceAction();
//            forward = action.execute(request, response);
//        }
        if(forward != null) {
            if(forward.isRedirect()) { // true // location.href="" 새로운 페이지 처리
                response.sendRedirect(forward.getPath());
            }
//            else if (command.equals("checkEmp.do")&&!empno.isEmpty()) {
//                forward.setPath("/empadd.jsp");
//                RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
//                System.out.println(request.getAttribute("isNull"));
//                dis.forward(request, response);
//            }
            else {
                RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
                dis.forward(request, response);
            }
        }
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    @Override
    protected long getLastModified(HttpServletRequest req) {
        return super.getLastModified(req);
    }

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doHead(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doOptions(req, resp);
    }

    @Override
    protected void doTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doTrace(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
    }
}
