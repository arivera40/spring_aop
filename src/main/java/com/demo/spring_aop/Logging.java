package com.demo.spring_aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logging {

	@Pointcut("execution(* com.demo.spring_aop.Student.getName(..))")	// This is the 'Pointcut'
	public void selectAll() {
	}

	/**
	 * This is the method which I would like to execute before a selected method
	 * execution.
	 */
	@Before("selectAll()")	// This is the 'Advice'
	public void beforeAdvice() {	// This is the 'Join Point"
		System.out.println("Going to setup student profile.");
	}

	/**
	 * This is the method which I would like to execute after a selected method
	 * execution.
	 */
	@After("selectAll()")
	public void afterAdvice() {
		System.out.println("Student profile has been setup.");
	}

	/**
	 * This is the method which I would like to execute when any method returns.
	 */
	@AfterReturning(pointcut = "selectAll()", returning = "retVal")
	public void afterReturningAdvice(Object retVal) {
		if (retVal != null) {
			System.out.println("Returning:" + retVal.toString());
		} else {
			System.out.println("retVal is null");
		}
	}

	/**
	 * This is the method which I would like to execute if there is an exception
	 * raised.
	 */
	@AfterThrowing(pointcut = "selectAll()", throwing = "ex")
	public void afterThrowingAdvice(IllegalArgumentException ex) {
		System.out.println("There has been an exception: " + ex.toString());
	}

	@Around("selectAll()")
	public String aroundAdvice(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("Around advice (start)");
		Object[] args = jp.getArgs();

		if (args.length > 0) {
			System.out.println("Arguments Passed: ");
			for (int i = 0; i < args.length; i++) {
				System.out.print("arg " + (i + 1) + ": " + args[i]);
			}
		}
		Object result = jp.proceed(args);
		System.out.println("Around advice (end) " + result);
		return result.toString();
	}
}
