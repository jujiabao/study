package cn.itcast.b_ognl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * struts��������ת
 * @author Jie.Yuan
 *
 */
public class OgnlDemo2 extends ActionSupport{
	
	// ��Ԫ��ֵ
    private User user = new User(100,"Jacks");
    public User getUser() {
		return user;
	}
    public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String execute() throws Exception {
		
		ActionContext ac = ActionContext.getContext();
		// ӳ������
		ac.getContextMap().put("request_data", "request_data");
		// ���ݴ洢request
//		Map<String,Object> map = (Map<String, Object>) ac.get("request");
//		map.put("request_data", "request_data");
//		map.put("cn", "China");
		
		ac.getSession().put("Session_data", "Session_data");
		ac.getApplication().put("Application_data", "Application_data");
		
		
		// ����ֵջ����Ĵ洢���ݵ�ԭ��
		ValueStack vs = ac.getValueStack();
		/***************������Ԫ�صļ��ַ���*****************/
		// ��������: ��ջ
		//vs.push(new User(1002,"Tom"));	// ջ��
		//vs.pop();						// �Ƴ�ջ��Ԫ��
		
		// ��δ洢��  map�ṹ�洢  
		//vs.set("user1", new User(1,"Jacky1"));
		//vs.set("user2", new User(2,"Jacky2"));
		
		
		return super.execute();
	}

	// һ����ȡֵջ�����2�ַ�ʽ
	private void getVs() {
		// ��ȡֵջ���󣬷�ʽ1��
		HttpServletRequest request = ServletActionContext.getRequest();
		ValueStack vs1 = (ValueStack) request.getAttribute("struts.valueStack");
		
		// ��ȡֵջ���󣬷�ʽ2�� 
		ActionContext ac = ActionContext.getContext();
		ValueStack vs2 = ac.getValueStack();
		
		System.out.println(vs1 == vs2);//true
	}
	
	
	
}














