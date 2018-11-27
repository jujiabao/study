package cn.itcast.b_crud;

import java.io.Serializable;
import java.util.List;

import cn.itcast.a_hello.Employee;

public interface IEmployeeDao {

	void save(Employee emp);
	void update(Employee emp);
	Employee findById(Serializable id);
	List<Employee> getAll();
	List<Employee> getAll(String employeeName);
	List<Employee> getAll(int index, int count);
	void delete(Serializable id);
	
}
