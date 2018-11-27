package cn.itcast.a_query;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class App_page {
	
	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(Dept.class)   
			.addClass(Employee.class)   // ����ʱ��ʹ��
			.buildSessionFactory();
	}

	// ��ҳ��ѯ
	@Test
	public void all() {
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		 Query q = session.createQuery("from Employee");
		 
		 // �Ӽ�¼��
		 ScrollableResults scroll = q.scroll();  // �õ������Ľ����
		 scroll.last();							//  ���������һ��
		 int totalCount = scroll.getRowNumber() + 1;// �õ������ļ�¼�������ܼ�¼��
		 
		 // ���÷�ҳ����
		 q.setFirstResult(0);
		 q.setMaxResults(3);
		 
		 // ��ѯ
		 System.out.println(q.list());
		 System.out.println("�ܼ�¼����" + totalCount);
		
		session.getTransaction().commit();
		session.close();
	}
}











