package com.ea.crud.aop;

import java.util.Arrays;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
public class AopLogging {
    protected static transient Log log = LogFactory.getLog(AopLogging.class);
	
    //@Around("execution(* com.ea.crud.service.UserService.findByEmail(..))")
    public void logAfter(JoinPoint joinPoint) throws Throwable {
    	log.info("Login attempt:"+Arrays.toString(joinPoint.getArgs()));
    	
    }
    
}
