package cn.itcast.b_anno;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

// ���ԣ� ��־������Ϊ
@Repository
public class LogDao {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	// ʼ�տ�������
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void insertLog() {
		jdbcTemplate.update("insert into log_ values('�ڱ���Dept..')");
	}
}
