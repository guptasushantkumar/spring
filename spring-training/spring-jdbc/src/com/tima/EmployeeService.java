package com.tima;

public class EmployeeService implements Iservice {

	private Idao dao;

	public void setDao(Idao dao) {
		this.dao = dao;
	}

	@Override
	public void insertEmployee(Employee e) {
		System.out.println("Inside class:->" + this.getClass().getName()
				+ " method:-> insertEmployee");
		dao.insertEmployee(e);
	}

	@Override
	public void updateEmployee(Employee e) {
		System.out.println("Inside class:->" + this.getClass().getName()
				+ " method:-> updateEmployee");
		dao.updateEmployee(e);
	}

	@Override
	public java.util.List<Employee> getAllEmployees() {
		System.out.println("Inside class:->" + this.getClass().getName()
				+ " method:-> getAllEmployees");
		return dao.getAllEmployees();
	}

	@Override
	public Employee getEmployeeById(int empid) {
		System.out.println("Inside class:->" + this.getClass().getName()
				+ " method:-> getEmployeeById");
		return dao.getEmployeeById(empid);
	}

	@Override
	public int getEmployeeCOunt() {
		System.out.println("Inside class:->" + this.getClass().getName()
				+ " method:-> getEmployeeCOunt");
		return dao.getEmployeeCOunt();
	}

}
