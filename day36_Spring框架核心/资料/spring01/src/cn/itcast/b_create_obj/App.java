package cn.itcast.b_create_obj;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class App {

	// ���ԣ����󴴽�
	@Test
	public void testIOC() throws Exception {
		// ����IOC��������
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/itcast/b_create_obj/bean.xml");
		// ��ȡ�����еĶ���
		User user = (User) ac.getBean("user");
		
		System.out.println(user);
	}
	
	
	// ����: �����ж����д��
	@Test
	public void testObj() throws Exception {
		// ����IOC��������
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/itcast/b_create_obj/bean.xml");
		// ��ȡ�����еĶ���
		User user = (User) ac.getBean("1test");
		
		System.out.println(user);
	}
}









