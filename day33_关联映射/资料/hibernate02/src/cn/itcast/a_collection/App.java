package cn.itcast.a_collection;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class App {
	
	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(User.class)   // ����ʱ��ʹ��
			.buildSessionFactory();
	}

	// ����set
	@Test
	public void testSaveSet() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		//-- ����
		Set<String> addressSet = new HashSet<String>();
		addressSet.add("����");
		addressSet.add("����");
		// �û�����
		User user = new User();
		user.setUserName("Jack");
		user.setAddress(addressSet);
		
		// ����
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
	}
	
	// ����list/map
	@Test
	public void testSaveList() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		User user = new User();
		user.setUserName("Tom");
//		// �û�����  --  list
//		user.getAddressList().add("����");
//		user.getAddressList().add("����");
//		// ����
//		session.save(user);
		
		// �û�����  --  Map
		user.getAddressMap().put("A0001", "����");
		user.getAddressMap().put("A0002", "����");
		
		// ����
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
	}
	
	
	// ��ȡ
	@Test
	public void testGet() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// ��ȡ
		User user = (User) session.get(User.class, 3); // ��ʱ����
		System.out.println(user.getUserId());
		System.out.println(user.getUserName());
		
		// ����ѯ�û���ͬʱ���Ի�ȡ�û�������list���ϵ����� (��Ϊ����ȷӳ��)
		// ��ʹ�õ��������ݵ�ʹ�ã��������ݿⷢ��ִ�е�sql���  (������)
		System.out.println(user.getAddressList());
		
		session.getTransaction().commit();
		session.close();
	}
}










