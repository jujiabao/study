package cn.itcast.g_pointcut;


/**
 * Ŀ�����
 * @author Jie.Yuan
 *
 */
public class UserDao implements IUserDao{

	@Override
	public void save() {
		System.out.println("-----����ҵ�񣺱��棡����------"); 
	}
}
