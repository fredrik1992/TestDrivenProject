package com.example.projectreal.Controller;



import com.example.projectreal.Expections.WrongPasswordExpection;
import com.example.projectreal.Expections.userDoesNotExistExpection;
import com.example.projectreal.Models.User;
import com.example.projectreal.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {


    @Autowired
    private UserService userService;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @GetMapping("/loginControl")
    public String login_check(@RequestParam String username, @RequestParam String password) throws userDoesNotExistExpection, WrongPasswordExpection {
        registerNewAccount("fredrik","lady2005"); //mock user for testing live
        User user = userService.getUser(username);
        if (user == null) {
            throw new userDoesNotExistExpection("userDoseNotExists");
        }

        if (userService.login_verification(user,password)){
            userService.getUserToken(user);
            return "WelcomePage.html";

        }
        throw new WrongPasswordExpection("wrongPassword");

    }

    @PostMapping("registerUser")
    public boolean registerNewAccount(String username, String password) {

        if (userService.getUser(username) == null) {
            String hashedPassword = encoder.encode(password);
            User newUser = new User(username, hashedPassword);

            userService.addUser(newUser);

            return true;
        }
        return false;
    }



}



