package cn.itcast.a_validation;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ע�⣺���Ҫ����struts������Ч�鹦�ܣ�����̳�ActionSupport��ʵ����ؽӿ�
 * @author Jie.Yuan
 *
 */
public class UserAction extends ActionSupport {
	
	// ��װ��������
	private User user = new User();
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}

	/*
	// ��д������֤�ķ���
	public void validateRegister() {
		// �û����ǿ�
		if (user.getUserName() == null || "".equals(user.getUserName())) {
			// ���������Ϣ
			super.addFieldError("userName", "�û���������д��");
		}
		// ����
		if (user.getPwd() == null || "".equals(user.getPwd())) {
			super.addFieldError("pwd", "�������");
		}
	}
	*/
	
	// ҵ�񷽷�
	public String register() {
		System.out.println(user);
		System.out.println(1);
		return SUCCESS;
	}
	
	
	// �б�չʾ(��������Ч��)
	public String list() {
		return SUCCESS;
	}
}








