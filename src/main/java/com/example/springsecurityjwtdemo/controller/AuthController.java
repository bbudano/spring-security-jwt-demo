package com.example.springsecurityjwtdemo.controller;

import com.example.springsecurityjwtdemo.dto.LoginRequest;
import com.example.springsecurityjwtdemo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/token")
    public String token(@RequestBody LoginRequest loginRequest) {
        var authentication = authService.authenticateUser(loginRequest);
        return authService.generateToken(authentication);
    }

}
