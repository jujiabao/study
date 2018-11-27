package cn.itcast.e_extends2;

import java.util.List;

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
			.addClass(Animal.class)   
			.buildSessionFactory();
	}

	@Test
	public void getSave() {
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		// ����
		Cat cat = new Cat();
		cat.setName("��è");
		cat.setCatchMouse("ץС����");
		
		Monkey m = new Monkey();
		m.setName("����");
		m.setEatBanana("��10���㽶");
		
		// ����
		session.save(cat);
		session.save(m);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
}
