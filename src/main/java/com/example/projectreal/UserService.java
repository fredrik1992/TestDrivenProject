package com.example.projectreal;

import com.example.projectreal.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService { //should be service ?
    Map<String, User> users = new HashMap<>();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Autowired SecurityService securityService;

    public User getUser(String username) {
        return users.get(username);
    }

    public void addUser(User user) {
        users.put(user.getUsername(),user);
    }

    public String getUserToken(User user) {

        return securityService.generateUserToken(user);
    }

    public boolean login_verification(User user,String password) {

        if (encoder.matches(password, user.getPassword())){
            return true;
        }
        return false;

    }
}
