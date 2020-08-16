package com.example.demo.repository;

import com.example.demo.model.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends MongoRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}