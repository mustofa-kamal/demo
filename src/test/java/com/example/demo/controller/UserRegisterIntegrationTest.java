package com.example.demo.controller;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserRegisterIntegrationTest {
    // bind the above RANDOM_PORT
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    void findsUserById() {

        var user = restTemplate.getForObject("http://localhost:" + port + "/users/5f2f1e224ea900299aa6e76e", List.class);


        var m= ((LinkedHashMap) user.get(0));

        assertThat(m.get("id").equals("5f2f1e224ea900299aa6e76e"));

        assertThat(m.get("name").equals("Sohel11"));
    }

}

