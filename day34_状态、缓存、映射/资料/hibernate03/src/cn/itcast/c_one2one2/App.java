package cn.itcast.c_one2one2;

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
			.addClass(IdCard.class)   
			.addClass(User.class)   // ����ʱ��ʹ��
			.buildSessionFactory();
	}

	@Test
	public void getSave() {
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		// �û�
		User user = new User();
		user.setUserName("Jack");
		// ���֤
		IdCard idCard = new IdCard();
		idCard.setCardNum("441202XXX");
		idCard.setPlace("����XXX");
		// ��ϵ
		idCard.setUser(user);
		
		// ----����----
		session.save(idCard);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
}
