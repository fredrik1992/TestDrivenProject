package com.example.projectreal;

import com.example.projectreal.Models.User;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class SecurityService {


    public String generateUserToken(User user) {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[24];
        random.nextBytes(bytes);
        String token = bytes.toString();
        return token;
    }
}
