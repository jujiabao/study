package cn.itcast.b_one2Many;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import cn.itcast.a_collection.User;

public class App1_save {
	
	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(Dept.class)   
			.addClass(Employee.class)   // ����ʱ��ʹ��
			.buildSessionFactory();
	}

	// ���棬 ���ŷ� ��һ��һ����������
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
		dept.getEmps().add(emp_ls);

		// ����
		session.save(emp_zs);
		session.save(emp_ls);
		session.save(dept); // ���沿�ţ����������е�Ա��  
		
		session.getTransaction().commit();
		session.close();
		/*
		 *  ���
		 *  Hibernate: insert into t_employee (empName, salary, dept_id) values (?, ?, ?)
			Hibernate: insert into t_employee (empName, salary, dept_id) values (?, ?, ?)
			Hibernate: insert into t_dept (deptName) values (?)
			Hibernate: update t_employee set deptId=? where empId=?    ά��Ա�����õĲ��ŵ�id
			Hibernate: update t_employee set deptId=? where empId=?
		 */
	}
	// ���Ƽ��� ���棬 ��Ա�� �����һ����������
	@Test
	public void save2() {
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		// ���Ŷ���
		Dept dept = new Dept();
		dept.setDeptName("�ۺϲ�");
		// Ա������
		Employee emp_zs = new Employee();
		emp_zs.setEmpName("����");
		Employee emp_ls = new Employee();
		emp_ls.setEmpName("����");
		// ��ϵ
		emp_zs.setDept(dept);
		emp_ls.setDept(dept);
		
		
		// ����
		session.save(dept); // �ȱ���һ�ķ���
		session.save(emp_zs);
		session.save(emp_ls);// �ٱ�����һ������ϵ���Զ�ά��(ӳ��������)
		
		session.getTransaction().commit();
		session.close();
		/*
		 *  ���
		 *  Hibernate: insert into t_dept (deptName) values (?)
			Hibernate: insert into t_employee (empName, salary, dept_id) values (?, ?, ?)
			Hibernate: insert into t_employee (empName, salary, dept_id) values (?, ?, ?)
			������2��update  sql
		 */
	}
	
}
