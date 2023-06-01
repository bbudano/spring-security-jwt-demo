package com.example.springsecurityjwtdemo.controller;

import com.example.springsecurityjwtdemo.dto.LoginRequest;
import com.example.springsecurityjwtdemo.dto.TokenResponse;
import com.example.springsecurityjwtdemo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
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
    public TokenResponse token(@RequestBody LoginRequest loginRequest) {
        var authentication = authService.authenticateUser(loginRequest);
        return authService.generateToken(authentication);
    }

    @PostMapping("/logout")
    public void logout(@AuthenticationPrincipal Jwt jwt) {
        authService.logout(jwt);
    }

}
