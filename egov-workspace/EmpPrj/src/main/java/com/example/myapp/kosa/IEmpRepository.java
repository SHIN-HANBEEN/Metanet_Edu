package com.example.myapp.kosa;

import java.util.List;

public interface IEmpRepository {
	int getEmpCount(int deptid);
	String getEmpNameByEmployeeId(int employeeId);
	EmpVO getEmp(int empno);
	List<EmpVO> getAllEmps();
}
