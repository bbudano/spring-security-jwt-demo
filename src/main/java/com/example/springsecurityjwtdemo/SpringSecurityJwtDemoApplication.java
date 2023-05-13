package com.example.springsecurityjwtdemo;

import com.example.springsecurityjwtdemo.config.RSAKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RSAKeyProperties.class)
public class SpringSecurityJwtDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtDemoApplication.class, args);
	}

}
