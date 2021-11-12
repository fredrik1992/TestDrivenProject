package com.example.projectreal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HandleLogin {

    private Map<String,User> users = new HashMap<>();


    public boolean login(String uname,String password) {
        if(users.get(uname).getPassword() == password) return true;
        return false;
    }

    public boolean registerNewAccount(String username, String password) {
        //needs to be encrypted
        if (!users.containsKey(username)){
            String encryptedPassword = encryptPassword(password);
            User newUser = new User(username,password);
            users.put(username,newUser);
            return true;
        }
        return false;
    }


    public User getAccountData(String username, String password) throws userDoesNotExistExpection {
        User user = users.get(username);
        if(user == null){
            throw new userDoesNotExistExpection("userDoseNotExists");
        }
        if (user.getPassword() == password){
            return user;
        }
        return null;


    }

    private String encryptPassword(String password) {

    }
}
