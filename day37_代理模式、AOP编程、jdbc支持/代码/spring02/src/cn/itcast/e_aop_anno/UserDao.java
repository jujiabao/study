package cn.itcast.e_aop_anno;

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
