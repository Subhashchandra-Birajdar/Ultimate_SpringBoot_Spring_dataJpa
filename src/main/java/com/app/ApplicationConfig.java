package com.app;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    @Qualifier("bean1")
    // here we are telling spring spring bean should inject bean1 or bean2 using @Qualifier
    public MyFirstClass myFirstClass() {
        return new MyFirstClass("first bean");
    }

    @Qualifier("bean2")
    @Bean
    public MyFirstClass mySecondBean() {
        return new MyFirstClass("Second bean");
    }
}
