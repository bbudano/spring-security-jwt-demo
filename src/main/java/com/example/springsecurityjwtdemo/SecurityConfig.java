package com.example.springsecurityjwtdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    UserDetailsService userDetailsService() {
        var users = List.of(
                User.withUsername("admin").password("{noop}admin").roles("ADMIN").build(),
                User.withUsername("user").password("{noop}user").roles("USER").build()
        );

        return new InMemoryUserDetailsManager(users);
    }

}
