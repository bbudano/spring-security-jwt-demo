package com.example.springsecurityjwtdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/protected")
public class ProtectedController {

    @GetMapping
    public String protectedResource() {
        return "This is a protected resource";
    }

    @GetMapping("/admin")
    public String adminResource() {
        return "This is an admin accessible resource";
    }

}
