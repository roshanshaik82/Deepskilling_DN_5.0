package com.sample.authservice.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.sample.authservice.model.AuthenticationResponse;
import com.sample.authservice.util.JwtUtil;

@RestController
public class AuthenticationController {

    @GetMapping("/authenticate")
    public AuthenticationResponse authenticate(
            @RequestHeader("Authorization") String authHeader) {

        System.out.println("Authorization Header : " + authHeader);

        String base64Credentials = authHeader.substring("Basic ".length());

        byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);

        String credentials = new String(decodedBytes, StandardCharsets.UTF_8);

        System.out.println("Decoded Credentials : " + credentials);

        String[] values = credentials.split(":");

        String username = values[0];
        String password = values[1];

        System.out.println("Username : " + username);
        System.out.println("Password : " + password);

        String token = JwtUtil.generateToken(username);

        return new AuthenticationResponse(token);
    }
}