package com.example.projectreal;

import com.example.projectreal.Models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest
public class SecurityServiceTest {
    @Autowired UserService userService;
    @Autowired SecurityService securityService;
    @Test
    void test_generate_user_token_success(){ // will be adding user specific token here later ?

        User user = new User("fredrik","lady2005");
        userService.getUserToken(user);
        assertTrue((securityService.generateUserToken(user) instanceof String));
    }

}
