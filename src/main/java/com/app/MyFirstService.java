package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {
    //inject the bean
    private MyFirstClass myFirstClass;

    @Autowired // it is optinal on constructor
    public MyFirstService(@Qualifier("bean2") MyFirstClass myFirstClass) {
        //did constructor based dependency, autowire is optional becuase injecting only one bean
         this.myFirstClass = myFirstClass;
    }
    public String tellStory() {
        return "The Dependency injection : "+myFirstClass.sayHello();
    }
}

