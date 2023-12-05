package com.example.myapp.kosa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService implements IEmpService{
	@Autowired
	IEmpRepository empRepository;

	@Override
	public int getEmpCount(int deptNo) {
		// TODO Auto-generated method stub
		return empRepository.getEmpCount(deptNo);
	}

	public void setEmpRepository(IEmpRepository empRepository) {
		this.empRepository = empRepository;
	}

	@Override
	public String getEmpNameByEmployeeId(int empNo) {
		// TODO Auto-generated method stub
		return empRepository.getEmpNameByEmployeeId(empNo);
	}

	@Override
	public EmpVO getEmp(int empno) {
		// TODO Auto-generated method stub
		return empRepository.getEmp(empno);
	}

	@Override
	public List<EmpVO> getAllEmps() {
		// TODO Auto-generated method stub
		return empRepository.getAllEmps();
	}	
}
