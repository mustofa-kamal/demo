package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class UserRegisterIntegrationWithMockTest {
    // bind the above RANDOM_PORT
    @LocalServerPort
    private int port;

    @MockBean
    private UserRepository userRepository;


    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    void findsUserById() {

        var mockUser = new User("1", "Nipa", "nipa@dssd.com", LocalDateTime.now());

        var list = new ArrayList<User>();

        list.add(mockUser);

        when(userRepository.findByName("Nipa")).thenReturn(list);

        var user = restTemplate.getForObject("http://localhost:" + port + "users/?name=Nipa", List.class);

        var m= ((LinkedHashMap) user.get(0));

        assertThat(m.get("name").equals("Nipa"));

        assertThat(m.get("id").equals("1"));
    }

}
