package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {


    private MyFirstClass myFirstClass;

    @Autowired
    public void setMyFirstClass(MyFirstClass myFirstClass) {
        // here we use @Qualifier & give bean name
        this.myFirstClass = myFirstClass;
        // but in spring boot 3 it will take first bean by default
    }

    public String tellStory() {
        return "The Dependency injection : "+myFirstClass.sayHello();
    }
}

