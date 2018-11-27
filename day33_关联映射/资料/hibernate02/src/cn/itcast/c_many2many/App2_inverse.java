package cn.itcast.c_many2many;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import cn.itcast.a_collection.User;

public class App2_inverse {
	
	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(Project.class)   
			.addClass(Developer.class)   // ����ʱ��ʹ��
			.buildSessionFactory();
	}

	// ��Զ�
	//1. ����inverse���ԣ��Ա�������Ӱ��?
	// ��Ӱ�졣
	// inverse=false ���п���Ȩ������ά��������ϵ�� �������ݵ�ʱ���Ѷ����ϵ�����м��
	// inverse=true,  û�п���Ȩ�� �������м��������ݡ�
	@Test
	public void save() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		/*
		 * ģ�����ݣ� 
			����ϵͳ���ܼ���������
			OAϵͳ�����������ţ�
		 */
		// ������Ŀ����
		Project prj_ds = new Project();
		prj_ds.setPrj_name("����ϵͳ");
		Project prj_oa = new Project();
		prj_oa.setPrj_name("OAϵͳ");
		
		// ����Ա������
		Developer dev_cj = new Developer();
		dev_cj.setD_name("�ܼ�");
		Developer dev_wc = new Developer();
		dev_wc.setD_name("����");
		Developer dev_lz = new Developer();
		dev_lz.setD_name("����");
		// ��ϵ ����Ŀ����
		prj_ds.getDevelopers().add(dev_cj);
		prj_ds.getDevelopers().add(dev_wc); // ����ϵͳ���ܼ���������
		prj_oa.getDevelopers().add(dev_wc);
		prj_oa.getDevelopers().add(dev_lz); // OAϵͳ�����������ţ�
		
		
		// ����
//		session.save(dev_cj);
//		session.save(dev_wc);
//		session.save(dev_lz);
		
		session.save(prj_ds);
		session.save(prj_oa);   // ����Ҫ���ü������� 
		
		session.getTransaction().commit();
		session.close();
	}
	
	//2 .����inverse���ԣ� �Ի�ȡ����Ӱ�죿  ��
	@Test
	public void get() {
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		Project prj = (Project) session.get(Project.class, 1);
		System.out.println(prj.getPrj_name());
		System.out.println(prj.getDevelopers());
		
		
		session.getTransaction().commit();
		session.close();
	}
	
	//3. ����inverse���ԣ� �Խ����ϵӰ�죿
	// ��Ӱ�졣
	// inverse=false ,�п���Ȩ�� �����ϵ����ɾ���м������ݡ�
	// inverse=true, û�п���Ȩ�����ܽ����ϵ��
	@Test
	public void removeRelation() {
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		Project prj = (Project) session.get(Project.class, 7);
		prj.getDevelopers().clear();
		
		session.getTransaction().commit();
		session.close();
	}
	
	

	//3. ����inverse���ԣ���ɾ�����ݵ�Ӱ��?
	// inverse=false, �п���Ȩ�� ��ɾ���м�����ݣ���ɾ������
	// inverse=true, û�п���Ȩ�� ���ɾ���������б����ã��ᱨ�� ���򣬲ſ���ɾ��
	@Test
	public void deleteData() {
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		Project prj = (Project) session.get(Project.class, 1);
		session.delete(prj);
		
		session.getTransaction().commit();
		session.close();
	}
	
}
