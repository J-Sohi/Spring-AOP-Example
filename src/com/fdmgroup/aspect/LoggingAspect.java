package com.fdmgroup.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class LoggingAspect {
	
	/**
	 * Following are dummy methods for the Spring Annotations which replace xml
	 * 
	 * The method names act like names for the pointcuts, like the id attributes in the xml
	 * */
	
	@Pointcut("execution (* com.fdmgroup.service.ShoppingCart.*(..))") // (..) = 0 or more
	private void anyMethod(){}
	
	@Pointcut("execution (* com.fdmgroup.service.ShoppingCart.*.remove*(*))") // (*) = 1 or more
	private void anyRemove(){}

	@Pointcut("execution (* com.fdmgroup.service.ShoppingCart.removeAll())")
	private void removeAll(){}

	@Pointcut("execution (* loop())")
	private void profilerLoop(){}

	/**
	 * 
	 * Annotations added later to demonstrate their use
	 * 
	 * The annotations here are working alongside the xml. Both are being used.
	 * 
	 */
	
	//Advice method
	@Before("anyMethod()")
	public void logBefore(JoinPoint jp){
		System.out.println("logBefore is called before " + jp.getSignature().getName() + "----->"
				+ Arrays.toString(jp.getArgs()));
	}

	//Advice method
	@After("anyRemove()")
	public void logAfter(JoinPoint jp){
		System.out.println("logAfter is called after " + jp.getSignature().getName() + "----->"
				+ Arrays.toString(jp.getArgs()));
	}
	
	//Advice method
	@After("removeAll()")
	public void logAfterThrowing(JoinPoint jp){
		System.out.println("logAfterThrowing is called after " + jp.getSignature().getName() + "----->"
				+ Arrays.toString(jp.getArgs()));
	}
	
	//Advice method
	@After("anyMethod()")
	public void logAfterReturningSuccessfully(JoinPoint jp){
		System.out.println("logAfterReturningSuccessfullyis called after " + jp.getSignature().getName() + "----->"
				+ Arrays.toString(jp.getArgs()));
	}

	
	//Advice method
	@Around("profilerLoop()")
	public Object profiling(ProceedingJoinPoint pjp){
		//before executing
		Object result = null;
		MethodSignature signature = (MethodSignature)pjp.getSignature();
		long startTime = System.nanoTime();
		
		//execute the method
		try {
			result = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		} 
				
		//after executing
		long stopTime = System.nanoTime();
		
		System.out.println("Execution of " + signature.getName() + " method took " + (stopTime - startTime)
				+ " ns.");
		
		return result;
	}
	
}
