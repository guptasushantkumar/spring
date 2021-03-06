package com.tima;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDao implements Idao {

	@Autowired
	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public void insertEmployee(Employee e) {
		System.out.println("Inside class:->" + this.getClass().getName()
				+ " method:-> insertEmployee");
		String sql = "insert into employee(id, fname, lname) values(?,?,?)";
		template.update(sql, e.getEmpId(), e.getFname(), e.getLname());

		template.getDataSource();
	}

	@Override
	public void updateEmployee(Employee e) {
		System.out.println("Inside class:->" + this.getClass().getName()
				+ " method:-> updateEmployee");
		String sql = "update employee set fname=?, lname=? where id =?";
		template.update(sql, e.getFname(), e.getLname(), e.getEmpId());

		// template.getDataSource();

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

}
