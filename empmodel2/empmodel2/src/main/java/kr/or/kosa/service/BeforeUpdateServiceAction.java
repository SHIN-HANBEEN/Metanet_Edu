package kr.or.kosa.service;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.EmpDao;
import kr.or.kosa.dto.Emp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

public class BeforeUpdateServiceAction implements Action {
    EmpDao dao = new EmpDao();
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
        ActionForward forward = new ActionForward();
        int empno = Integer.parseInt(request.getParameter("empno"));
        System.out.println(empno);
        Emp findEmp = dao.findEmpByEmpNo(empno);
        System.out.println(findEmp);
        if(findEmp!=null){
            request.setAttribute("emp", findEmp);
            forward.setPath("/WEB-INF/views/emp/updateEmp.jsp");
        } else {
            forward.setPath("/");
        }
        return forward;
    }
}
