package cn.itcast.b_anno;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	@Test
	public void testApp() throws Exception {
		//��������
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/itcast/b_anno/bean.xml");
		
		// ģ������
		Dept dept = new Dept();
		dept.setDeptName("���ԣ� ������");
		
		DeptService deptService = (DeptService) ac.getBean("deptService");
		deptService.save(dept);
	}
	
	// �˽���������ط���
	@Test
	public void testApp2() throws Exception {
		//1. ����bean.xml����·����������������
		//ApplicationContext ac = new ClassPathXmlApplicationContext("cn/itcast/b_anno/bean.xml");

		//2. ���ݶ�������ļ���·����������������
		//ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{});
		
		//3.  ����������ط���
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext("cn/itcast/b_anno/bean.xml");
		//3.1 �������л�ȡָ�����Ƶ�bean����
		//DeptDao deptDao = (DeptDao) ac.getBean("deptDao");
		//3.2 �������ʹ�������ȡʵ�� ��������ֻ����IOC����Ψһ�Ķ��󣬷��򱨴�
		//DeptDao deptDao = ac.getBean(DeptDao.class);
		//3.3 ���ͣ�����Ҫǿת
		//DeptDao deptDao = ac.getBean("deptDap", DeptDao.class);
		//3.4 ��ȡ������bean���������
		//int count = ac.getBeanDefinitionCount();
		String[] names = ac.getBeanDefinitionNames();
		System.out.println(Arrays.toString(names));
	}
}











