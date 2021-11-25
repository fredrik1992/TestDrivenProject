package com.example.projectreal.Controller;

/* handles login/register requests and uses userservice to handle
 verification and getting of data  */

import com.example.projectreal.Expections.WrongPasswordExpection;
import com.example.projectreal.Expections.UserDoesNotExistExpection;
import com.example.projectreal.Models.User;
import com.example.projectreal.UserService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/loginControl")
    public String login_check(@RequestParam String username, @RequestParam String password) throws UserDoesNotExistExpection, WrongPasswordExpection, JSONException, UnsupportedEncodingException {
        registerUser("fredrik", "lady2005"); //mock user for testing live
        User user = userService.getUser(username);
        String userToken = null;
        if (user == null) {
            throw new UserDoesNotExistExpection("userDoseNotExists");
        } else if (userService.login_verification(user, password)) {

            userToken = userService.getUserToken(user);
            return userToken;
            //needs to send token here into website

        } else throw new WrongPasswordExpection("wrongPassword");
    }

    @PostMapping("registerUser")
    public boolean registerUser(String username, String password) {
           return userService.registerNewAccount(username,password);

    }


}



