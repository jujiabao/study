package cn.itcast.f_aop_xml;


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
