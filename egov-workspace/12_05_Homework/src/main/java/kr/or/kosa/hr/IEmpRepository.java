package kr.or.kosa.hr;

import java.util.List;
import java.util.Map;

public interface IEmpRepository {
	int getEmpCount();
	int getEmpCount(int deptid);
	List<EmpVO> getEmpList();
	EmpVO getEmpInfo(int empid);
	void updateEmp(EmpVO emp);
	void insertEmp(EmpVO emp);
	void deleteJobHistory(int empid);
	int deleteEmp(int empid, String email);
	int deleteDepartment(int empid);
	List<Map<String, Object>> getAllJobId();
	List<Map<String,Object>> getAllManagerId();
	List<Map<String,Object>> getAllDeptId();
}
