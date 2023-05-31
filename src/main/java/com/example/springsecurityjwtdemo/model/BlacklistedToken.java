package com.example.springsecurityjwtdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "blacklisted_tokens")
@NoArgsConstructor
public class BlacklistedToken {

    @Id
    private Long id;

    private String val;

    public BlacklistedToken(String val) {
        this.val = val;
    }

}
