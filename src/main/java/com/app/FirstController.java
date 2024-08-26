package com.app;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {

    // create end point
    @GetMapping("/")            // this is nothing but endpoint
    public String sayHello(){
        return "Hello from my first controller";    // httpStatus return 200 ok
    }      // what is the context path '/' ?

    @PostMapping("/posting")
    public String postMethod(@RequestBody String message){  // here we need to provide for example
        return "Request accepted and message is  :"+ message;
    }




}
