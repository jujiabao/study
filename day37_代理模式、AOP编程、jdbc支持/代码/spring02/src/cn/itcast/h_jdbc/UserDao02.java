package cn.itcast.h_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.sql.DataSource;

public class UserDao02 {
	
	// IOC����ע��
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
	public void save() {
		try {
			String sql = "insert into t_dept(deptName) values('test');";
			Connection con = null;
			Statement stmt = null;
			// ���Ӷ���
			con = dataSource.getConnection();
			// ִ���������
			stmt =  con.createStatement();
			// ִ��
			stmt.execute(sql);
			
			// �ر�
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
