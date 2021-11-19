package com.example.projectreal;

import com.example.projectreal.Models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class SecurityService {


    public String generateUserToken(User user) throws JSONException, UnsupportedEncodingException {
        String jwt = Jwts.builder()
                .setSubject("users/TzMUocMF4p")
                .claim("name", "Robert Token Man")
                .signWith(
                        SignatureAlgorithm.HS256,
                        "secret".getBytes("UTF-8")
                )
                .compact();
        return jwt;
    }


    public boolean verifyToken(String token) throws UnsupportedEncodingException {
        String jwt = token;
                Jws<Claims> claims = Jwts.parser()
                .setSigningKey("secret".getBytes("UTF-8"))
                .parseClaimsJws(jwt);
        String scope = (String) claims.getBody().get("name");
        System.out.println(scope);
        return (scope.equals("Robert Token Man")) ? true : false;

    }
}
