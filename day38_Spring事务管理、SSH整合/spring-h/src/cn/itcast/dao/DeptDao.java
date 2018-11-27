package cn.itcast.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import cn.itcast.entity.Dept;

// ���ݷ��ʲ�
public class DeptDao {

	// Spring��Hibernate���ϣ� IOC����ע��
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// ����һ����¼
	// Spring��Hibernate���ϣ����������Spring
	public void save(Dept dept) {
		sessionFactory.getCurrentSession().save(dept);
	}
}
