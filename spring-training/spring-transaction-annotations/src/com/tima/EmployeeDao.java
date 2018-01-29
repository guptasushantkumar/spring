package com.tima;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class EmployeeDao implements Idao {

	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = {Exception.class, IOException.class})
	public void insertEmployee(Employee e) {
		System.out.println("Inside class:->" + this.getClass().getName()
				+ " method:-> insertEmployee");

		String sql = "insert into employee(id, fname, lname) values(?,?,?)";
		template.update(sql, e.getEmpId(), e.getFname(), e.getLname());

	}

	@Override
	public void updateEmployee(Employee e) {
		System.out.println("Inside class:->" + this.getClass().getName()
				+ " method:-> updateEmployee");
		String sql = "update employee set fname=?, lname=? where id =?";
		template.update(sql, e.getFname(), e.getLname(), e.getEmpId());

	}

	@Override
	public Employee getEmployeeById(int empid) {
		System.out.println("Inside class:->" + this.getClass().getName()
				+ " method:-> getEmployeeById");
		String sql = "select * from employee where id =?";
		return template.queryForObject(sql, new Object[] { empid },
				new EmployeeRowMapper());
	}

	@Override
	public int getEmployeeCOunt() {
		System.out.println("Inside class:->" + this.getClass().getName()
				+ " method:-> getEmployeeCOunt");
		String sql = "select count(*) from employee";
		return template.queryForObject(sql, Integer.class);
	}

	@Override
	public java.util.List<Employee> getAllEmployees() {
		System.out.println("Inside class:->" + this.getClass().getName()
				+ " method:-> getAllEmployees");
		String sql = "select * from employee";
		// return template.query(sql,new
		// BeanPropertyRowMapper<Employee>(Employee.class));
		return template.query(sql, new EmployeeRowMapper());
	}

	@Override
	public void insertEmployees(List<Employee> lstEmployees) {
		System.out.println("Inside class:->" + this.getClass().getName()
				+ " method:-> insertEmployees");
		// String sql = "insert into employee(id, fname, lname) values(?,?,?)";

	}

}
