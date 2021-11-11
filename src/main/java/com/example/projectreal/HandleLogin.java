package com.example.projectreal;

import java.util.Map;

public class HandleLogin {

    private Map<String,String> existingUsers = Map.ofEntries(
            Map.entry("fredrik","lady2005"),
            Map.entry("test","test2")
    );

    public boolean login(String uname,String password) {
        if(existingUsers.get(uname) == password) return true;
        return false;
    }
}
