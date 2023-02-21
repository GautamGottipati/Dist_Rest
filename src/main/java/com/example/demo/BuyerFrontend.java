package com.example.demo;

import com.fasterxml.jackson.databind.util.JSONPObject;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.json.simple.JSONObject;

@RestController
public class BuyerFrontend {

    @GetMapping("/helloBuyer")
    public String helloWorld(){
        return "Hello-world";
    }


    @PostMapping("/buyer/createUser")
    public String createBuyerAccount(@RequestBody String payload){
        System.out.println(payload);
        return "User created Successfully";
    }

    @PostMapping("/buyer/login")
    public String loginBuyer(@RequestBody JSONObject payload){
//        System.out.println(payload);
        System.out.println("I am here");
        System.out.println((String) payload.get("name"));
        System.out.println((String) payload.get("password"));
        return "User logged in Successfully";
    }

//    @PostMapping("/login")
//    public String login(@RequestBody String payload){
//        System.out.println(payload);
//        return "User logged in Successfully";
//    }

    @PostMapping("/buyer/logout")
    public String logoutBuyer(@RequestBody String payload){
        System.out.println(payload);
        return "User logged out Successfully";
    }

    @PostMapping("/addToCart")
    public String addToShoppingCart(@RequestBody String payload){
        System.out.println(payload);
        return "put successful";
    }

    @DeleteMapping("/removeItem")
    public String removeFromShoppingCart(@RequestBody JSONObject payload){
        return "Removed Items";
    }

    @DeleteMapping("/clearCart")
    public String clearShoppingCart(@RequestBody JSONObject payload){
        return "Clear Cart";
    }

    @GetMapping("/display")
    public String displayShoppingCart(){
        return "Display function";
    }

    @PostMapping("/feedback")
    public String feedBackSeller(@RequestBody JSONObject payload){
        return "Feedback successful";
    }

    @GetMapping("/sellerRating")
    public String sellerRating(@RequestBody JSONObject payload){
        return "Seller Rating";
    }

    @GetMapping("/search")
    public String searchItems(@RequestBody JSONObject payload){
        return "Search item successful";
    }

    @GetMapping("/purchaseHistory")
    public String purchaseHistory(@RequestBody JSONObject payload){
        return "purchase History";
    }
    
    // @PutMapping("/update")
    // public String updateItemPrice(@RequestBody String payload){
    //     System.out.println(payload);
    //     return "Updated Successfully";
    // }
}

