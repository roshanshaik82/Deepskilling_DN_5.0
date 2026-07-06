package com.cognizant.jwt.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {

        LOGGER.info("START");

        LOGGER.debug("Authorization Header : {}", authHeader);

        // Get username from Authorization header
        String user = getUser(authHeader);

        LOGGER.debug("Authenticated User : {}", user);

        // Generate JWT Token
        String token = generateJwt(user);

        Map<String, String> map = new HashMap<>();
        map.put("token", token);

        LOGGER.info("END");

        return map;
    }

    /**
     * Reads the Authorization header, decodes it and returns the username.
     */
    private String getUser(String authHeader) {

        LOGGER.debug("Reading Authorization Header");

        // Remove "Basic "
        String encodedCredentials = authHeader.substring(6);

        LOGGER.debug("Encoded Credentials : {}", encodedCredentials);

        // Decode Base64
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);

        String decodedCredentials = new String(decodedBytes);

        LOGGER.debug("Decoded Credentials : {}", decodedCredentials);

        // Extract username
        String user = decodedCredentials.substring(0, decodedCredentials.indexOf(":"));

        LOGGER.debug("User : {}", user);

        return user;
    }

    /**
     * Generates JWT Token.
     */
    private String generateJwt(String user) {

        LOGGER.debug("Generating JWT for user : {}", user);

        JwtBuilder builder = Jwts.builder();

        builder.setSubject(user);

        // Set current time
        builder.setIssuedAt(new Date());

        // Expire after 20 minutes
        builder.setExpiration(new Date((new Date()).getTime() + 1200000));

        // Sign with secret key
        builder.signWith(SignatureAlgorithm.HS256, "secretkey");

        String token = builder.compact();

        LOGGER.debug("Generated Token : {}", token);

        return token;
    }
}