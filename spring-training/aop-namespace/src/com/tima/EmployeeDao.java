package com.tima;

import org.springframework.stereotype.Component;

@Component("dao")
public class EmployeeDao implements IDao {

	@Override
	public void insert(Employee e)  {
		System.out.println("Inside Employeedao-->insert method");
		
	}

	@Override
	public void update(Employee e) {
		//System.out.println("Inside Employeedao-->update method");

	}

	@Override
	public void remove(Employee e) {
		// TODO Auto-generated method stub

	}

}
