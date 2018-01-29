package com.tima;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class EmployeeService implements Iservice {

	private Idao dao;

	public void setDao(Idao dao) {
		this.dao = dao;
	}

	@Autowired
	private PlatformTransactionManager jdbctrans;

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

	@Override
	public void insertEmployees(List<Employee> lstEmployees) {

		System.out.println("Inside class:->" + this.getClass().getName()
				+ " method:-> insertEmployees");

		DefaultTransactionDefinition def = new DefaultTransactionDefinition();

		TransactionStatus status = jdbctrans.getTransaction(def);

		System.out.println("Is transaction new SERVICE:"
				+ status.isNewTransaction());

		try {
			for (Employee empp : lstEmployees) {
				System.out.println("Before calling dao layer");
				dao.insertEmployee(empp);
				System.out.println("Data inserted");

			}
			if (!status.isCompleted()) {
				jdbctrans.commit(status);
			}
		} catch (Exception e) {
			System.out.println("Exception occured in SERVICE");
			if (!status.isCompleted()) {
				jdbctrans.rollback(status);
			}
			// e.printStackTrace();
		}
	}

}
