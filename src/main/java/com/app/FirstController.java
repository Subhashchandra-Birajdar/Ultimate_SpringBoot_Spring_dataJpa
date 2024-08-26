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

    // http method contain bunch of variable it is present in the @ResponseStatus
    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.ACCEPTED)
    // this is nothing but endpoint
    public String sayHello1(){ //localhost:8080/
        return "Hello1 from my first controller";
    }  // httpStatus return 202 ACCEPTED

    // PostMapping means clinet to send some data from client to server
    @PostMapping("/post")
    public String post(String message){  // here we need to provide for example
        return "Request accepted and message is  :"+ message;
    }


    @PostMapping("/posting")
    public String postMethod(@RequestBody String message){  // here we need to provide for example
        return "Request accepted and message is  :"+ message;
    }


    @PostMapping("/Order_Object")
    public String orderdisplay(@RequestBody Order order){
        return " the order is : "+ order.toString();
    }

    @PostMapping("/save/post-orderRecord")
    public String save(@RequestBody OrderRecord order){
        return " the orderRecord : " +order.toString();
    }





}
