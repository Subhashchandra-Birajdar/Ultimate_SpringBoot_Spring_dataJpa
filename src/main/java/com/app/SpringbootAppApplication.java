package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootAppApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(SpringbootAppApplication.class, args);
		MyFirstService myFirstClass = ctx.getBean(MyFirstService.class);
		System.out.println(myFirstClass.tellStory());
		System.out.println(myFirstClass.getCustomProperty());
		System.out.println(myFirstClass.getCustompropertyfromAnotherField());
		System.out.println(myFirstClass.getCustomPropertyInt());
		System.out.println(myFirstClass.getCustompropertyfromAnotherField2());

	}
}
