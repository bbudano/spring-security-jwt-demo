package com.example.springsecurityjwtdemo.service;

import com.example.springsecurityjwtdemo.model.BlacklistedToken;
import com.example.springsecurityjwtdemo.repository.BlacklistedTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlacklistedTokenService {

    private final BlacklistedTokenRepository blacklistedTokenRepository;

    public boolean existsByJti(String jti) {
        return blacklistedTokenRepository.existsByJti(jti);
    }

    public void blacklistToken(String jti) {
        var blacklistedToken = new BlacklistedToken(jti);
        blacklistedTokenRepository.saveAndFlush(blacklistedToken);
    }

}
