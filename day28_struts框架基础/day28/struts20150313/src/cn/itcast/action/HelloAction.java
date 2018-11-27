package cn.itcast.action;

import com.opensymphony.xwork2.ActionSupport;

// 开发action： 处理请求
public class HelloAction extends ActionSupport {
	
	// 处理请求
	public String execute() throws Exception {
		System.out.println("访问到了action，正在处理请求");
		System.out.println("调用service");
		return "success";
	}
}
