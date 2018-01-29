package com.tima;

import org.springframework.context.ApplicationEvent;

public class EmployeeRecruitedEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7703750833885542431L;
	private String name;

	public String getName() {
		return name;
	}

	public EmployeeRecruitedEvent(Object source, String name) {
		super(source);
		this.name = name;
	}

}
