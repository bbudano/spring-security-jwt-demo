package com.example.springsecurityjwtdemo.repository;

import com.example.springsecurityjwtdemo.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {
}
