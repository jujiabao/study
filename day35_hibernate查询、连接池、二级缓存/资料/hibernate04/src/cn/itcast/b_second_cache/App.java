package cn.itcast.b_second_cache;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class App {
	
	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(Dept.class)   
			.addClass(Employee.class)   // ����ʱ��ʹ��
			.buildSessionFactory();
	}
	// 1. ���Զ��������ʹ��
	// û��/���� ��������
	@Test
	public void testCache() {
		Session session1 = sf.openSession();
		session1.beginTransaction();
		// a. ��ѯһ��
		Dept dept = (Dept) session1.get(Dept.class, 10);
		dept.getEmps().size();// ����
		session1.getTransaction().commit();
		session1.close();
		
		System.out.println("------");
		
		// �ڶ���session
		Session session2 = sf.openSession();
		session2.beginTransaction();
		// a. ��ѯһ��
		dept = (Dept) session2.get(Dept.class, 10);  // �����������úã� ���ﲻ��ѯ���ݿ�
		dept.getEmps().size();
		
		session2.getTransaction().commit();
		session2.close();
	}
	
	
	@Test
	public void listCache() {
		Session session1 = sf.openSession();
		session1.beginTransaction();
		// HQL��ѯ  ��setCacheable  ָ���Ӷ��������ң������Ƿ���������桿
		Query q = session1.createQuery("from Dept").setCacheable(true);
		System.out.println(q.list());
		session1.getTransaction().commit();
		session1.close();
		
		
		Session session2 = sf.openSession();
		session2.beginTransaction();
		q = session2.createQuery("from Dept").setCacheable(true);
		System.out.println(q.list());  // ����ѯ���ݿ⣺ ��Ҫ������ѯ����
		session2.getTransaction().commit();
		session2.close();
	}
}











