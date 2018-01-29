package com.tima;

import org.springframework.context.ApplicationListener;

public class TechnicalDepartment implements
		ApplicationListener<EmployeeRecruitedEvent> {

	@Override
	public void onApplicationEvent(EmployeeRecruitedEvent empevent) {

		String name = empevent.getName();
		System.out.println("Technical department will do processing for:"
				+ name);
	}
}
