package kr.or.kosa.hr;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class EmpMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new GenericXmlApplicationContext("application-config.xml");
		EmpController controller = context.getBean(EmpController.class);
		
//		System.out.println(controller.getEmpCount());
		
//		System.out.println(controller.getEmpCount(20));
		
//		System.out.println(controller.getEmpList());		
		
//		int employeeId = 1111;
//		String firtName = "shin";
//		String lastName = "hanbeen";
//		String email = "email1";
//		String phoneNumber = "0101234";
//		Date hireDate = Date.valueOf(LocalDate.now());
//		String jobId = "AD_VP";
//		double salary = 100.0;
//		double commissionPct = 0.11;
//		int managerId = 200;
//		int departmentId = 200;
//		EmpVO empVO = new EmpVO(employeeId,firtName,lastName,email,phoneNumber,
//				hireDate,jobId,salary,commissionPct,managerId,departmentId);
//		controller.insertEmp(empVO); //insert new emp into employees
//		System.out.println("insert completed");
		
//		int employeeId = 1111;
//		String firtName = "shin";
//		String lastName = "hanbeen";
//		String email = "email2modified";
//		String phoneNumber = "0101234";
//		Date hireDate = Date.valueOf(LocalDate.now());
//		String jobId = "AD_VP";
//		double salary = 100.0;
//		double commissionPct = 0.11;
//		int managerId = 200;
//		int departmentId = 200;
//		EmpVO empVO = new EmpVO(employeeId,firtName,lastName,email,phoneNumber,
//				hireDate,jobId,salary,commissionPct,managerId,departmentId);
//		controller.updateEmp(empVO); //insert new emp into employees
		
		
//		System.out.println((controller.deleteEmp(1111,"email1")+1) + " case delete completed");
		
//		System.out.println(controller.getAllJobId());
		
//		System.out.println(controller.getAllManagerId());
		
//		System.out.println(controller.getAllDeptId());
	}

}
