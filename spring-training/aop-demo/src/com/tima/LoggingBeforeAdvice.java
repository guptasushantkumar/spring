package com.tima;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class LoggingBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] params, Object target)
			throws Throwable {
		System.out.println("Inside method" + method.getName());
		System.out.println("Params" + params);
		System.out.println("Target" + target.getClass());
	}
}
