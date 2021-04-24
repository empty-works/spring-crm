package com.emptyworks.springcrm.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
	
	// Set up logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// Set up pointcut declaration
	
	// Add @Before advice
	
	// Add @AfterReturning advice
}
