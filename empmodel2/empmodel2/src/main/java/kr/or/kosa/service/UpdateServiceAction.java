package kr.or.kosa.service;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.EmpDao;
import kr.or.kosa.dto.Emp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

public class UpdateServiceAction implements Action {
    EmpDao dao = new EmpDao();
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
        ActionForward forward = new ActionForward();
        int empno = Integer.parseInt(request.getParameter("empno"));
        String ename = request.getParameter("ename");
        String job = request.getParameter("job");
        int mgr = Integer.parseInt(request.getParameter("mgr"));
        Date hiredate = java.sql.Date.valueOf(request.getParameter("hiredate"));
        int sal = Integer.parseInt(request.getParameter("sal"));
        int comm = Integer.parseInt(request.getParameter("comm"));
        int deptno = Integer.parseInt(request.getParameter("deptno"));


        Emp emp = new Emp();
        emp.setEmpno(empno);
        emp.setEname(ename);
        emp.setJob(job);
        emp.setMgr(mgr);
        emp.setHiredate(hiredate);
        emp.setSal(sal);
        emp.setComm(comm);
        emp.setDeptno(deptno);

        dao.updateEmp(emp);
        forward.setPath("index.jsp");

        return forward;
    }
}
