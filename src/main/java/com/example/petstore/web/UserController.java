package com.example.petstore.web;

import com.example.petstore.model.User;
import com.example.petstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public String createUsers() {
        userService.createUsers();
        return "Users created successfully!";
    }

    @GetMapping("/list")
    public List<User> listUsers() {
        return userService.listUsers();
    }
}