package cn.itcast.d_myaop1;

import org.springframework.stereotype.Component;

/**
 * Ŀ�����
 * @author Jie.Yuan
 *
 */
@Component   // ��������
public class UserDao implements IUserDao{

	@Override
	public void save() {
		System.out.println("-----����ҵ�񣺱��棡����------");
	}

}
