package com.example.demo.controllers;

import com.example.demo.model.AppUser;
import com.example.demo.repository.AppUserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/all/users")

public class UsersApiController {
    private AppUserRepository appUserRepository;

    public void AppUserRepository(AppUserRepository appUserRepository) {

        this.appUserRepository = appUserRepository;
    }

    @GetMapping("test1")
    public String test1() {
        return "API Test 1";
    }

    @GetMapping("test2")
    public String test2() {
        return "API Test 2";
    }

    @GetMapping("users")
    public List<AppUser> users() {
        return this.appUserRepository.findAll();
    }

}
