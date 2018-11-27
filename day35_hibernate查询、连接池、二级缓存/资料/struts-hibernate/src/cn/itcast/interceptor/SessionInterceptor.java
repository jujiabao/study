package cn.itcast.interceptor;

import org.hibernate.Session;

import cn.itcast.utils.HibernateUtils;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Session������������
 * 	  ������action��ʱ�򣬴���session�� 
 * 	 action ---> service  --> dao ����ȡ�������ﴴ����session��
 * @author Jie.Yuan
 *
 */
public class SessionInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		try {
			// 1. �ȴ���Session
			Session session = HibernateUtils.getSession();
			// 2. ��������
			session.beginTransaction();
			
			// 3. ִ��Action
			String result = invocation.invoke();
			
			// 4. �ύ����
			session.getTransaction().commit();  // ����Ҫ�ر�session
			
			// ���ؽ����ͼ
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

}
