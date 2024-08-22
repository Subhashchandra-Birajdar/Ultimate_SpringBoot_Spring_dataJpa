package com.app;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;

@Service
@PropertySources({
        @PropertySource("classpath:custom.properties"),
        @PropertySource("classpath:custom-1.properties")
})
public class MyFirstService {

    private final MyFirstClass myFirstClass;
    @Value("Hello Java")
    private String customProperty;
    @Value("${my.prop}")
    private String custompropertyfromAnotherField;
    @Value("123")
    private Integer  customPropertyInt;

    @Value("${my.prop1}")
    private String custompropertyfromAnotherField2;

    public String getCustomProperty() {
        return customProperty;
    }

    public String getCustompropertyfromAnotherField() {
        return custompropertyfromAnotherField;
    }

    public Integer getCustomPropertyInt() {
        return customPropertyInt;
    }


    public String getCustompropertyfromAnotherField2() {
        return custompropertyfromAnotherField2;
    }

    public MyFirstService(@Qualifier("mySecondBean")MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    public String tellStory() {
        return "The Dependency injection : "+myFirstClass.sayHello();
    }
}

