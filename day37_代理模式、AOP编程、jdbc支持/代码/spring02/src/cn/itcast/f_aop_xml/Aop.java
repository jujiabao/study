package cn.itcast.f_aop_xml;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// ������
public class Aop {
	
	public void begin(){
		System.out.println("��ʼ����/�쳣");
	}
	
	public void after(){
		System.out.println("�ύ����/�ر�");
	}
	
	public void afterReturning() {
		System.out.println("afterReturning()");
	}
	
	public void afterThrowing(){
		System.out.println("afterThrowing()");
	}
	
	public void around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("����ǰ....");
		pjp.proceed();  // ִ��Ŀ�귽��
		System.out.println("���ƺ�....");
	}
	
}















