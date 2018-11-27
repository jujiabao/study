package cn.itcast.b_one2Many;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import cn.itcast.a_collection.User;

public class App4_cascade {
	
	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(Dept.class)   
			.addClass(Employee.class)   // ����ʱ��ʹ��
			.buildSessionFactory();
	}

	// ��������
	@Test
	public void save() {
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		// ���Ŷ���
		Dept dept = new Dept();
		dept.setDeptName("����");
		// Ա������
		Employee emp_zs = new Employee();
		emp_zs.setEmpName("����");
		Employee emp_ls = new Employee();
		emp_ls.setEmpName("����");
		// ��ϵ
		dept.getEmps().add(emp_zs);
		dept.getEmps().add(emp_ls);  
		
		// ����
//		session.save(emp_zs);
//		session.save(emp_ls);
		session.save(dept); // ��Ҫ���ü������棻 ���沿�ţ����������е�Ա��  
		
		session.getTransaction().commit();
		session.close();
	}

	// ����ɾ��
	@Test
	public void delete() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		Dept dept = (Dept) session.get(Dept.class,7);
		session.delete(dept); // ����ɾ��
		
		session.getTransaction().commit();
		session.close();
	}
	
	
	@Test
	public void bak() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.getTransaction().commit();
		session.close();
	}
	
	
}
