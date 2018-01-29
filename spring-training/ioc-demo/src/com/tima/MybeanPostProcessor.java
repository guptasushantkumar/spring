package com.tima;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MybeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1)
			throws BeansException {
		System.out.println("Inside method :-> postProcessAfterInitialization "
				+ arg0 + "BeanName: " + arg1);
		return arg0;
	}

	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1)
			throws BeansException {
		System.out.println("Inside method :-> postProcessBeforeInitialization "
				+ arg0 + "BeanName: " + arg1);
		return arg0;
	}

}
