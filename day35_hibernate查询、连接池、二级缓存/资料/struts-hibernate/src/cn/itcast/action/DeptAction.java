package cn.itcast.action;

import cn.itcast.entity.Dept;
import cn.itcast.service.DeptService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeptAction extends ActionSupport{
	
	// Service
	private DeptService deptService = new DeptService();
	
	// Ĭ�ϴ�����
	public String execute() {
		// ������ѯ(ģ������)
		Dept dept = deptService.findById(12);
		// ����
		ActionContext.getContext().getContextMap().put("dept", dept);
		return SUCCESS;
	}
}
