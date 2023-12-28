package com.example.myapp.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.hr.model.EmpVO;
import com.example.myapp.hr.service.IEmpService;

@RestController
@RequestMapping("/hr")
public class EmpRestController {
	
	@Autowired
	IEmpService empService;
	
	@GetMapping("/emp/list")
	public List<EmpVO> getAllEmps() {
		return empService.getEmpList();
	}
	
	@GetMapping("/emp/{empid}")
	public EmpVO getEmp(@PathVariable int empid) {
		return empService.getEmpInfo(empid);
	}
	
	@PostMapping("/emp/insert")
	public String insertEmp(@RequestBody EmpVO emp) {
		try {
			empService.insertEmp(emp);
		}catch(Exception e) {
			return "Fail";
		}
		return "Success";
	}

	@PutMapping("/emp/update")
	public EmpVO updateEmp(@RequestBody EmpVO emp) {
		System.out.println(emp);
		empService.updateEmp(emp);
		return emp;
	}
	
	@DeleteMapping("/emp/delete/{empid}")
	public int deleteEmp(@PathVariable int empid, @RequestParam String email) {
		System.out.println(empid + " " + email);
		return empService.deleteEmp(empid, email);
	}
}
