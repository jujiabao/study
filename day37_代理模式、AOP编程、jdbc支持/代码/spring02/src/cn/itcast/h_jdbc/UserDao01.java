package cn.itcast.h_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UserDao01 {

	
	/*
	 *  ���淽��
	 *  �����Ż��ĵط���
	 *  	1. ���ӹ���
	 *  	2. jdbc�����ظ������װ
	 */
	public void save() {
		try {
			String sql = "insert into t_dept(deptName) values('test');";
			Connection con = null;
			Statement stmt = null;
			Class.forName("com.mysql.jdbc.Driver");
			// ���Ӷ���
			con = DriverManager.getConnection("jdbc:mysql:///hib_demo", "root", "root");
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
