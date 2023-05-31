package com.example.springsecurityjwtdemo.service;

import com.example.springsecurityjwtdemo.model.BlacklistedToken;
import com.example.springsecurityjwtdemo.repository.BlacklistedTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlacklistedTokenService {

    private final BlacklistedTokenRepository blacklistedTokenRepository;

    public BlacklistedToken blacklistToken(String val) {
        var blacklistedToken = new BlacklistedToken(val);
        return blacklistedTokenRepository.save(blacklistedToken);
    }

}
