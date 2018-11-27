package cn.itcast.b_ognl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * struts��������ת
 * @author Jie.Yuan
 *
 */
public class OgnlDemo3 extends ActionSupport{
	
	
	@Override
	public String execute() throws Exception {
		
		// ���Ե�����ǩ
		
		List<User> list = new ArrayList<User>();
		Map<Integer,User> map = new HashMap<Integer, User>();
		
		// ��ʼ��
		for (int i=1; i<11; i++) {
			User user = new User(i,"Jack" + i);
			
			list.add(user);
			map.put(user.getId(), user);
		}
		
		// ����  
		ActionContext.getContext().getContextMap().put("list", list);
		ActionContext.getContext().getContextMap().put("map", map);
		
		return super.execute();
	}
	
	
	
}














