package cn.itcast.a_config;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction2 extends ActionSupport {

	// Action��ҵ������
	public String login() {
		System.out.println("UserAction.login()");
//		return "success";
		return SUCCESS;
	}
}
