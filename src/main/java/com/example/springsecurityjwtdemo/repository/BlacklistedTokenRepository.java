package com.example.springsecurityjwtdemo.repository;

import com.example.springsecurityjwtdemo.model.BlacklistedToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlacklistedTokenRepository extends JpaRepository<BlacklistedToken, Long> {
}
