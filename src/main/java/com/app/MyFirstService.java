package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {


    private MyFirstClass myFirstClass;

    @Autowired
    public void injectDependency(@Qualifier("mySecondBean")MyFirstClass myFirstClass){
        this.myFirstClass = myFirstClass;
    }

    public String tellStory() {
        return "The Dependency injection : "+myFirstClass.sayHello();
    }
}

