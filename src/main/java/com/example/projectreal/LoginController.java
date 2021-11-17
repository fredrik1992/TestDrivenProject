package com.example.projectreal;



import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {


    UserService userService = new UserService();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    public LoginController() {
        registerNewAccount("fredrik","lady2005");
    }

    @GetMapping("/loginControl")
    public boolean login_check(@RequestParam String username, @RequestParam String password) throws userDoesNotExistExpection {
        User user = userService.getUser(username);
        if (user == null) {
            throw new userDoesNotExistExpection("userDoseNotExists");
        }
        if (encoder.matches(password, user.getPassword())){
            System.out.print("in true");
            return true;
        }
        return false;
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


