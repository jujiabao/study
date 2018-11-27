package cn.itcast.b_one2Many;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import cn.itcast.a_collection.User;

public class App3_inverse {
	
	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(Dept.class)   
			.addClass(Employee.class)   // ����ʱ��ʹ��
			.buildSessionFactory();
	}

	// 1. �������� 
	@Test
	public void save() {
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		// ���Ŷ���
		Dept dept = new Dept();
		dept.setDeptName("Ӧ�ÿ�����");
		// Ա������
		Employee emp_zs = new Employee();
		emp_zs.setEmpName("����");
		Employee emp_ls = new Employee();
		emp_ls.setEmpName("����");
		// ��ϵ
		dept.getEmps().add(emp_zs);
		dept.getEmps().add(emp_ls);  // inverse=true,  �������ù�����
									//                 ��ʱ�Ĺ���Ӧ��ͨ��Ա����ά����
		

		// ����
		session.save(emp_zs);
		session.save(emp_ls);
		session.save(dept); // ���沿�ţ����������е�Ա��  
		
		session.getTransaction().commit();
		session.close();
	}
	
	//2. �Ƿ�����inverse���Ի�ȡ���ݵ�Ӱ�죿   ��.
	@Test
	public void get() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		Dept dept = (Dept) session.get(Dept.class, 1);
		System.out.println(dept.getDeptName());
		System.out.println(dept.getEmps());
		
		session.getTransaction().commit();
		session.close();
	}
	
	// 3. �Ƿ�����inverse���Խ��������ϵӰ�죿
	// inverse=false��  ���Խ������
	// inverse=true��  ��ǰ��(����)û�п���Ȩ�����ܽ��������ϵ(��������update���,Ҳ���ᱨ��)
	// 
	@Test
	public void removeRelation() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// ��ȡ����
		Dept dept = (Dept) session.get(Dept.class, 2);
		// �����ϵ
		dept.getEmps().clear();
		
		session.getTransaction().commit();
		session.close();
	}
	
	
	//3. �Ƿ�����inverse���ԣ���ɾ�������жԹ�����ϵ��Ӱ��?
	// inverse=false, �п���Ȩ�� ����ɾ���������������ã���ɾ�����ݡ�
	// inverse=true,  û�п���Ȩ: ���ɾ���ļ�¼�б�������ã��ᱨ��Υ�����������Լ����
	//							 ���ɾ���ļ�¼û�б����ã�����ֱ��ɾ����
	@Test
	public void deleteData() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// ��ѯ����
		Dept dept = (Dept) session.get(Dept.class, 8);
		session.delete(dept);
		
		
		session.getTransaction().commit();
		session.close();
	}
	
	
	
	
	
	
	
	
	
	@Test
	public void bak() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.getTransaction().commit();
		session.close();
	}
	
	
}
