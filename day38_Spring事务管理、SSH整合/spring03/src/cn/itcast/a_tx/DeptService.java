package cn.itcast.a_tx;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Service
 * @author Jie.Yuan
 *
 */
public class DeptService {
	
	// ����ע��dao����
	private DeptDao deptDao;
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}

	/*
	 * ������ƣ�
	 */
	public void save(Dept dept){
		// ��һ�ε���
		deptDao.save(dept);
		
		int i = 1/0; // �쳣�� ����Service.save()ִ�гɹ���Ҫ�ع�
		
		// �ڶ��ε���
		deptDao.save(dept);
	}
}





