package com.app.logging;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.app.service.ManagerService;

@Component
@Aspect
public class LoggingAspect {

	static Logger log = Logger.getLogger(ManagerService.class.getName());

	@Pointcut("execution(* com.app.*.*.*(..))")
	public void controllerAspect() {

	}

	@Before("controllerAspect()")
	public void logBefore(JoinPoint joinPoint) {
		log.error("ENTERING [" + joinPoint.getTarget().getClass() + "."
				+ joinPoint.getSignature().getName() + "()]");
	}

	@AfterReturning(pointcut = "controllerAspect()", returning = "retVal")
	public void logAfter(JoinPoint joinPoint, Object retVal) {
		log.error("EXITING [" + joinPoint.getTarget().getClass() + "."
				+ joinPoint.getSignature().getName() + "()]");

	}
}
