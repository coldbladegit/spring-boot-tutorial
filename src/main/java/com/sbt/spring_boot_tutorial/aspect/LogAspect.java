package com.sbt.spring_boot_tutorial.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	private long start = 0;

	@Pointcut("execution(* com.sbt.spring_boot_tutorial.Chinese.*(..))")
	public void pointcut() {
	}
	
	@Before("pointcut()")
	public void deBefore(JoinPoint jp) {
		System.out.println(jp.getSignature().getName() + "()");
		start = System.currentTimeMillis();
	}
	
	@After("pointcut()")
	public void doAfter() {
		System.out.println("cost_time = " + (System.currentTimeMillis() - start));
	}
	
	@AfterReturning(pointcut = "pointcut()", returning = "ret")
	public void dealReturn(Object ret) {
		if (null != ret) {
			System.out.println("return " + ret.toString());
		}
	}
	
	@AfterThrowing(pointcut = "pointcut()", throwing = "ex")
	public void dealException(Throwable ex) {
		System.out.println("exception......");
		ex.printStackTrace();
	}
	
	@Around("pointcut()")
	public void dealAround(ProceedingJoinPoint pjp) {
		Object[] args = pjp.getArgs();
		System.out.print("test around : ");
		for (Object object : args) {
			System.out.print(object.toString() + " ");
		}
		System.out.println();
		try {
			pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
