package com.app.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("employeeDao")
public class EmployeeDao implements IDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	@Transactional(readOnly=true)
	public void query(String id) {
		Query query = getSession().createSQLQuery(
				"update ANALYTICS_PLAN set plan_name = 'Case16' where plan_id = :planId");
		query.setString("planId", id);
		query.executeUpdate();
		
		//List result = query.list();
		//result.size();
	}

}
