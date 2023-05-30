package com.example.springsecurityjwtdemo.service;

import com.example.springsecurityjwtdemo.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final TokenRepository tokenRepository;



}
