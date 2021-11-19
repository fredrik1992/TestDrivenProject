package com.example.projectreal;

import com.example.projectreal.Models.User;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest
public class SecurityServiceTest {
    @Autowired UserService userService;
    @Autowired SecurityService securityService;
    User user;
    @BeforeEach
    void setUp() {
        user = new User("fredrik","lady2005");
    }

    @Test
    void test_generate_user_token_success() throws JSONException, UnsupportedEncodingException {

        userService.getUserToken(user);
        assertTrue((securityService.generateUserToken(user) instanceof String));
    }

    @Test
    void test_verify_user_token_success() throws JSONException, UnsupportedEncodingException {
        String token = userService.getUserToken(user);
        assertTrue(securityService.verifyToken(token));

    }

//https://stormpath.com/blog/beginners-guide-jwts-in-java
}
