package com.app;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class ApplicationConfig {

    @Bean
    public MyFirstClass myFirstBean() {
        return new MyFirstClass("first bean");
    }

    @Bean
    public MyFirstClass mySecondBean() {
        return new MyFirstClass("Second bean");
    }

    @Bean
    public MyFirstClass myThirdClass() {
        return new MyFirstClass("third bean");
    }
}
