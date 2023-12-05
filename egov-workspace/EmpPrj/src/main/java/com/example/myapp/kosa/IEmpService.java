package com.example.myapp.kosa;

import java.util.List;

public interface IEmpService {
	int getEmpCount(int deptid);
	String getEmpNameByEmployeeId(int employeeId);
	EmpVO getEmp(int empno);
	List<EmpVO> getAllEmps();
}
