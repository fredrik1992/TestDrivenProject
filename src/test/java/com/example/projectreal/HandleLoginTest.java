package com.example.projectreal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HandleLoginTest {
    HandleLogin handleLogin;
    @BeforeEach
    void setUp() {
        handleLogin = new HandleLogin();
    }

    @Test
    void test_login_authentication() {
        handleLogin = new HandleLogin();
        assertTrue(handleLogin.login("fredrik","lady2005")); //simulates some1 entering username the
    }
}
