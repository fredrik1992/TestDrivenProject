package com.example.projectreal;

import java.util.HashMap;
import java.util.Map;

public class HandleLogin {
    private Map<String,String> existingUsers = new HashMap<>();


    public boolean login(String uname,String password) {
        if(existingUsers.get(uname) == password) return true;
        return false;
    }

    public boolean registerNewAccount(String username, String password) {
        //needs to be encrypted later
        if (!existingUsers.containsKey(username)){
            existingUsers.put(username,password);
            System.out.print(existingUsers.size());

            return true;
        }
        return false;
    }
}
