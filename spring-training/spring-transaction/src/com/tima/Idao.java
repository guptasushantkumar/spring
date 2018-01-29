package com.tima;

import java.util.List;

public interface Idao {

	public void insertEmployee(Employee e);

	public void updateEmployee(Employee e);

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(int empid);

	public int getEmployeeCOunt();

	public void insertEmployees(List<Employee> lstEmployees);

}
