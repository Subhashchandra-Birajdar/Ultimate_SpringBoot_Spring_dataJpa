package com.app;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:custom.properties")
// this is added, so if you want to more custom properties then you can add @PropertySources({ @PropertySource..})
public class MyFirstService {

    private final MyFirstClass myFirstClass;
    @Value("Hello Java")
    private String customProperty;
    @Value("${my.prop}")
    private String custompropertyfromAnotherField;
    @Value("123")
    private Integer  customPropertyInt;

    public String getCustompropertyfromAnotherField() {
        return custompropertyfromAnotherField;
    }

    public String getCustomProperty() {
        return customProperty;
    }

    public Integer getCustomPropertyInt() {
        return customPropertyInt;
    }

    public MyFirstService(@Qualifier("mySecondBean")MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    public String tellStory() {
        return "The Dependency injection : "+myFirstClass.sayHello();
    }
}
