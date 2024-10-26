package com.mavi.demo_springboot.controller;

import com.mavi.demo_springboot.entity.User;
import com.mavi.demo_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(@RequestParam String username) {
        return userService.createUser(username);
    }

    @PostMapping("/bulk")
    public String addMultipleUsers() {
        userService.createMultipleUsers();
        return "Users created successfully!";
    }
}
