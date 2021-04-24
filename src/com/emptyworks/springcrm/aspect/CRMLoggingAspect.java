package com.emptyworks.springcrm.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	// Set up logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// Set up pointcut declaration
	@Pointcut("execution(* com.emptyworks.springcrm.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.emptyworks.springcrm.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.emptyworks.springcrm.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	// Add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		// Display the method being called
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("======>> in @Before: calling method: " + theMethod);
		
		// Display the arguments to the method
		
		// Get the arguments
		Object[] args = theJoinPoint.getArgs();
		
		// Loop through and display args
		for(Object tempArg : args) {
			myLogger.info("=======>> argument: " + tempArg);
		}
	}
	
	// Add @AfterReturning advice
	@AfterReturning (
			pointcut="forAppFlow()", 
			returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		// Display method being returned from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("======>> in @AfterReturning: calling method: " + theMethod);
		
		// Display data returned 
		myLogger.info("=======>> result: " + theResult);
	}
}
