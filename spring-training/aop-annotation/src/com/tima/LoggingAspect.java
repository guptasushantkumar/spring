package com.tima;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	@Pointcut("execution(* *.insert(..))")
	public void dummy() {

	}

	@Before("dummy()")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("inside method: "
				+ joinPoint.getSignature().getName() + " with arguments: "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(value = "execution(* *.insert(..))", returning = "r")
	public void logAfter(JoinPoint joinPoint, Object r) {
		System.out.println("exiting method: "
				+ joinPoint.getSignature().getName() + " with arguments: "
				+ Arrays.toString(joinPoint.getArgs()));

		System.out.println("Returning" + r);
	}
	/*
	 * @Around("execution(* *.insert(..))") public void logAround(JoinPoint
	 * joinPoint) { System.out.println("exiting method: " +
	 * joinPoint.getSignature().getName() + " with arguments: " +
	 * Arrays.toString(joinPoint.getArgs())); joinPoint.; }
	 */
}
