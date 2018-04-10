package com.sbt.spring_boot_tutorial;

import org.springframework.stereotype.Component;

@Component
public class Chinese {

	@Timer
	public void sayHello() throws InterruptedException {
		Thread.sleep(1000);
	}

	public String println(String msg) {
		msg.substring(0);
		return "println";
	}
}
