package cn.itcast.c_hbm_config;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App2 {
	
	private static SessionFactory sf;
	static  {		
		// ����sf����
		sf = new Configuration()
			.configure()
			.addClass(Employee.class)  //�����ԣ� ���Զ�����ӳ���ļ���Employee.hbm.xml
			.buildSessionFactory();
	}

	//1. �������
	@Test
	public void testSave() throws Exception {
		// ����
		Employee emp = new Employee();
		emp.setEmpName("����");
		emp.setWorkDate(new Date());
		emp.setDesc("����");
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(emp);
		
		tx.commit();
		session.close();
	}
	
}












