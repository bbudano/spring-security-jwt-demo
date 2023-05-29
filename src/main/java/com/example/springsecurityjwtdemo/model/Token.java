package com.example.springsecurityjwtdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tokens")
public class Token {

    @Id
    private Long id;

    private String val;

}
