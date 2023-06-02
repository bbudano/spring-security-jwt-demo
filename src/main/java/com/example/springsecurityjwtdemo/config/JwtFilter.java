package com.example.springsecurityjwtdemo.config;

import com.example.springsecurityjwtdemo.service.BlacklistedTokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final BlacklistedTokenService blacklistedTokenService;
    private final JwtDecoder jwtDecoder;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if (request.getHeader("Authorization") != null) {
            var authHeader = request.getHeader("Authorization");
            var token = authHeader.substring(7);

            var jwt = jwtDecoder.decode(token);

            if (blacklistedTokenService.existsByJti(jwt.getClaim("jti"))) {
                throw new InvalidBearerTokenException("Invalid token");
            }
        }

        filterChain.doFilter(request, response);
    }

}
