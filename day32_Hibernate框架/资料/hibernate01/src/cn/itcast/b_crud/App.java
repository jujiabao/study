package cn.itcast.b_crud;

import org.junit.Test;

import cn.itcast.a_hello.Employee;

public class App {
	
	private EmployeeDaoImpl empDao = new EmployeeDaoImpl();

	@Test
	public void testFindById() {
		System.out.println(empDao.findById(1));
	}

	@Test
	public void testGetAll() {
		System.out.println(empDao.getAll());
	}

	@Test
	public void testGetAllString() {
		System.out.println(empDao.getAll("����3"));
	}

	@Test
	public void testGetAllIntInt() {
		System.out.println(empDao.getAll(4, 2));
	}

	@Test
	public void testSave() {
		empDao.save(new Employee());
	}

	@Test
	public void testUpdate() {
		Employee emp = new Employee();
		emp.setEmpId(23);
		emp.setEmpName("new jack");
		
		empDao.update(emp);
	}

	@Test
	public void testDelete() {
		empDao.delete(23);
	}

}
