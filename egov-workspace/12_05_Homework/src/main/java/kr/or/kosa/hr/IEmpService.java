package kr.or.kosa.hr;

import java.util.List;
import java.util.Map;

public interface IEmpService {
	int getEmpCount();
	int getEmpCount(int deptid);
	List<EmpVO> getEmpList();
	EmpVO getEmpInfo(int empid);
	void updateEmp(EmpVO emp);
	void insertEmp(EmpVO emp);
	int deleteEmp(int empId, String email); //delete department, job_history 같이 삭제해야함
	List<Map<String, Object>> getAllJobId();
	List<Map<String,Object>> getAllManagerId();
	List<Map<String,Object>> getAllDeptId();
}
