package cn.itcast.a_config;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction {
	
	private String userName;
	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	// Action��ҵ������
	public String login() {
		System.out.println("UserAction.login()" + userName);
		return "login";
	}
	
	public String register() {
		System.out.println("register()" + userName);
		return "register";
	}
}
