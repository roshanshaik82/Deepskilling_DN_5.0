package com.sample.authservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.authservice.model.AuthenticationResponse;

@RestController
public class AuthenticationController {

    @GetMapping("/authenticate")
    public AuthenticationResponse authenticate() {

        return new AuthenticationResponse("Test Token");
    }

}