package com.example.projectreal;

/*handles generating and verifying tokens from userService calls */

import com.example.projectreal.Models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class SecurityService {


    public String generateUserToken(User user) throws JSONException, UnsupportedEncodingException {
        String jwt = Jwts.builder()
                .claim("username", user.getUsername())
                .signWith(
                        SignatureAlgorithm.HS256,
                        "secret".getBytes("UTF-8")
                )
                .compact();
        return jwt;
    }


    public boolean verifyToken(User user,String token) throws UnsupportedEncodingException {
        String jwt = token;
        Jws<Claims> claims = Jwts.parser()
                .setSigningKey("secret".getBytes("UTF-8"))
                .parseClaimsJws(jwt);
        String scope = (String) claims.getBody().get("username");
        return (scope.equals(user.getUsername())) ? true : false;

    }

    public String getTokenUsername(String token) throws UnsupportedEncodingException {
        String jwt = token;
        Jws<Claims> claims = Jwts.parser()
                .setSigningKey("secret".getBytes("UTF-8"))
                .parseClaimsJws(jwt);
        String scope = (String) claims.getBody().get("username");
        System.out.println(scope);
        return scope;
    }
}
