package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@SpringBootApplication
public class SpringbootAppApplication {

	public static void main(String[] args) {
		var app = new SpringApplication(SpringbootAppApplication.class);
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active","dev"));
		var ctx=app.run(args);
		MyFirstService bean = ctx.getBean(MyFirstService.class);
		System.out.println(bean.tellStory());
		System.out.println(bean.getCustomProperty());
		System.out.println(bean.getCustompropertyfromAnotherField());
		System.out.println(bean.getCustomPropertyInt());
		System.out.println(bean.getCustompropertyfromAnotherField2());
	}
}

