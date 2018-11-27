package cn.itcast.b_crud;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.itcast.a_hello.Employee;
import cn.itcast.utils.HibernateUtils;

public class EmployeeDaoImpl implements IEmployeeDao{

	@Override
	public Employee findById(Serializable id) {
		Session session = null;
		Transaction tx = null;
		try {
			// ��ȡSession
			session = HibernateUtils.getSession();
			// ��������
			tx = session.beginTransaction();
			// ������ѯ
			return (Employee) session.get(Employee.class, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			tx.commit();
			session.close();
		}
	}

	@Override
	public List<Employee> getAll() {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			// HQL��ѯ
			Query q = session.createQuery("from Employee");
			return q.list();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			tx.commit();
			session.close();
		}
	}

	@Override
	public List<Employee> getAll(String employeeName) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			Query q =session.createQuery("from Employee where empName=?");
			// ע�⣺����������0��ʼ
			q.setParameter(0, employeeName);
			// ִ�в�ѯ
			return q.list();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			tx.commit();
			session.close();
		}
	}

	@Override
	public List<Employee> getAll(int index, int count) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			Query q = session.createQuery("from Employee");
			// ���÷�ҳ����
			q.setFirstResult(index);  // ��ѯ����ʵ�� 
			q.setMaxResults(count);	  // ��ѯ���ص�����
			
			List<Employee> list = q.list();
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			tx.commit();
			session.close();
		}
	}

	@Override
	public void save(Employee emp) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			// ִ�б������
			session.save(emp);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			tx.commit();
			session.close();
		}
		
	}

	@Override
	public void update(Employee emp) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			session.update(emp);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			tx.commit();
			session.close();
		}
		
	}

	@Override
	public void delete(Serializable id) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			// �ȸ���id��ѯ�������ж�ɾ��
			Object obj = session.get(Employee.class, id);
			if (obj != null) {
				session.delete(obj);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			tx.commit();
			session.close();
		}
	}
}
