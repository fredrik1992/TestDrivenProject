package com.example.projectreal;
import com.example.projectreal.Controller.LoginController;
import com.example.projectreal.Expections.WrongPasswordExpection;
import com.example.projectreal.Expections.userDoesNotExistExpection;
import com.example.projectreal.Models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContextException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LoginControllerTest {
    @Autowired
    LoginController loginController;

    @BeforeEach
    void setUp() {


    }
//https://metamug.com/article/security/jwt-java-tutorial-create-verify.html
    @Test
    void test_login_authentication_success() throws userDoesNotExistExpection, WrongPasswordExpection {
        loginController.registerNewAccount("fredrik","lady2005");
        assertTrue(loginController.login_check("fredrik","lady2005") instanceof String); //simulates some1 entering username the
    }
    @Test
    void test_login_authentication_wrong_password() throws userDoesNotExistExpection, WrongPasswordExpection {

        WrongPasswordExpection wrongPasswordExpection = assertThrows(WrongPasswordExpection.class,() ->loginController.login_check("fredrik","lady2006"));
        assertEquals("wrongPassword",wrongPasswordExpection.getMessage());
    }


    @Test
    void test_register_new_account_success() {
        assertTrue(loginController.registerNewAccount("fredrik","lady2005"));
    }
    @Test
    void test_register_new_account_user_exists() {//checks if user allredy exists maby add expections
        loginController.registerNewAccount("fredrik","lady2005");
        assertTrue(!loginController.registerNewAccount("fredrik","lady2005"));
    }


}
