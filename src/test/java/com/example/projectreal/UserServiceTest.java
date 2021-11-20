package com.example.projectreal;

import com.example.projectreal.Controller.LoginController;
import com.example.projectreal.Interface.Rights;
import com.example.projectreal.Interface.Sources;
import com.example.projectreal.Models.User;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;
    @Autowired
    LoginController loginController;

    @BeforeEach
    void setUp() {
        userService.setUsers(new HashMap<>());
    }

    @Test
    void test_get_user() {
        User user = new User("fredrik", "lady2005");
        userService.addUser(user);
        User savedUser = userService.getUser("fredrik");
        assertEquals("fredrik", savedUser.getUsername());

    }

    @Test
    void test_add_user() { // need to fix null value

        User user = new User("fredrik", "lady2005");
        userService.addUser(user);
        assertEquals("fredrik", userService.getUser("fredrik").getUsername());
    }

    @Test
    void test_get_user_token_success() throws JSONException, UnsupportedEncodingException { // will be adding user specific token here later ?

        User user = new User("fredrik", "lady2005");
        userService.getUserToken(user);
        assertTrue((userService.getUserToken(user) instanceof String));
    }

    @Test
    void test_login_verification_success() {
        loginController.registerNewAccount("fredrik", "lady2005");
        User user = userService.getUser("fredrik");
        assertTrue(userService.login_verification(user, "lady2005")); //simulates some1 entering username the
    }

    @Test
    void test_add_user_privilige_success() {
        loginController.registerNewAccount("fredrik", "lady2005");
        User user = userService.getUser("fredrik");
        userService.addPriviligeToUser(user,Sources.ADMINPAGE, Rights.WRITE);
        assertTrue(user.hasPriviligeAndRight(Sources.ADMINPAGE,Rights.WRITE));

    }
    @Test
    void check_user_privilige_for_specific_source() {
        loginController.registerNewAccount("fredrik", "lady2005");
        User user = userService.getUser("fredrik");
        userService.addPriviligeToUser(user,Sources.ADMINPAGE, Rights.WRITE);
        assertTrue(user.getRights(Sources.ADMINPAGE) instanceof Rights );

    }






}
