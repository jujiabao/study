package cn.itcast.b_form;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 1. ���ݻ���
 * 2. ģ������
 * @author Jie.Yuan
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {
	
	// ��װ��������
	private User user = new User();
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	
	// ʵ��ģ�������ӿڷ���
	@Override
	public User getModel() {
		return user;
	}
	
	
	public String add() {
		// ���ԣ� ʹ����ģ���������Ƿ����������� Ok
		System.out.println(user);
		return "success";
	}
	
	
	// �����޸�ҳ��
	public String viewUpdate() {
		// ģ��һ������(�Ȼ�ȡһ��id���ٸ���id����service��ѯ���Ѳ鵽�Ľ�����浽��)
		User userInfo = new User();
		userInfo.setUserName("Jack");
		userInfo.setEmail("yuanjie@itcast.cn");
		
		ActionContext ac = ActionContext.getContext();
//		Map<String,Object> request = (Map<String, Object>) ac.get("request");
//		request.put("userInfo", userInfo);
		
		/************* ���ݻ���***************/
		// ��ȡֵջ
		ValueStack vs = ac.getValueStack();
		vs.pop();// �Ƴ�ջ��Ԫ��
		vs.push(userInfo);  // ��ջ
		
		
		// �����޸�ҳ��
		return "viewUpdate";
	}
	
	// ҵ�񷽷�
	public String index() {
		// �������ݵ�request��
		ActionContext ac = ActionContext.getContext();
		Map<String,Object> request = (Map<String, Object>) ac.get("request");
		request.put("cn", "China");
		
		return SUCCESS;
	}
}








