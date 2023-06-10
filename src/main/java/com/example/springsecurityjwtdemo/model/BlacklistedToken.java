package com.example.springsecurityjwtdemo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "blacklisted_tokens", uniqueConstraints = { @UniqueConstraint(name = "jti_unique", columnNames = { "jti" }) })
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
