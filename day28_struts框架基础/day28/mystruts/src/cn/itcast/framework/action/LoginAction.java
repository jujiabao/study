package cn.itcast.framework.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.entity.User;
import cn.itcast.service.UserService;

/**
 * Action��ʾ������ 1. һ��servlet��Ӧһ��action 2. action�и�������������
 * 
 * @author Jie.Yuan
 * 
 */
public class LoginAction {
	
	public Object execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		return null;
	}

	/**
	 * �����½����
	 */
	public Object login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object uri = null;

		// 1. ��ȡ�������ݣ���װ
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		User user = new User();
		user.setName(name);
		user.setPwd(pwd);

		// 2. ����Service
		UserService userService = new UserService();
		User userInfo = userService.login(user);
		// 3. ��ת
		if (userInfo == null) {
			// ��½ʧ��
//			request.getRequestDispatcher("/login.jsp").forward(request,
//					response);
//			uri = request.getRequestDispatcher("/login.jsp");
			uri = "loginFaild";   // loginFaild  = /login.jsp
		} else {
			// ��½�ɹ�
			request.getSession().setAttribute("userInfo", userInfo);
			// ��ҳ
//			response.sendRedirect(request.getContextPath() + "/index.jsp");
//			uri = "/index.jsp";
			uri = "loginSuccess";  // loginSuccess = /index.jsp
		}
		return uri;
	}
}
