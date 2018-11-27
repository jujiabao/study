package cn.itcast.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	// ��ʼ��SessionFactory
	private static SessionFactory sf;
	static {
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	// ��������ȡ��Session
	public static Session getSession() {
		// �̵߳ķ�ʽ����session������Ҫ����
		// ���Բ��ùرգ����Զ��ء�
		return sf.getCurrentSession();
	}
}
