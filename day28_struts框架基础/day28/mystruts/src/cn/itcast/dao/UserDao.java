package cn.itcast.dao;

import cn.itcast.entity.User;


public class UserDao {

	// ģ���½
	public User login(User user){
		if ("tom".equals(user.getName()) && "888".equals(user.getPwd()) ){
			// ��½�ɹ�
			return user;
		}
		// ��½ʧ��
		return null;
	}
	
	// ģ��ע��
	public void register(User user) {
		System.out.println("ע��ɹ����û���" + user.getName());
	}
}
