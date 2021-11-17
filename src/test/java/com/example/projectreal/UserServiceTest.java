package com.example.projectreal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserServiceTest {
    UserService userService;
    LoginController loginController;
    @BeforeEach
    void setUp() {
        userService = new UserService();
        loginController = new LoginController();
    }

    @Test
    void test_get_user()  {
       User user = new User("fredrik","lady2005");
       userService.addUser(user);
        User savedUser = userService.getUser("fredrik");
        assertEquals("fredrik",savedUser.getUsername());

    }
    @Test
    void test_add_user(){ // need to fix null value

        User user = new User("fredrik","lady2005");
        userService.addUser(user);
        assertEquals("fredrik",userService.getUser("fredrik").getUsername());
    }







}
