package com.example.projectreal;

import com.example.projectreal.Controller.LoginController;
import com.example.projectreal.Expections.WrongPasswordExpection;
import com.example.projectreal.Expections.UserDoesNotExistExpection;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LoginControllerTest {
    @Autowired
    LoginController loginController;
    @Autowired
    UserService userService;

    @BeforeEach
    void setUp() {
        userService.setUsers(new HashMap<>()); //cleans up  before each test
    }

    //https://metamug.com/article/security/jwt-java-tutorial-create-verify.html
    @Test
    void test_login_authentication_success() throws UserDoesNotExistExpection, WrongPasswordExpection, JSONException, UnsupportedEncodingException {
        loginController.registerUser("fredrik", "lady2005");
        assertTrue(loginController.login_check("fredrik", "lady2005") instanceof String); //simulates some1 entering username the
    }

    @Test
    void test_login_authentication_wrong_password() throws UserDoesNotExistExpection, WrongPasswordExpection {

        WrongPasswordExpection wrongPasswordExpection = assertThrows(WrongPasswordExpection.class, () -> loginController.login_check("fredrik", "lady2006"));
        assertEquals("wrongPassword", wrongPasswordExpection.getMessage());
    }
    @Test
    void test_login_authentication_user_not_exist() throws UserDoesNotExistExpection, WrongPasswordExpection {

         UserDoesNotExistExpection userDoesNotExistExpection = assertThrows(UserDoesNotExistExpection.class, () -> loginController.login_check("fredrikk", "lady2006"));
        assertEquals("userDoseNotExists", userDoesNotExistExpection.getMessage());
    }


    @Test
    void test_register_new_account_success() {
        assertTrue(loginController.registerUser("fredrik", "lady2005"));
    }

    @Test
    void test_register_new_account_user_exists() {//checks if user allredy exists maby add expections
        loginController.registerUser("fredrik", "lady2005");
        assertTrue(!loginController.registerUser("fredrik", "lady2005"));
    }


}
