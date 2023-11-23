package kr.or.kosa.controller;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.EmpDao;
import kr.or.kosa.dto.Emp;
import kr.or.kosa.service.*;
import lombok.SneakyThrows;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("*.do")
public class EmpController extends HttpServlet {
    public EmpController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, java.text.ParseException {
        request.setCharacterEncoding("UTF-8");
        String command = request.getParameter("cmd");
        Action action = null;
        ActionForward forward = null;
        EmpDao dao = new EmpDao();

        String viewpage = "";

        if (command.equals("findOne.do")) {
            action = new FindOneServiceAction();
            forward = action.execute(request,response);
        } else if (command.equals("findAll.do")) {
            action = new FindAllServiceAction();
            forward = action.execute(request, response);
        } else if (command.equals("addEmp.do")) {
            action = new AddServiceAction();
            forward = action.execute(request, response);
        } else if(command.equals("beforeUpdate.do")){
            action = new BeforeUpdateServiceAction();
            forward = action.execute(request, response);
        } else if (command.equals("updateEmp.do")) {
            action = new UpdateServiceAction();
            forward = action.execute(request, response);
        } else if (command.equals("deleteEmp.do")) {
            action = new DeleteServiceAction();
            forward = action.execute(request, response);
        }

        if(forward != null) {
            if(forward.isRedirect()) { // true // location.href="" 새로운 페이지 처리
                response.sendRedirect(forward.getPath());
            }else {
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
