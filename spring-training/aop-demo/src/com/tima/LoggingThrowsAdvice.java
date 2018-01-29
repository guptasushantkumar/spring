package com.tima;

import org.springframework.aop.ThrowsAdvice;

public class LoggingThrowsAdvice implements ThrowsAdvice {

	public void afetrThrowing(NullPointerException e) {

	}

	public void afetrThrowing(Exception e) {

	}
}
