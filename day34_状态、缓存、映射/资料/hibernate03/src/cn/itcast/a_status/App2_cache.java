package cn.itcast.a_status;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class App2_cache {
	
	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(User.class)   // ����ʱ��ʹ��
			.buildSessionFactory();
	}

	@Test
	public void testCache() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		User user = null;
		// ��ѯ
		user = (User) session.get(User.class, 5);// �ȼ�黺�����Ƿ������ݣ�����в���ѯ���ݿ⣬ֱ�Ӵӻ����л�ȡ
		user = (User) session.get(User.class, 5);// �ȼ�黺�����Ƿ������ݣ�����в���ѯ���ݿ⣬ֱ�Ӵӻ����л�ȡ
		
		session.getTransaction().commit();
		session.close();
	}
	
	
	
	@Test
	public void flush() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		User user = null;
		user = (User) session.get(User.class, 5);
		user.setUserName("Jack");
		// �������������ݿ�ͬ��
		session.flush();
		
		user.setUserName("Jack_new");
		
		session.getTransaction().commit();  // session.flush();
		session.close();
	}
	
	@Test
	public void clear() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		User user = null;
		// ��ѯ
		user = (User) session.get(User.class, 5);
		// ��ջ������� 
//		session.clear(); // �������
		session.evict(user);// ���ָ��
		
		user = (User) session.get(User.class, 5);
		
		
		session.getTransaction().commit();  // session.flush();
		session.close();
	}
	
	@Test
	public void sessionTest() throws Exception {
		Session session1 = sf.openSession();
		session1.beginTransaction();
		Session session2 = sf.openSession();
		session2.beginTransaction();
		
		// user����session1�Ļ�����
		User user = (User) session1.get(User.class, 1);
		// user����session2�Ļ�����
		session2.update(user);
		
		// �޸Ķ���
		user.setUserName("New Name");  // 2��update
		
		
		
		session1.getTransaction().commit();  // session1.flush();
		session1.close();
		session2.getTransaction().commit();  // session2.flush();
		session2.close();
	}
}










