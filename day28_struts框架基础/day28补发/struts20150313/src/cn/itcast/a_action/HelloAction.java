package cn.itcast.a_action;

import com.opensymphony.xwork2.ActionSupport;

// ����action�� ��������
public class HelloAction extends ActionSupport {
	
	public HelloAction(){
		System.out.println("����Actionʵ����HelloAction.HelloAction()");
	}
	
	// ��������
	public String add() throws Exception {
		System.out.println("���ʵ���action�����ڴ�������");
		System.out.println("����service");
		return "success";
	}
}
