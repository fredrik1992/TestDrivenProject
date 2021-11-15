package com.example.projectreal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.mortbay.jetty.security.Password;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserHandler {

     Map<String,User> users = new HashMap<>();
     BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public boolean login(String username,String password) throws userDoesNotExistExpection {
        User user = users.get(username);

        if (!users.containsKey(username)){
            throw new userDoesNotExistExpection("userDoseNotExists");
        }
        if (encoder.matches(password,user.getPassword())) return true;
        return false;
    }

    public boolean registerNewAccount(String username, String password) {
        if (!users.containsKey(username)){
            String hashedPassword = encoder.encode(password);
            User newUser = new User(username,hashedPassword);

            users.put(username,newUser);

            return true;
        }
        return false;
    }


}
