package kr.co.kosa.Service;

import kr.co.kosa.Action.Action;
import kr.co.kosa.Action.ActionForward;
import kr.co.kosa.dao.EmpDao;
import kr.co.kosa.dto.EmpDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class EmpListServiceAction implements Action {
    EmpDao dao = new EmpDao();
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
        ActionForward forward = new ActionForward();
        List<EmpDto> empList;

        String searchName = request.getParameter("searchName");
        if (searchName != null && !searchName.isEmpty()) {
            // 검색 이름이 제공된 경우, 데이터베이스에서 필터링된 데이터 검색
            empList = dao.getEmpDataByName(searchName);
        } else {
            // 검색 이름이 제공되지 않은 경우, 데이터베이스에서 모든 데이터 검색
            empList = dao.getAllEmpData();
        }

        // 요청 속성에 데이터 설정
        request.setAttribute("empList", empList);

        // 표시를 위해 emp.jsp로 전달
        forward.setPath("/WEB-INF/views/emp/emplist.jsp");

        return forward;
    }
}
