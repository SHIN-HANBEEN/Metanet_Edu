package kr.or.kosa.service;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.EmpDao;
import kr.or.kosa.dto.Emp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CheckEmpServiceAction implements Action {
    EmpDao dao = new EmpDao();

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("application/json;charset=UTF-8");

        int empno = Integer.parseInt(request.getParameter("empno"));
        EmpDao dao = new EmpDao();
        Emp findEmp = dao.findEmpByEmpNo(empno);
        boolean isNull;
        if (findEmp == null) {
            isNull = true;
        } else {
            isNull = false;
        }

        // Create a JSON object
        String jsonResult = "{\"isNull\": " + isNull + "}";

        // Write the JSON response to the PrintWriter
        try (PrintWriter out = response.getWriter()) {
            ((PrintWriter) out).print(jsonResult);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null; // Since you're handling the response directly, no need to forward
    }


//    @Override
//    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
//        ActionForward forward = new ActionForward();
//        System.out.println(request.getParameter("empno"));
//        int empno = Integer.parseInt(request.getParameter("empno"));
//        Emp findEmp = dao.findEmpByEmpNo(empno);
//        if(findEmp==null){
//            request.setAttribute("isNull", true);
//        } else {
//            request.setAttribute("isNull", false);
//        }
//        return forward;
//    }


}
