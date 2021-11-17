package com.example.projectreal;
import com.example.projectreal.Controller.LoginController;
import com.example.projectreal.Expections.userDoesNotExistExpection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class LoginControllerTest {
    @Autowired
    LoginController loginController;

    @BeforeEach
    void setUp() {


    }

    @Test
    void test_login_authentication_success() throws userDoesNotExistExpection {
        loginController.registerNewAccount("fredrik","lady2005");
        assertTrue(loginController.login_check("fredrik","lady2005")); //simulates some1 entering username the
    }
    @Test
    void test_login_authentication_wrong_password() throws userDoesNotExistExpection {
        assertTrue(!loginController.login_check("fredrik","lady2006"));
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
