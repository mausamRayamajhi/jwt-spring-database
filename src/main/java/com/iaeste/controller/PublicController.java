package com.iaeste.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class PublicController {

    @GetMapping("/hello")
    public String hello() {
        return "DEMO";
    }
}