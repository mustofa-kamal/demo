package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Document
public class AppUser {

    @Id
    private String id;


    private String username;


    private String password;

    private int active;

    private String roles = "";

    private String permissions = "";

    public AppUser(String username, String password, String roles, String permissions) {

        this.username = username;
        this.password = password;
        this.active = 1;
        this.roles = roles;
        this.permissions = permissions;
    }

    protected AppUser() {

    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getActive() {
        return active;
    }

    public String getRoles() {
        return roles;
    }

    public String getPermissions() {
        return permissions;
    }

    public List<String> getRoleList() {
        if (this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissionList() {
        if (this.permissions.length() > 0) {
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }

}


