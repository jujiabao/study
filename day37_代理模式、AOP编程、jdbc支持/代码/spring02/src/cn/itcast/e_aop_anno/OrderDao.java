package cn.itcast.e_aop_anno;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Ŀ�����
 * @author Jie.Yuan
 *
 */
@Component   // ��������
@Scope("prototype")
public class OrderDao{

	public void save() {
		System.out.println("-----����ҵ�񣺱��棡����------");
	}
}
