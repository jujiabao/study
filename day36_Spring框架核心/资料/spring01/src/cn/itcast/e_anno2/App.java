package cn.itcast.e_anno2;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	// ������������
	private ApplicationContext ac = 
		new ClassPathXmlApplicationContext("cn/itcast/e_anno2/bean.xml");

	@Test
	public void testExecuteAction() {
		// �������л�ȡAction
		UserAction userAction = (UserAction) ac.getBean("userAction");
		userAction.execute();
	}
}





