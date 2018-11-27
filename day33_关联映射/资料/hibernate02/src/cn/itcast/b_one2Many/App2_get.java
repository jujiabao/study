package cn.itcast.b_one2Many;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import cn.itcast.a_collection.User;

public class App2_get {
	
	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(Dept.class)   
			.addClass(Employee.class)   // ����ʱ��ʹ��
			.buildSessionFactory();
	}

	@Test
	public void get() {
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		// ͨ�����ŷ�����ȡ����һ��
//		Dept dept = (Dept) session.get(Dept.class, 1);
//		System.out.println(dept.getDeptName());
//		System.out.println(dept.getEmps());// ������
		
		
		// ͨ��Ա��������ȡ����һ��
		Employee emp = (Employee) session.get(Employee.class, 1);
		System.out.println(emp.getEmpName());
		System.out.println(emp.getDept().getDeptName());
		
		
		session.getTransaction().commit();
		session.close();
	}
	
}
