package cn.itcast.a_query;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class App_hql {
	
	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(Dept.class)   
			.addClass(Employee.class)   // ����ʱ��ʹ��
			.buildSessionFactory();
	}

	/*
	 * 1)	Get/load������ѯ
		2)	���󵼺���ѯ
		3)	HQL��ѯ��  Hibernate Query language  hibernate �ṩ���������Ĳ�ѯ���ԡ�
		4)	Criteria ��ѯ��   ��ȫ�������Ĳ�ѯ��Query By Criteria  ,QBC��
		5)	SQLQuery�� ����SQL��ѯ

	 */
	@Test
	public void all() {
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		//1) ������ѯ
//		Dept dept =  (Dept) session.get(Dept.class, 12);
//		Dept dept =  (Dept) session.load(Dept.class, 12);
		
		//2) ���󵼺���ѯ
//		Dept dept =  (Dept) session.get(Dept.class, 12);
//		System.out.println(dept.getDeptName());
//		System.out.println(dept.getEmps());
		
		// 3)	HQL��ѯ
		// ע�⣺ʹ��hql��ѯ��ʱ�� auto-import="true" Ҫ����true��
		//  �����false��дhql��ʱ��Ҫָ�����ȫ��
//		Query q = session.createQuery("from Dept");
//		System.out.println(q.list());
		
		// a. ��ѯȫ����
//		Query q = session.createQuery("from Dept");  //OK
//		Query q = session.createQuery("select * from Dept");  //NOK, ���󣬲�֧��*
//		Query q = session.createQuery("select d from Dept d");  // OK
//		System.out.println(q.list());

		// b. ��ѯָ������  �����ض�������Object[] ��
//		Query q = session.createQuery("select d.deptId,d.deptName from Dept d");  
//		System.out.println(q.list());
		
		// c. ��ѯָ������, �Զ���װΪ����  ������Ҫ�ṩ��������������
//		Query q = session.createQuery("select new Dept(d.deptId,d.deptName) from Dept d");  
//		System.out.println(q.list());
		
		// d. ������ѯ: һ������/�������and or/between and/ģ����ѯ
		// ������ѯ�� ռλ��
//		Query q = session.createQuery("from Dept d where deptName=?");
//		q.setString(0, "����");
//		q.setParameter(0, "����");
//		System.out.println(q.list());
		
		// ������ѯ�� ��������
//		Query q = session.createQuery("from Dept d where deptId=:myId or deptName=:name");
//		q.setParameter("myId", 12);
//		q.setParameter("name", "����");
//		System.out.println(q.list());
		
		// ��Χ
//		Query q = session.createQuery("from Dept d where deptId between ? and ?");
//		q.setParameter(0, 1);
//		q.setParameter(1, 20);
//		System.out.println(q.list());
		
		// ģ��
//		Query q = session.createQuery("from Dept d where deptName like ?");
//		q.setString(0, "%��%");
//		System.out.println(q.list());
		

		// e. �ۺϺ���ͳ��
//		Query q = session.createQuery("select count(*) from Dept");
//		Long num = (Long) q.uniqueResult();
//		System.out.println(num);
		
		// f. �����ѯ
		//-- ͳ��t_employee���У�ÿ�����ŵ�����
		//���ݿ�д����SELECT dept_id,COUNT(*) FROM t_employee GROUP BY dept_id;
		// HQLд��
//		Query q = session.createQuery("select e.dept, count(*) from Employee e group by e.dept");
//		System.out.println(q.list());
		
	
		
		
		session.getTransaction().commit();
		session.close();
	}
	
	// g. ���Ӳ�ѯ
	@Test
	public void join() {
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		//1) ������   ��ӳ���Ѿ����ú��˹�ϵ��������ʱ��ֱ��д��������Լ��ɡ�
//		Query q = session.createQuery("from Dept d inner join d.emps");
		
		//2) ��������
//		Query q = session.createQuery("from Dept d left join d.emps");

		//3) ��������
		Query q = session.createQuery("from Employee e right join e.dept");
		q.list();
		
		session.getTransaction().commit();
		session.close();
	}
	
	// g. ���Ӳ�ѯ - ��������
	@Test
	public void fetch() {
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		//1) ����������    ��ʹ��fetch, ����ұ�����ݣ���䵽�������У���
//		Query q = session.createQuery("from Dept d inner join fetch d.emps");
//		q.list();
		
		//2) ������������
		Query q = session.createQuery("from Dept d left join fetch d.emps");
		q.list();
		
		session.getTransaction().commit();
		session.close();
	}
	
	// HQL��ѯ�Ż�
	@Test
	public void hql_other() {
		Session session = sf.openSession();
		session.beginTransaction();
		// HQLд��
//		Query q = session.createQuery("from Dept d where deptId < 10 ");
		
		// HQL �ŵ�ӳ���ļ���
		Query q = session.getNamedQuery("getAllDept");
		q.setParameter(0, 10);
		System.out.println(q.list());
		
		session.getTransaction().commit();
		session.close();
	}
}











