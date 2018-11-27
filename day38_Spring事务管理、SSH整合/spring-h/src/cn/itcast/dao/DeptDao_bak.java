package cn.itcast.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import cn.itcast.entity.Dept;

// ���ݷ��ʲ�
public class DeptDao_bak {
	
	private static SessionFactory sessionFactory;
	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	// ����һ����¼
	public void save(Dept dept) {
		// �������ù�������󡢴���SessionFactory������Session,  ִ�в����� �ر�
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// ����
		session.save(dept);
		session.getTransaction().commit();
		session.close();
	}
}
