package cn.itcast.dao;

import cn.itcast.entity.Dept;
import cn.itcast.utils.HibernateUtils;

public class DeptDao {

	/**
	 * ������ѯ
	 */
	public Dept findById(int id){
		// ��ȡsession, ִ�в���
		return (Dept) HibernateUtils.getSession().get(Dept.class, id);
	}
}
