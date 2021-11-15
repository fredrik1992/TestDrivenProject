package com.example.projectreal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserHandlerTest {
    UserHandler userHandler;
    @BeforeEach
    void setUp() {
        userHandler = new UserHandler();
        userHandler.registerNewAccount("fredrik","lady2005");
    }

    @Test
    void test_login_authentication() throws userDoesNotExistExpection {
        assertTrue(userHandler.login("fredrik","lady2005")); //simulates some1 entering username the
    }
    @Test
    void test_register_new_account() {
        assertTrue(userHandler.registerNewAccount("fredrik","lady2005")); //Checks if the new user can login
    }




}
