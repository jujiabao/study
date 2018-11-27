package cn.itcast.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.framework.action.LoginAction;

// ������
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// ����Action���󣬵��õ�½����
		LoginAction loginAction = new LoginAction();
		Object uri = loginAction.login(request, response); 
		
		// ��ת
		if (uri instanceof String) {
			response.sendRedirect(request.getContextPath() + uri.toString());
		} else {
			((RequestDispatcher)uri).forward(request, response);
		}
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
