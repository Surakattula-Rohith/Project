package com.stayplanner.auth_service.controller;

import com.stayplanner.auth_service.model.User;
import com.stayplanner.auth_service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/helloworld")
    public String printHello(){
        System.out.println("Printing Hello");
        return "Hello World" ;
    }

    @GetMapping("/getusers")
    public List<User> getUser(){
        return this.userService.getUser() ;
    }
}
