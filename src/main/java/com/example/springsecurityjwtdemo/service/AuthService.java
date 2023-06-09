package com.example.springsecurityjwtdemo.service;

import com.example.springsecurityjwtdemo.dto.LoginRequest;
import com.example.springsecurityjwtdemo.dto.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtEncoder jwtEncoder;
    private final AuthenticationManager authenticationManager;
    private final BlacklistedTokenService blacklistedTokenService;

    public Authentication authenticateUser(LoginRequest loginRequest) {
        var usernamePasswordToken = new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password());
        return authenticationManager.authenticate(usernamePasswordToken);
    }

    public TokenResponse generateToken(Authentication authentication) {
        var now = Instant.now();
        var expiresAt = now.plus(1, ChronoUnit.HOURS);

        var scope = authentication
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));

        JwtClaimsSet claims = JwtClaimsSet
                .builder()
                .id(UUID.randomUUID().toString())
                .issuer("self")
                .issuedAt(now)
                .expiresAt(expiresAt)
                .subject(authentication.getName())
                .claim("scope", scope)
                .build();

        var accessToken = jwtEncoder
                .encode(JwtEncoderParameters.from(claims))
                .getTokenValue();

        return new TokenResponse(
                accessToken,
                OAuth2AccessToken.TokenType.BEARER.getValue(),
                Duration.between(now, expiresAt).toSeconds());
    }

    public void logout(Jwt jwt) {
        var jti = Optional
                .ofNullable(jwt.getClaims().get("jti"))
                .map(Object::toString)
                .orElseThrow(() -> new InvalidBearerTokenException("Invalid token"));

        blacklistedTokenService.blacklistToken(jti);
    }

}
