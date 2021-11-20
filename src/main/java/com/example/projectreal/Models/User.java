package com.example.projectreal.Models;

import com.example.projectreal.Interface.Rights;
import com.example.projectreal.Interface.Sources;
import org.mortbay.jetty.security.Password;

import java.util.HashMap;
import java.util.Map;


//@Value maby add this later ?
public class User {
    private String username;
    private String password;

    Map<Sources, Rights> priviliges = new HashMap<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean hasPriviligeAndRight(Sources source, Rights right) {  // the call should proberly be in userService
         return (priviliges.containsKey(source) && priviliges.get(source) == right) ? true : false;
    }

    public void addPrivilige(Sources source, Rights right) {

        priviliges.put(source,right);
    }

    public Rights getRights(Sources source) {
        return (priviliges.containsKey(source)) ? priviliges.get(source) : null;

    }
}

