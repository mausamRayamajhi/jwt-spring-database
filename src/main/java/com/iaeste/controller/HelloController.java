package com.iaeste.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class HelloController {

    @GetMapping("/hello")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String hello() {
        return "Mausam ADMIN";
    }
    
    @GetMapping("/hellos")
    @PreAuthorize("hasAnyRole('USER')")
    public String hellos() {
        return "shrawan USER";
    }
    
    @GetMapping("/both")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public String both() {
        return "shrawan mausam";
    }
    
}