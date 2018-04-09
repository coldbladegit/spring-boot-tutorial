package com.sbt.spring_boot_tutorial.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	@Pointcut("@annotation(com.sbt.spring_boot_tutorial.Timer)")
	public void webLog() {
	}

	@Before("webLog()")
	public void deBefore() throws Throwable {
		System.out.println("do before......");
	}
}
