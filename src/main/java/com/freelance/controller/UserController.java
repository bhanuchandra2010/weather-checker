package com.freelance.controller;

import com.freelance.entity.User;
import com.freelance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    // Define a method to handle GET requests at "/user"
    @GetMapping("/user")
    public Mono<User> getUser() {
        return userService.getUser();
    }

    // Define a method to handle POST requests at "/user"
}
