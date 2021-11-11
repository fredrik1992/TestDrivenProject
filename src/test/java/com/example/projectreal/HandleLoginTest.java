package com.example.projectreal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HandleLoginTest {
    HandleLogin handleLogin;
    @BeforeEach
    void setUp() {
        handleLogin = new HandleLogin();
        handleLogin.registerNewAccount("fredrik","lady2005");
    }

    @Test
    void test_login_authentication() {
        assertTrue(handleLogin.login("fredrik","lady2005")); //simulates some1 entering username the
    }
    @Test
    void test_register_new_account() {
        assertTrue(handleLogin.registerNewAccount("fredriks","lady2005")); //Checks if the new user can login
    }
}
