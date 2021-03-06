package com.example.projectreal;

import com.example.projectreal.Interface.Rights;
import com.example.projectreal.Interface.Sources;
import com.example.projectreal.Models.User;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    Map<String, User> users = new HashMap<>();

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Autowired
    SecurityService securityService;

    public User getUser(String username) {
        return users.get(username);
    }

    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public String getUserToken(User user) throws JSONException, UnsupportedEncodingException {

        return securityService.generateUserToken(user);
    }

    public boolean login_verification(User user, String password) {

        return (encoder.matches(password, user.getPassword())) ? true : false;
    }

    public boolean registerNewAccount(String username, String password) {

        if (getUser(username) == null) {
            String hashedPassword = encoder.encode(password);
            User newUser = new User(username, hashedPassword);

            addUser(newUser);

            return true;
        }
        return false;
    }
    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    public void addPriviligeToUser(User user, Sources source, Rights right) {
        user.addPrivilige(source,right);
    }
}
