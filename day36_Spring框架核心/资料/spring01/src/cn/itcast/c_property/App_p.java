package cn.itcast.c_property;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App_p {

	// ������������
	private ApplicationContext ac = new ClassPathXmlApplicationContext("cn/itcast/c_property/bean_p.xml");

	
	@Test
	public void testExecuteAction() {
		// �������л�ȡAction
		UserAction userAction = (UserAction) ac.getBean("userAction");
		userAction.execute();
		
		System.out.println(ac.getBean("user"));
	}
}





