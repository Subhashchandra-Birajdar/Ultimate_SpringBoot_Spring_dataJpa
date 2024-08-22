package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    @Autowired
    @Qualifier("myThirdClass")
    private MyFirstClass myFirstClass;

    public String tellStory() {
        return "The Dependency injection : "+myFirstClass.sayHello();
    }
}

