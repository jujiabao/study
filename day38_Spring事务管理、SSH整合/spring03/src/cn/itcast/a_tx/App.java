package cn.itcast.a_tx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	@Test
	public void testApp() throws Exception {
		//��������
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/itcast/a_tx/bean.xml");
		
		// ģ������
		Dept dept = new Dept();
		dept.setDeptName("���ԣ� ������");
		
		DeptService deptService = (DeptService) ac.getBean("deptService");
		deptService.save(dept);
		
	}
}
