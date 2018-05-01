package com.iaeste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iaeste.model.JwtUser;
import com.iaeste.security.JwtGenerator;

@RestController
@RequestMapping("/token")
public class TokenController {

	@Autowired
    private JwtGenerator jwtGenerator;

    @PostMapping
    public String generate(@RequestBody final JwtUser jwtUser) {

    	String token = jwtGenerator.generate(jwtUser);
    	
        return token !=null ? token : ""+HttpStatus.UNAUTHORIZED;

    }
}
