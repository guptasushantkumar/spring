package com.tima;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class clas) {

		return Employee.class.equals(clas);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Employee e = (Employee) target;
		ValidationUtils.rejectIfEmpty(errors, "empId", "error");
		ValidationUtils.rejectIfEmpty(errors, "fname", "error");
		ValidationUtils.rejectIfEmpty(errors, "lname", "error");
	}
}
