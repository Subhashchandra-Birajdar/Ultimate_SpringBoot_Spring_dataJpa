package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootAppApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(SpringbootAppApplication.class, args);
		MyFirstClass bean = ctx.getBean(MyFirstClass.class); // here not created manual instance
		System.out.println(bean.sayHello());
	}

	// but this approach we can't follow , we follow like this
	@Bean
	public MyFirstClass myFirstClass(){
		return new MyFirstClass();
	}
}
