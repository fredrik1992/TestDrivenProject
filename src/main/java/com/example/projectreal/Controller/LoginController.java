package com.example.projectreal.Controller;



import com.example.projectreal.Models.User;
import com.example.projectreal.UserService;
import com.example.projectreal.Expections.userDoesNotExistExpection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {


    @Autowired
    private UserService userService;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @GetMapping("/loginControl")
    public boolean login_check(@RequestParam String username, @RequestParam String password) throws userDoesNotExistExpection {
        registerNewAccount("fredrik","lady2005"); //mock user for testing live
        User user = userService.getUser(username);
        if (user == null) {
            throw new userDoesNotExistExpection("userDoseNotExists");
        }
        if (encoder.matches(password, user.getPassword())){
            return true;
        }
        return false; // this is when user exist but password is not correct
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
       /*<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency> *  maby add later to dependecy*/


