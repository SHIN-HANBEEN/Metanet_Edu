package kr.or.kosa.hr;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpService implements IEmpService{
	
	@Autowired
	IEmpRepository empRepository;

	@Override
	public int getEmpCount() {
		return empRepository.getEmpCount();
	}

	@Override
	public int getEmpCount(int deptid) {
		return empRepository.getEmpCount(deptid);
	}

	@Override
	public List<EmpVO> getEmpList() {
		return empRepository.getEmpList();
	}

	@Override
	public EmpVO getEmpInfo(int empid) {
		return empRepository.getEmpInfo(empid);
	}

	@Override
	public void updateEmp(EmpVO emp) {
		empRepository.updateEmp(emp);
	}

	@Override
	public void insertEmp(EmpVO emp) {
		empRepository.insertEmp(emp);
	}

	@Transactional
	@Override
	public int deleteEmp(int empid, String email) {
//		empRepository.deleteDepartment(empid);
//		empRepository.deleteJobHistory(empid);
		return empRepository.deleteEmp(empid, email);
	}

	@Override
	public List<Map<String, Object>> getAllJobId() {
		return empRepository.getAllJobId();
	}

	@Override
	public List<Map<String, Object>> getAllManagerId() {
		// TODO Auto-generated method stub
		return empRepository.getAllManagerId();
	}

	@Override
	public List<Map<String, Object>> getAllDeptId() {
		// TODO Auto-generated method stub
		return empRepository.getAllDeptId();
	}

}
