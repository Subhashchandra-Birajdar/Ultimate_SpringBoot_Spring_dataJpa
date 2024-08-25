package com.app;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    // create end point
    @GetMapping("/")            // this is nothing but endpoint
    public String sayHello(){
        return "Hello from my first controller";    // httpStatus return 200 ok
    }      // what is the context path '/' ?

    // http method contain bunch of variable it is present in the @ResponseStatus
    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.ACCEPTED)
    // this is nothing but endpoint
    public String sayHello1(){ //localhost:8080/
        return "Hello1 from my first controller";
    }  // httpStatus return 202 ACCEPTED

}
