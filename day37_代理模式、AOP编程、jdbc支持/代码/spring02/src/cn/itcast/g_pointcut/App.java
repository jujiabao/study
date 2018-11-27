package cn.itcast.g_pointcut;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	ApplicationContext ac = 
		new ClassPathXmlApplicationContext("cn/itcast/g_pointcut/bean.xml");

	// Ŀ�������ʵ�ֽӿڣ�spring���Զ�ѡ��JDK����
	@Test
	public void testApp() {
		IUserDao userDao = (IUserDao) ac.getBean("userDao");
		System.out.println(userDao.getClass());//$Proxy001  
		userDao.save();
	}
	
	// Ŀ�����û��ʵ�ֽӿڣ� spring���á�cglib����
	@Test
	public void testCglib() {
		OrderDao orderDao = (OrderDao) ac.getBean("orderDao");
		System.out.println(orderDao.getClass());
		orderDao.save();
	}
}
















