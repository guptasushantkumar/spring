package com.tima;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;

public class LoggingAspect {


	public void dummy() {

	}


	public void logBefore(JoinPoint joinPoint) {
		System.out.println("inside method: "
				+ joinPoint.getSignature().getName() + " with arguments: "
				+ Arrays.toString(joinPoint.getArgs()));
	}


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
