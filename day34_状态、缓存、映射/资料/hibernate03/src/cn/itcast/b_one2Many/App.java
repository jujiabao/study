package cn.itcast.b_one2Many;

import org.hibernate.Hibernate;
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

	//1. ������ѯ��������
	@Test
	public void get_load() {
		
		Session session = sf.openSession();
		session.beginTransaction();
		Dept dept = new Dept();
		// get�� ��ʱ��ѯ
//		dept = (Dept) session.get(Dept.class, 9);
//		System.out.println(dept.getDeptName());
		
		// load��Ĭ�������أ� ����ʹ�����ݵ�ʱ�򣬲������ݿⷢ�Ͳ�ѯ��sql��䣡
		dept = (Dept)session.load(Dept.class, 9);
		// ��ʽ1�� ��ʹ��һ������
		//dept.getDeptName();
		// ��ʽ2��ǿ�ȴ�������ʼ��
		Hibernate.initialize(dept);
		// ��ʽ3���ر�������
		
		session.getTransaction().commit();
		session.close();
		
		// ������ʹ��
		System.out.println(dept.getDeptName());
	}


	//1. ������ѯ��������
	@Test
	public void set() {
		Session session = sf.openSession();
		session.beginTransaction();
		Dept dept = (Dept) session.get(Dept.class, 10);
		System.out.println(dept.getDeptName());
		System.out.println("------");
		System.out.println(dept.getEmps().isEmpty());  //  SQL
		
		session.getTransaction().commit();
		session.close();
		
	}
	
}
