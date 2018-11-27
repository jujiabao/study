package cn.itcast.a_status;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class App3_list_iterator {
	
	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(User.class)   // ����ʱ��ʹ��
			.buildSessionFactory();
	}
	/**
	 * list��iterator����
	 * 1. list ����
	 * 2. iterator ����
	 * 3. ����
	 * @throws Exception
	 */
	//1.  list ����
	@Test
	public void list() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		// HQL��ѯ
		Query q = session.createQuery("from User ");
		// list()����
		List<User> list = q.list();
		
		for (int i=0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
		
		session.getTransaction().commit();  
		session.close();
	}
	
	//2. iterator ����
	@Test
	public void iterator() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		// HQL��ѯ
		Query q = session.createQuery("from User ");
		// iterator()����
		Iterator<User> it = q.iterate();
		while(it.hasNext()){
			// �õ���ǰ������ÿһ������
			User user = it.next();
			System.out.println(user);
		}
		
		
		
		session.getTransaction().commit();  
		session.close();
	}
	
	
	//3. ����
	@Test
	public void cache() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		/**************ִ��2��list*****************
		Query q = session.createQuery("from User");
		List<User> list = q.list();      // ������룿��
		for (int i=0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
		System.out.println("=========list===========");
		list = q.list();				// �������?��
		for (int i=0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
		
		/**************ִ��2��iteator******************/
		Query q = session.createQuery("from User ");
		Iterator<User> it = q.iterate();		// �����뻺�桿
		while(it.hasNext()){
			User user = it.next();
			System.out.println(user);
		}
		System.out.println("==========iterate===========");
		it = q.iterate();						// ��Ҳ��ӻ�����ȡ��
		while(it.hasNext()){
			User user = it.next();
			System.out.println(user);
		}
		
		session.getTransaction().commit();  
		session.close();
	}
	
	// ����list��������뻺��
	@Test
	public void list_iterator() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// �õ�Query�ӿڵ�����
		Query q = session.createQuery("from User ");
		
		// ��list  ������뻺�棬������ӻ����л�ȡ���ݡ�
		List<User> list = q.list(); 
		for (int i=0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
		
		// ��iteraotr  (��ӻ�����ȡ)
		Iterator<User> it = q.iterate();
		while(it.hasNext()){
			User user = it.next();
			System.out.println(user);
		}
		
		session.getTransaction().commit();  
		session.close();
	}
}










