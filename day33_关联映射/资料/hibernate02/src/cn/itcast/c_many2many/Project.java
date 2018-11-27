package cn.itcast.c_many2many;

import java.util.HashSet;
import java.util.Set;

/**
 * ��Ŀ
 * 
 * @author Jie.Yuan
 * 
 */
public class Project {
	private int prj_id;
	private String prj_name;
	// ��Ŀ�µĶ��Ա��
	private Set<Developer> developers = new HashSet<Developer>();
	
	
	public int getPrj_id() {
		return prj_id;
	}
	public void setPrj_id(int prjId) {
		prj_id = prjId;
	}
	public String getPrj_name() {
		return prj_name;
	}
	public void setPrj_name(String prjName) {
		prj_name = prjName;
	}
	public Set<Developer> getDevelopers() {
		return developers;
	}
	public void setDevelopers(Set<Developer> developers) {
		this.developers = developers;
	}
	
	
}
