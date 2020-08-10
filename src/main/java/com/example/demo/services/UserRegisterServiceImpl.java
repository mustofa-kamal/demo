package com.example.demo.services;


import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserRegisterServiceImpl implements UserRegisterService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user){
        user.setRegistrationDate(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public List<User> getUser(String userId) {
        Optional<User> optBook = userRepository.findById(userId);
        List list = new ArrayList<User>();

        if (optBook.isPresent()) {
            list.add(optBook.get());
        } else {
            // return null or throw
        }
        return list;
    }

    @Override
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public List<User> findByName(String name){
        return userRepository.findByName(name);
    }

    @Override
    public List<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
