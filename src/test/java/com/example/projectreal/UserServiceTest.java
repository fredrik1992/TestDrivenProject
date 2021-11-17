package com.example.projectreal;
import com.example.projectreal.Controller.LoginController;
import com.example.projectreal.Models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserServiceTest {
    @Autowired UserService userService;
    LoginController loginController;
    @BeforeEach
    void setUp() {

    }

    @Test
    void test_get_user()  {
       User user = new User("fredrik","lady2005");
       userService.addUser(user);
        User savedUser = userService.getUser("fredrik");
        assertEquals("fredrik",savedUser.getUsername());

    }
    @Test
    void test_add_user(){ // need to fix null value

        User user = new User("fredrik","lady2005");
        userService.addUser(user);
        assertEquals("fredrik",userService.getUser("fredrik").getUsername());
    }







}
