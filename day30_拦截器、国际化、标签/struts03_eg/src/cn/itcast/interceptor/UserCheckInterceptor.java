package cn.itcast.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserCheckInterceptor extends AbstractInterceptor{

	/**
	 * ������ҵ������
	 */
	public String intercept(ActionInvocation invocation) throws Exception {
		// �õ���ǰִ�еķ��������жϣ�ֻ�е�ǰ����������login,�ͽ�����֤
		
		// ��ȡActionContext����
		ActionContext ac = invocation.getInvocationContext();
		
		// ��ȡaction�Ĵ������
		 ActionProxy proxy = invocation.getProxy();
		 // ��ȡ��ǰִ�еķ�����
		 String methodName = proxy.getMethod();
		 // �ж�
		 if (!"login".equals(methodName)) {
			 // �Ȼ�ȡ��ǰ��½���û�
			 Object obj = ac.getSession().get("userInfo");
			 if (obj == null) {
				 // û�е�½
				 return "input";
			 } else {
				 // ��ǰ�û��е�½
				 return invocation.invoke();
			 }
		 } else {
			 // ˵����ǰ�û����ڵ�½
			 return invocation.invoke();
		 }
	}

}
