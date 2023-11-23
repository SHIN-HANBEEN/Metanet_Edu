package kr.or.kosa.service;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.EmpDao;
import kr.or.kosa.dto.Emp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindOneServiceAction implements Action {
    EmpDao dao = new EmpDao();
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
        ActionForward forward = new ActionForward();
        String ename = request.getParameter("ename");
        Emp findEmp = dao.findEmpByName(ename);
        request.setAttribute("emp", findEmp);
        forward.setPath("/WEB-INF/views/emp/showemp.jsp");

        return forward;
    }
}
