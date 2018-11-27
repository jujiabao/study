package cn.itcast.a_hello;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class App2_bean {

	/**
	 * 1) ���󴴽��� ����/����
	 * 	scope="singleton", Ĭ��ֵ�� �� Ĭ���ǵ���	��service/dao/�����ࡿ
	 *  scope="prototype", ������ 				��Action����
	 * 
	 * 2) ʲôʱ�򴴽�?
	 * 	  scope="prototype"  ���õ������ʱ�򣬲Ŵ�������
	 *    scope="singleton"  ������(������ʼ��֮ǰ)�� ���Ѿ�������bean��������Ӧ��ֻ��һ����
	 * 3)�Ƿ��ӳٴ���
	 * 	  lazy-init="false"  Ĭ��Ϊfalse,  ���ӳٴ�������������ʱ��ʹ�������
	 * 	  lazy-init="true"   �ӳٳ�ʼ���� ���õ������ʱ��Ŵ�������
	 *    ��ֻ�Ե�����Ч��
	 * 4) ��������֮�󣬳�ʼ��/����
	 * 	  init-method="init_user"       ����Ӧ�����init_user�������ڶ��󴴽���֮��ִ�� ��
	 *    destroy-method="destroy_user"  ���ڵ������������destriy����ʱ��ִ�У�(������ʵ����)��
	 */
	@Test
	public void testIOC() throws Exception {
		// �õ�IOC��������  ����ʵ���࣬��ΪҪ�������ٵķ�����
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("cn/itcast/a_hello/applicationContext.xml");
		System.out.println("-----��������-----");
		
		// �������л�ȡbean
		User user1 = (User) ac.getBean("user");
		User user2 = (User) ac.getBean("user");
		
		System.out.println(user1);
		System.out.println(user2);
		
		// ������������ 
		ac.destroy();
	}
	
	@Test
	public void test() throws Exception {
		// ��������
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/itcast/a_hello/applicationContext.xml");
		System.out.println("-----�����������-----");
		User user1 = (User) ac.getBean("user1");
	}
}









