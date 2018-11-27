package cn.itcast.action;

import java.util.List;

import cn.itcast.entity.Admin;
import cn.itcast.service.AdminService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	// ---------1. ��װ��������-----------
	private Admin admin;
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	// ---------2. ���õ�Service-----------
	private AdminService adminService = new AdminService();
	
	// ��½
	public String login() {
		try {
			Admin userInfo = adminService.login(admin);
			// �ж�
			if (userInfo == null){
				// ��½ʧ��
				return "input";
			}
			// ��½�ɹ������ݱ�����session��
			ActionContext.getContext().getSession().put("userInfo", userInfo);
			
			// ��½�ɹ�
			return "loginSuccess";
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	// �б�
	public String list() {
		try {
			// ��ѯȫ��
			List<Admin> list = adminService.getAll();
			// ���浽request
			ActionContext.getContext().getContextMap().put("listAdmin", list);
			return "list";
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	public String add() {
		return null;
	}
	
	
}
