package com.example.demo.repository;

import com.example.demo.model.AppUser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
    private AppUserRepository appUserRepositoryUser;
    private PasswordEncoder passwordEncoder;

    public DbInit(AppUserRepository appUserRepositoryUser, PasswordEncoder passwordEncoder) {
        this.appUserRepositoryUser = appUserRepositoryUser;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // Delete all
        this.appUserRepositoryUser.deleteAll();

        // Crete users
        AppUser sohel = new AppUser("sohel", passwordEncoder.encode("sohel123"), "USER", "");
        AppUser admin = new AppUser("admin", passwordEncoder.encode("admin123"), "ADMIN", "ACCESS_TEST1,ACCESS_TEST2");
        AppUser manager = new AppUser("manager", passwordEncoder.encode("manager123"), "MANAGER", "ACCESS_TEST1");

        List<AppUser> users = Arrays.asList(sohel, admin, manager);

        // Save to db
        this.appUserRepositoryUser.saveAll(users);
    }
}