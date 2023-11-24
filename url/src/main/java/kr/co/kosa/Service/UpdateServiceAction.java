package kr.co.kosa.Service;

import kr.co.kosa.Action.Action;
import kr.co.kosa.Action.ActionForward;
import kr.co.kosa.dao.EmpDao;
import kr.co.kosa.dto.EmpDto;

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


        EmpDto emp = new EmpDto();
        emp.setEMPNO(empno);
        emp.setENAME(ename);
        emp.setJOB(job);
        emp.setMGR(mgr);
        emp.setHITRDATE(hiredate);
        emp.setSAL(sal);
        emp.setCOMM(comm);
        emp.setDEPTNO(deptno);

        dao.updateEmp(emp);
        forward.setPath("index.jsp");

        return forward;
    }
}
