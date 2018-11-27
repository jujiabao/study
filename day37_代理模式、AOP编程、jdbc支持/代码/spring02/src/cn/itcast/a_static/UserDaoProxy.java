package cn.itcast.a_static;

/**
 * �������(��̬����)
 * 	   �������Ҫʵ����Ŀ�����һ���Ľӿ�
 * @author Jie.Yuan
 *
 */
public class UserDaoProxy implements IUserDao{

	// ���ձ���Ŀ�����
	private IUserDao target;
	public UserDaoProxy(IUserDao target) {
		this.target = target;
	}
	
	@Override
	public void save() {
		System.out.println("��ʼ����...");
		
		target.save(); 			// ִ��Ŀ�����ķ���
		
		System.out.println("�ύ����...");
	}
	
	
	
}
