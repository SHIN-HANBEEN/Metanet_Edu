package kr.co.metanet.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService implements IEmpService {
	
	@Autowired
	IEmpRepository emprepository;
	
	public EmpService() {}

	@Override
	public int getEmpCount() {
		System.out.println("empService.getEmpCount");
		return emprepository.getEmpCount();
	}
	
	public EmpService(IEmpRepository empRepository) {
		this.emprepository = empRepository;
	}
	
	public void setEmpRepository(IEmpRepository empRepository) {
		this.emprepository = empRepository;
	}
	
}
