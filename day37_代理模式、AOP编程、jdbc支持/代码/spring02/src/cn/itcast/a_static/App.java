package cn.itcast.a_static;

public class App {

	public static void main(String[] args) {
		// Ŀ�����
		IUserDao target = new UserDao();
		
		// ����
		IUserDao proxy = new UserDaoProxy(target);
		proxy.save();  // ִ�е��ǣ�����ķ���
	}
}
