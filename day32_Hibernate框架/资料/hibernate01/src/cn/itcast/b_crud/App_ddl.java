package cn.itcast.b_crud;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class App_ddl {

	// �Զ�����
	@Test
	public void testCreate() throws Exception {
		// �������ù��������
		Configuration config = new Configuration();
		// �����������ļ�
		config.configure();
		
		// �������������
		SchemaExport export = new SchemaExport(config);
		// ����
		// ��һ�������� �Ƿ��ڿ���̨��ӡ�������
		// �ڶ��������� �Ƿ�ִ�нű�
		export.create(true, true);
	}
}












