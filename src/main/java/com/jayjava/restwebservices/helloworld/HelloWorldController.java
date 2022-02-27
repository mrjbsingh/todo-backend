package com.jayjava.restwebservices.helloworld;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class HelloWorldController {
    
    //@RequestMapping(method = RequestMethod.GET, path ="/hello")
    @GetMapping(path = "/hello")
    public String helloWorld(){

        return "Hello Jay to java world";
    }

    @GetMapping(path = "/hello-bean/pv/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name){
        return new HelloWorldBean(String.format("Hellow World, %s", name));
        //return new RuntimeException("Something went wrong");
    }
}
