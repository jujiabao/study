package cn.itcast.a_tx;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * daoʵ�֣�ʹ��Spring��jdbc֧�ֹ���
 * @author Jie.Yuan
 *
 */
public class DeptDao {
	
	// ����ע��JdbcTemplate����
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void save(Dept dept){
		String sql = "insert into t_dept (deptName) values(?)";
		jdbcTemplate.update(sql,dept.getDeptName());
	}
}
