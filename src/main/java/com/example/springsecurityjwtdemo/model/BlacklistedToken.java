package com.example.springsecurityjwtdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "blacklisted_tokens")
@NoArgsConstructor
public class BlacklistedToken {

    @Id
    @GeneratedValue
    private Long id;

    private String jti;

    private ZonedDateTime blacklistedAt = ZonedDateTime.now();

    public BlacklistedToken(String jti) {
        this.jti = jti;
    }

}
