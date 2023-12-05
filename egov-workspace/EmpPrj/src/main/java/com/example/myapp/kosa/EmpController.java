package com.example.myapp.kosa;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmpController {
	@Autowired
	IEmpService empService;
		 
	public void printInfo() { 
		int count = empService.getEmpCount(30);
		System.out.println("사원의 수 : " + count);
	}
	
	public void getEmpNameByEmployeeId(int empNo) {
		String ename = empService.getEmpNameByEmployeeId(empNo);
		System.out.println(empNo + "사번의 이름은 " + ename + " 입니다.");
	}

	public void setEmpService(IEmpService empService) {
		this.empService = empService;
	}
	
	public void getEmp(int empno) {
		EmpVO empVO = empService.getEmp(empno);
		System.out.println(empVO);
	}
	
	public void getAllEmps() {
		List<EmpVO> empList = empService.getAllEmps();
		System.out.println(empList);
	}
}
