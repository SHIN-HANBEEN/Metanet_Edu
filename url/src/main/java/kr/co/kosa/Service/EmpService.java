package kr.co.kosa.Service;

import java.util.List;

import kr.co.kosa.dao.EmpDao;
import kr.co.kosa.dto.EmpDto;

public class EmpService {

    private EmpDao empDao;

    public EmpService() {
        this.empDao = new EmpDao();
    }

    public List<EmpDto> getAllEmpData() {
        return empDao.getAllEmpData();
    }

    public List<EmpDto> getEmpDataByName(String name) {
        return empDao.getEmpDataByName(name);
    }

    public int createEmp(EmpDto dto, List<EmpDto> empList) {
        return empDao.createEmp(dto);
    }

    
    public int updateEmp(EmpDto dto) {
        EmpDao dao = new EmpDao();
        int result = 0;

        result = dao.updateEmp(dto);

        return result;
    }

    public int deleteEmp(int empno) {
        return empDao.deleteEmp(empno);
    }
}
