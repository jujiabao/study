package cn.itcast.a_status;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class App1_status {
	
	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(User.class)   // ����ʱ��ʹ��
			.buildSessionFactory();
	}

	//1. ����״̬��ת��
	@Test
	public void testSaveSet() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// ��������						����ʱ״̬��
//		User user = new User();
//		user.setUserName("Jack22222");
		// ����							���־û�״̬��
//		session.save(user);		
//		user.setUserName("Jack333333");  // �ᷴӳ�����ݿ�
		
		
		// ��ѯ
		User user = (User) session.get(User.class, 5);
		user.setUserName("Tomcat");// hibernate���Զ������ݿ�ƥ�䣨һ�����棩�����һ���͸������ݿ�
		
		session.getTransaction().commit();
		session.close();
		
		
		user.setUserName("Jack444444444");
		// ��ӡ							������״̬��
		System.out.println(user.getUserId());
		System.out.println(user.getUserName());
	}
	
	
	@Test
	public void bak() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		session.getTransaction().commit();
		session.close();
	}
}










