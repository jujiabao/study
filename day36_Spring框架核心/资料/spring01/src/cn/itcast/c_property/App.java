package cn.itcast.c_property;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	// ������������
	private ApplicationContext ac = new ClassPathXmlApplicationContext("cn/itcast/c_property/bean.xml");

	@Test
	public void testSet() {
		// �������л�ȡ
		User user = (User) ac.getBean("user");
		
		System.out.println(user);
	}
	
	@Test
	public void testExecuteAction() {
		// �������л�ȡAction
		UserAction userAction = (UserAction) ac.getBean("userAction");
		userAction.execute();
		
	}
}





