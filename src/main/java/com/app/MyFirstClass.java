package com.app;

import org.springframework.stereotype.Component;

@Component // or @Service, @Repository
public class MyFirstClass{

    public String sayHello(){
        return "Hello from the MyFirstClass";
    }
}
