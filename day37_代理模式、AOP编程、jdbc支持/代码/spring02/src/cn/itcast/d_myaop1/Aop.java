package cn.itcast.d_myaop1;

import org.springframework.stereotype.Component;

@Component  // ����IOC����  �����棩
public class Aop {

	// �ظ�ִ�еĴ���
	public void begin(){
		System.out.println("��ʼ����/�쳣");
	}
	public void commite(){
		System.out.println("�ύ����/�ر�");
	}
}
