/**
 * 
 */
package com.tima;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author Administrator
 * 
 */
public class HRDepartment implements ApplicationContextAware {

	private ApplicationContext context;

	public void recruitEmployee() {
		System.out.println("Employee recruited");
		System.out
				.println("HR is going to publish event.. and all listeners will be notified");
		context.publishEvent(new EmployeeRecruitedEvent(this, "amit"));
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		this.context = arg0;

	}
}
