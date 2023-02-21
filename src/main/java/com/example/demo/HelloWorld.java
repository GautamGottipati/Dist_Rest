package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/rating/{name}")
    public String getRating(@PathVariable("name") String name) {
        return name;
    }

    @PostMapping("/createUser")
    public String createUser(@RequestBody String payload){
        System.out.println(payload);
        return "User created Successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody String payload){
        System.out.println(payload);
        return "User logged in Successfully";
    }

    @PostMapping("/logout")
    public String logout(@RequestBody String payload){
        System.out.println(payload);
        return "User logged out Successfully";
    }

    @PostMapping("/putItem")
    public String putItem(@RequestBody String payload){
        System.out.println(payload);
        return "put successful";
    }

    @PutMapping("/update")
    public String updateItemPrice(@RequestBody String payload){
        System.out.println(payload);
        return "Updated Successfully";
    }
}

