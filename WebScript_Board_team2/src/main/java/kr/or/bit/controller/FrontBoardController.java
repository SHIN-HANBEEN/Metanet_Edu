package kr.or.bit.controller;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.service.*;
import lombok.SneakyThrows;

import javax.naming.NamingException;
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
public class FrontBoardController extends HttpServlet {
    public FrontBoardController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NamingException {
        request.setCharacterEncoding("UTF-8");
        System.out.println("doProcess");

        //String path = request.getRequestURI().replaceAll(request.getContextPath(), "");
        String fullPath = request.getRequestURI();
        System.out.println("full path : " + fullPath);
        int lastIndex = fullPath.lastIndexOf('/');
        String path = fullPath.substring(lastIndex + 1);

        System.out.println("path : " + path);
        System.out.println("=========");

        Action action = null;
        ActionForward forward = null;
        String viewpage = "";

        if (path.equals("writeok.do")) {
            System.out.println("writeok.do");
            action = new WriteOkServiceAction();
            forward = action.execute(request,response);
        } else if (path.equals("list.do")) {
            System.out.println("list.do");
            action = new ListServiceAction();
            System.out.println("ListServiceAction created");
            forward = action.execute(request, response);
        } else if (path.equals("totalBoardCount.do")) {
            action = new TotalBoardCountServiceAction();
            forward = action.execute(request, response);
        } else if(path.equals("content.do")){
            action = new ContentServiceAction();
            forward = action.execute(request, response);
        } else if (path.equals("boardDelete.do")) {
            action = new BoardDeleteServiceAction();
            forward = action.execute(request, response);
        } else if (path.equals("replyWrite.do")) {
            ReplyWriteServiceAction action1 = new ReplyWriteServiceAction();
            action1.execute(request,response);
//            forward = action.execute(request, response);
        } else if (path.equals("replyList.do")) {
            action = new ReplyListServiceAction();
            forward = action.execute(request, response);
        } else if (path.equals("replyDelete.do")) {
            ReplyDeleteServiceAction action1 = new ReplyDeleteServiceAction();
            action1.execute(request, response);
        } else if (path.equals("rewriteok.do")) {
            action = new ReWriteOkServiceAction();
            forward = action.execute(request, response);
        } else if (path.equals("boardEditContent.do")) {
            action = new BoardEditContentServiceAction();
            forward = action.execute(request, response);
        } else if (path.equals("boardEdit.do")) {
            action = new BoardEditServiceAction();
            forward = action.execute(request, response);
        } else if (path.equals("boardDeleteContent.do")) {
            action = new BoardDeleteContentServiceAction();
            forward = action.execute(request, response);
        } else if (path.equals("rewriteContent.do")) {
            action = new ReWriteContentServiceAction();
            forward = action.execute(request, response);
        }
        if(forward != null) {
            System.out.println("forward not null");
            if(forward.isRedirect()) { // true // location.href="" 새로운 페이지 처리
                System.out.println("forward is redirect");
                response.sendRedirect(forward.getPath());
            } else {
                System.out.println("forward is not redirect");
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
