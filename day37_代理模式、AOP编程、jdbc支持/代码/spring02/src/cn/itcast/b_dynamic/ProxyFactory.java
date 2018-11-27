package cn.itcast.b_dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * �����е�dao����������󡾶�̬����
 * 
 * ������󣬲���Ҫʵ�ֽӿ�
 * @author Jie.Yuan
 *
 */
public class ProxyFactory {

	// ά��һ��Ŀ�����
	private Object target;
	public ProxyFactory(Object target){
		this.target = target;
	}
	
	// ��Ŀ��������ɴ������  
	public Object getProxyInstance() {
		return Proxy.newProxyInstance(
				target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(),
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						System.out.println("��������");
						
						// ִ��Ŀ����󷽷�
						Object returnValue = method.invoke(target, args);
						
						System.out.println("�ύ����");
						return returnValue;
					}
				});
	}
}











