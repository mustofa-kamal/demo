package com.example.demo.services;

import com.example.demo.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserRegisterServiceTest {

    @Autowired


    UserRegisterService userRegisterService;

    @DisplayName("testFindByName test - service")
    @Test
    void testFindByName() {

        List<User> users = userRegisterService.findByName("Sohel");

        var user= users.get(0);

        assertThat(user.getName().equals("Sohel"));

    }

    @DisplayName("testFindByEmail test - service")
    @Test
    void testFindByEmail() {

        List<User> users = userRegisterService.findByEmail("jjjj@rr.com");

        var user= users.get(0);

        assertThat(user.getName().equals("jjjj@rr.com"));

    }



}