package cn.itcast.a_query;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

public class App_criteria {
	
	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(Dept.class)   
			.addClass(Employee.class)   // ����ʱ��ʹ��
			.buildSessionFactory();
	}

	/*
	 *  1)	Get/load������ѯ
		2)	���󵼺���ѯ
		3)	HQL��ѯ��  Hibernate Query language  hibernate �ṩ���������Ĳ�ѯ���ԡ�
		4)	Criteria ��ѯ��   ��ȫ�������Ĳ�ѯ��Query By Criteria  ,QBC��
		5)	SQLQuery�� ����SQL��ѯ
	 */
	
	//4)	Criteria ��ѯ��
	@Test
	public void criteria() {
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Employee.class);
		// ��������
		criteria.add(Restrictions.eq("empId", 12));
//		criteria.add(Restrictions.idEq(12));  // ������ѯ
		
		System.out.println(criteria.list());
		
		
		session.getTransaction().commit();
		session.close();
	}
	
	// 5)	SQLQuery�� ����SQL��ѯ
	// ���ܿ����ݿ�ƽ̨�� ����������ݿ⣬sql����п���Ҫ�ġ�
	@Test
	public void sql() {
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		SQLQuery q = session.createSQLQuery("SELECT * FROM t_Dept limit 5;")
			.addEntity(Dept.class);  // Ҳ�����Զ���װ
		System.out.println(q.list());
		
		session.getTransaction().commit();
		session.close();
	}
	
}











