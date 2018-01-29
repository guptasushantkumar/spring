package com.tima;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		System.out.println("Before " + invocation.getMethod().getClass().getName() + ":"
				+ invocation.getMethod().getName());
		Object retVal = null;
		try {
			retVal = invocation.proceed();
			throw new NullPointerException("");
		} catch (Exception e) {
			System.out.println("Exception " + invocation.getMethod().getClass().getName()
					+ ":" + invocation.getMethod().getName());
		}
		System.out.println("After " + invocation.getMethod().getClass().getName() + ":"
				+ invocation.getMethod().getName());
		return retVal;
	}

}
