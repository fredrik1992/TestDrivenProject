package com.example.projectreal;

import java.util.HashMap;
import java.util.Map;


public class UserService { //should be service ?
    Map<String,User> users = new HashMap<>();

    public User getUser(String username) {
        return users.get(username);
    }

    public void addUser(User user) {
        users.put(user.getUsername(),user);
    }
}
