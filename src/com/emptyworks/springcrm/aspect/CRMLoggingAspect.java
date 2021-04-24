package com.emptyworks.springcrm.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	// Set up logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// Set up pointcut declaration
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*.(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*.(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*.(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	// Add @Before advice
	
	// Add @AfterReturning advice
}
