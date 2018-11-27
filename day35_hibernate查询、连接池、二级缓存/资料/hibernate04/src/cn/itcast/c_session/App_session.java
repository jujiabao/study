package cn.itcast.c_session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.junit.Test;

import cn.itcast.b_second_cache.Dept;
import cn.itcast.b_second_cache.Employee;

public class App_session {

	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(Dept.class)   
			.addClass(Employee.class)   // ����ʱ��ʹ��
			.buildSessionFactory();
	}
	
	@Test
	public void testSession() throws Exception {
		//openSession:  ����Session, ÿ�ζ��ᴴ��һ���µ�session
		Session session1 = sf.openSession();
		Session session2 = sf.openSession();
		System.out.println(session1 == session2);
		session1.close();
		session2.close();
		
		//getCurrentSession �������߻�ȡsession
		// �̵߳ķ�ʽ����session  
		// һ��Ҫ���ã�<property name="hibernate.current_session_context_class">thread</property>
		Session session3 = sf.getCurrentSession();// ����session���󶨵��߳�
		Session session4 = sf.getCurrentSession();// �ӵ�ǰ�����̻߳�ȡsession
		System.out.println(session3 == session4);
		
		// �ر� �����̷߳�ʽ������session�����Բ��ùرգ� �߳̽���session�Զ��رա�
		//session3.close();
		//session4.close(); ������Ϊͬһ��session�Ѿ��ر��ˣ�
	}
}
