package cn.itcast.service;

import cn.itcast.dao.DeptDao;
import cn.itcast.entity.Dept;
import cn.itcast.utils.HibernateUtils;

public class DeptService {

	// ���õ�dao
	private DeptDao deptDao  = new DeptDao();
	
	public Dept findById(int id){
		return deptDao.findById(id);
	}
}
