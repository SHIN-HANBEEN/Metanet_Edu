package kr.co.metanet.myapp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class EmpMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new GenericXmlApplicationContext("application-config.xml");
		
		IEmpService empService = context.getBean(IEmpService.class);
		//getBean 메서드의 매개변수 2개를 넣으면, 첫번째는, 찾는 빈의 이름을 입력하고, 두번째는 타입을 입력합니다.
		//Spring 은 Singleton 을 활용하고 있으므로 매개변수 1개만 줘도 됩니다. 
		
		System.out.println(empService.getEmpCount());
		
		context.close();
	}
}
