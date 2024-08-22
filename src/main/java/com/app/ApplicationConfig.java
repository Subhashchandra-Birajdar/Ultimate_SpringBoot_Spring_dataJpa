package com.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean("myBean")   // <---- Bean naming performed
    public MyFirstClass myFirstClass() {
        return new MyFirstClass("first bean");
    }


}
