package cn.itcast.e_anno2;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

//@Component("userAction")  // ����IOC����

//@Component

@Controller  // ���Ʋ�����
public class UserAction {

	@Resource
	private UserService userService;

	public String execute() {
		userService.save();
		return null;
	}
}








