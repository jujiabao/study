package cn.itcast.e_anno2;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component("userService")  // userService����ioc����

//@Component

@Service   // ��ʾҵ���߼�������
public class UserService {
	
//	@Resource					//  �������Ͳ��� ����������Ҫȷ��������ֻ��һ��������
	
	@Resource(name = "userDao")  // �������Ʋ���
	private UserDao userDao;  // ȥ��������UserDao���͵ı������ҵ���͸�ֵ

	public void save() {
		userDao.save();
	}
}





