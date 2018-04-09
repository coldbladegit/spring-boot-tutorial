package com.sbt.spring_boot_tutorial;

import org.springframework.stereotype.Component;

@Component
public class Chinese {
	
	@Timer
	public void sayHello() {
		System.out.println("Hello......");
	}
}
