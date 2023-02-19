package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello-world";
    }


    @GetMapping("/1/{name}/{password}")
    public String createSellerAccount(@PathVariable("name") String name, @PathVariable("password") String password) {
        return name+" + "+password;
    }
}

