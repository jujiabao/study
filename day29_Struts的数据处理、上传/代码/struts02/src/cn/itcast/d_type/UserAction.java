package cn.itcast.d_type;

import java.util.Date;

/**
 * Struts����ҵ�� ���������Զ���װ�Լ�����ת��
 * @author Jie.Yuan
 *
 */
public class UserAction {
	
	 // �������ͣ�һ����get����
	private User user; 
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}

	// ����ע������
	public String register() {
		System.out.println(user.getName());
		System.out.println(user.getPwd());
		System.out.println(user.getAge());
		System.out.println(user.getBirth());
		return "success";
	}
}
