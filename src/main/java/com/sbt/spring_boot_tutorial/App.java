package com.sbt.spring_boot_tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@RestController
public class App {

	@Autowired
	private Chinese chinese;

	@RequestMapping("/test")
	public void test() {
		try {
			chinese.sayHello();
			chinese.println("cold_blade");
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
