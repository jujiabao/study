package cn.itcast.e_anno;

import org.springframework.stereotype.Component;

// �ѵ�ǰ�������ioc����
@Component("userDao")   //  �൱��bean.xml ��<bean id=userDao class=".." />��
public class UserDao {

	public void save() {
		System.out.println("DB:�����û�!!!");
	}
}
