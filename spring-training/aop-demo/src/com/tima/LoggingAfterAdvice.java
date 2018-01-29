package com.tima;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class LoggingAfterAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object retVal, Method methodName,
			Object[] params, Object target) throws Throwable {

		System.out.println("Exiting method" + methodName.getName());
		System.out.println("Params" + params.toString());
		System.out.println("Target" + target.getClass());
		System.out.println("return value" + retVal);
	}

}
