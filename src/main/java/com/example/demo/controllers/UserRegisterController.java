package com.example.demo.controllers;

import com.example.demo.model.User;
import com.example.demo.services.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserRegisterController {

    @Autowired
    UserRegisterService userRegisterService;

    @PostMapping
    public User registerUser(@Valid @RequestBody final User user) {
        return userRegisterService.save(user);
    }


    @GetMapping("{userId}")
    public List<User> getBook(@PathVariable("userId") String userId) {
        List<User> users = userRegisterService.getUser(userId);
        return users;
    }

    @GetMapping
    List<User> findAll() {
        List<User> users = userRegisterService.findAllUsers();
        return users;
    }

    @GetMapping(params = "name")
    List<User> findByName(String name) {
        List<User> users = userRegisterService.findByName(name);
        return users;
    }

}
