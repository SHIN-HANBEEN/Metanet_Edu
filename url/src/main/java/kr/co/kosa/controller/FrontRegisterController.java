package kr.co.kosa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kosa.Action.Action;
import kr.co.kosa.Action.ActionForward;
import kr.co.kosa.Service.AddServiceAction;
import kr.co.kosa.Service.EmpListServiceAction;
import kr.co.kosa.Service.EmpService;
import kr.co.kosa.dto.EmpDto;

@WebServlet("*.do")
public class FrontRegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmpService empService;

    public FrontRegisterController() {
        super();
        this.empService = new EmpService();
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Action ac = null;
        ActionForward forward = null;

        String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String urlcommand = requestUri.substring(contextPath.length());

        System.out.println("requestUri : " + requestUri);
        System.out.println("contextPath : " + contextPath);
        System.out.println("urlcommand : " + urlcommand);

        String viewPage = "";

        if (urlcommand.equals("/emp.do")) {
            String action = request.getParameter("action");

            if ("list".equals(action) || action == null) {
                // 데이터베이스에서 데이터 검색
                ac = new EmpListServiceAction();
                forward = ac.execute(request,response);
            } else if("createEmp".equals(action)) {
                forward = new ActionForward();
                forward.setRedirect(true);
                forward.setPath("index2.jsp");
            } else if ("create".equals(action)) {
                // 생성(삽입) 로직 처리

                System.out.println("===============");
                ac = new AddServiceAction();
                forward = ac.execute(request, response);

            }else if("updateEmp".equals(action)) {
                forward = new ActionForward();
                forward.setRedirect(true);
                forward.setPath("index3.jsp");
            } else if ("update".equals(action)) {

            } else if ("delete".equals(action)) {
                // 삭제 로직 처리
                int empnoToDelete = Integer.parseInt(request.getParameter("empno"));
                empService.deleteEmp(empnoToDelete);
                // 적절한 페이지로 리디렉션 또는 전달
                viewPage = "emp.do?action=list";
            }
        }

        if(forward != null) {
            if(forward.isRedirect()) { // true // location.href="" 새로운 페이지 처리
                response.sendRedirect(forward.getPath());
            } else {
                RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
                dis.forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProcess(request, response);
    }
}
