package com.fdmgroup.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {

	private void emptyMethod(){}

	private void emptyMethodForThrow(){}

	private void profiler(){}

	//Advice method
	public void logBefore(JoinPoint jp){
		System.out.println("logBefore is called before " + jp.getSignature().getName() + "----->"
				+ Arrays.toString(jp.getArgs()));
	}

	//Advice method
	public void logAfter(JoinPoint jp){
		System.out.println("logAfter is called after " + jp.getSignature().getName() + "----->"
				+ Arrays.toString(jp.getArgs()));
	}
	
	//Advice method
	public void logAfterThrowing(JoinPoint jp){
		System.out.println("logAfterThrowing is called after " + jp.getSignature().getName() + "----->"
				+ Arrays.toString(jp.getArgs()));
	}

}
