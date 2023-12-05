package kr.or.kosa.hr;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmpController {
	@Autowired
	IEmpService empService;
	
	int getEmpCount() {
		return empService.getEmpCount();
	}
	int getEmpCount(int deptid) {
		return empService.getEmpCount(deptid);
	}
	List<EmpVO> getEmpList() {
		return empService.getEmpList();
	}
	EmpVO getEmpInfo(int empid) {
		return empService.getEmpInfo(empid);
	}
	void updateEmp(EmpVO emp) {
		empService.updateEmp(emp);
	}
	void insertEmp(EmpVO emp) {
		empService.insertEmp(emp);
	}
	int deleteEmp(int empId, String email) {
		return empService.deleteEmp(empId, email);
		//delete department, job_history 같이 삭제해야함
	}
	List<Map<String, Object>> getAllJobId() {
		return empService.getAllJobId();
	}
	List<Map<String,Object>> getAllManagerId() {
		return empService.getAllManagerId();
	}
	List<Map<String,Object>> getAllDeptId() {
		return empService.getAllDeptId();
	}
}
