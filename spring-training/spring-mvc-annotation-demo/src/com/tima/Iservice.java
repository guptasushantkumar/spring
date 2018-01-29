package com.tima;

import java.util.List;

public interface Iservice {

	public void insertEmployee(Employee e);
	
	public void updateEmployee(Employee e);

	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(int empid);
	
	public int getEmployeeCOunt();
}
