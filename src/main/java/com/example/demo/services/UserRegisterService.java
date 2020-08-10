package com.example.demo.services;

import com.example.demo.model.User;

import java.util.List;

public interface UserRegisterService {

    User save(User user);

    List<User> getUser(String userId);

    List<User> findAllUsers();

    List<User> findByName(String name);

    List<User> findByEmail(String email);
}
