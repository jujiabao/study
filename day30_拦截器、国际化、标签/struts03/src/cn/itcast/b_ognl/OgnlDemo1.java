package cn.itcast.b_ognl;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

import org.junit.Test;

// OgnlContext�÷�
public class OgnlDemo1 {

	/**
	 * 1. Ognl���ʽ��������ȡֵ��ȡ�Ǹ�Ԫ�ص�ֵ��������#��
	 * @throws Exception
	 */
	@Test
	public void testOgnl() throws Exception {
		// ����һ��Ognl�����Ķ���
		OgnlContext context = new OgnlContext();
		// ��������
		User user = new User();
		user.setId(100);
		user.setName("Jack");
		// �����Ǹ�Ԫ�ط������ݣ� ȡֵ��ʱ����ʽҪ��"#"��
		context.put("user", user);
		
		// ��ȡ����(map)
		// �ȹ���һ��Ognl���ʽ, �ٽ������ʽ
		Object ognl = Ognl.parseExpression("#user.name");
		Object value = Ognl.getValue(ognl, context, context.getRoot());
		
		System.out.println(value);
	}
	
	/**
	 * 2. Ognl���ʽ��������ȡֵ��ȡ��Ԫ�ص�ֵ�����ô�#��
	 * @throws Exception
	 */
	@Test
	public void testOgn2() throws Exception {
		// ����һ��Ognl�����Ķ���
		OgnlContext context = new OgnlContext();
		// ��������
		User user = new User();
		user.setId(100);
		user.setName("Jack");
		// ������Ԫ�ط������ݡ�
		context.setRoot(user);
		
		// ��ȡ����(map)
		// �ȹ���һ��Ognl���ʽ, �ٽ������ʽ
		Object ognl = Ognl.parseExpression("address.province");
		Object value = Ognl.getValue(ognl, context, context.getRoot());
		
		System.out.println(value);
	}
	
	/**
	 * 3.Ognl�� ��̬�������õ�֧��
	 * @throws Exception
	 */
	@Test
	public void testOgn3() throws Exception {
		// ����һ��Ognl�����Ķ���
		OgnlContext context = new OgnlContext();
		
		// Ognl��ʽ���ԣ�������ľ�̬����
		//Object ognl = Ognl.parseExpression("@Math@floor(10.9)");
		// ����Math���ڿ����бȽϳ��ã�����Ҳ��������д
		Object ognl = Ognl.parseExpression("@@floor(10.9)");
		Object value = Ognl.getValue(ognl, context, context.getRoot());
		System.out.println(value);
	}
}





