package kr.co.metanet.myapp;

public class EmpService implements IEmpService {
	IEmpRepository empRepository;
	

	public EmpService(EmpRepository empRepository) {
		this.empRepository = empRepository;
	}

	@Override
	public int getEmpCount() {
		// TODO Auto-generated method stub
		return empRepository.getEmpCount();
	}

}
