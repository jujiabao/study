package cn.itcast.d_compositeKey;

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
			.addClass(User.class)  //�����ԣ� ���Զ�����ӳ���ļ���Employee.hbm.xml
			.buildSessionFactory();
	}

	//1. �������
	@Test
	public void testSave() throws Exception {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		// ����
		CompositeKeys keys = new CompositeKeys();
		keys.setAddress("�����Ķ�");
		keys.setUserName("Jack");
		User user = new User();
		user.setAge(20);
		user.setKeys(keys);
		
		// ����
		session.save(user);
		
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void testGet() throws Exception {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		//���������ٲ�ѯ
		CompositeKeys keys = new CompositeKeys();
		keys.setAddress("�����Ķ�");
		keys.setUserName("Jack");
		
		// ������ѯ
		User user = (User) session.get(User.class, keys);
		// �������
		if (user != null){
			System.out.println(user.getKeys().getUserName());
			System.out.println(user.getKeys().getAddress());
			System.out.println(user.getAge());
		}
		
		
		tx.commit();
		session.close();
	}
}












