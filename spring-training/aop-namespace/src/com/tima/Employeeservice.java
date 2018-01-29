package com.tima;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("target")
public class Employeeservice implements IService {
	@Autowired
	private IDao dao;

	
	public void setDao(IDao dao) {
		this.dao = dao;
	}

	@Override
	public void insert(Employee e) {
		System.out.println("Inside EmployeeService-->insert method");
		dao.insert(e);
	}

	@Override
	public void update(Employee e) {
		dao.update(e);

	}

	@Override
	public void remove(Employee e) {
		// TODO Auto-generated method stub

	}

}
