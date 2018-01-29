package com.app.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("manager")
public class ManagerService implements IService {

	static Logger log = Logger.getLogger(ManagerService.class.getName());

	@Override
	public void query(String id) {
		log.debug("Inside ManagerService-->insert method");

	}

}
