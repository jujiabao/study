package cn.itcast.a_config;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction3 implements Action {

	// Action��ҵ������
	public String login() {
		System.out.println("UserAction.login()");
		return "success";
	}

	@Override
	public String execute() throws Exception {
		return null;
	}
}
