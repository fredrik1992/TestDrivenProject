package com.example.projectreal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class LoginControllerTest {
    LoginController loginController;
    @BeforeEach
    void setUp() {
        loginController = new LoginController();

    }

    @Test
    void test_login_authentication_success() throws userDoesNotExistExpection {
        loginController.registerNewAccount("fredrik","lady2005");
        assertTrue(loginController.login_check("fredrik","lady2005")); //simulates some1 entering username the
    }
    @Test
    void test_register_new_account() {
        assertTrue(loginController.registerNewAccount("fredrik2","lady2005")); //Checks if the new user can login
    }

}
