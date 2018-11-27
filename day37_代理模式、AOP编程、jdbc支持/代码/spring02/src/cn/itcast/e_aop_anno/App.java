package cn.itcast.e_aop_anno;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	ApplicationContext ac = 
		new ClassPathXmlApplicationContext("cn/itcast/e_aop_anno/bean.xml");

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
	
	@Deprecated
	// �������⣺���Ŀ�������ʵ�ֽӿڣ��ڴ������л�ȡĿ������ʱ��ֻ��ͨ���ӿڽ��ն���
	public void testApp2() {
		// ������룺 ֻ���ýӿڽ���
		UserDao userDao = (UserDao) ac.getBean("userDao");
		System.out.println(userDao.getClass());//$Proxy001  
		userDao.save();
	}
	
	
	@Test
	public void testGetObj() throws Exception {
		OrderDao orderDao1 = (OrderDao) ac.getBean("orderDao");
		OrderDao orderDao2 = (OrderDao) ac.getBean("orderDao");
		
		System.out.println(orderDao1);
		System.out.println(orderDao2);
		
	}
}
















