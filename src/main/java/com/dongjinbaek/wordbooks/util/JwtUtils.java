package com.dongjinbaek.wordbooks.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.dongjinbaek.wordbooks.dto.user.UserInfo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {

    @Value("${jwt.secret}")
    private String secret;

    public UserInfo parseToken(String token) {
        try {
            System.out.println(token);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            String userId = jwt.getSubject();
            return UserInfo.builder().userId(userId).build();
        } catch (JWTVerificationException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public String generateToken(String userId) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        String token = JWT.create().withSubject(userId).sign(algorithm);
        return "Bearer " + token;
    }
}