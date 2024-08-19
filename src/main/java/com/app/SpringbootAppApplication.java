package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class SpringbootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAppApplication.class, args);
		// tight coupling manually created object
		MyFirstClass obj = new MyFirstClass();
		System.out.println(obj.sayHello()); // Hello from the MyFirstClass
		// but this approach we can't follow
	}
}
