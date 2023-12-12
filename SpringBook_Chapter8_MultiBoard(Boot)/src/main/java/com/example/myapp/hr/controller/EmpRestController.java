package com.example.myapp.hr.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public EmpVO insertEmp(@RequestBody EmpVO emp) {
		empService.insertEmp(emp); //insert 의 결과가 void 이기 때문에 그냥 VO 를 반환했다.
		// 이것이 부담되고 싫다면, 그냥 "Fail" 혹은 "Success" 같은 문자열을 반환하도록 해도 됩니다. 
//		if(emp.equals("") || emp==null) {
//			return "Fail";
//		} else { 
//			return "Success";
//		}
		
		return emp;
	}

	@PutMapping("/emp/update")
	public EmpVO updateEmp(@RequestBody EmpVO emp) {
		System.out.println(emp);
		empService.updateEmp(emp);
		return emp;
	}
	
//	@DeleteMapping("/emp/delete")
//	public int deleteEmp(@RequestBody int empid, @RequestBody String email) {
//		return empService.deleteEmp(empid, email);
//	}
	
	@DeleteMapping("/emp/delete") //@RequestBody 는 기본형 여러개를 그냥 받을 수 없고 아래처럼 Map 으로 받아야 한다.
	public int deleteEmp(@RequestBody Map<String, Object> requestBody) {
	    int empid = (int) requestBody.get("empid");
	    String email = (String) requestBody.get("email");
	    return empService.deleteEmp(empid, email);
	}

}
