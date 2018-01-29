package com.app.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IDao;

@Service("employee")
@Transactional
public class Employeeservice implements IService {

	static Logger log = Logger.getLogger(Employeeservice.class.getName());

	@Autowired()
	private IDao dao;

	@Override
	public void query(String id) {
		log.debug("Inside EmployeeService-->insert method");
		dao.query(id);
		throw new NullPointerException();
	}

}
