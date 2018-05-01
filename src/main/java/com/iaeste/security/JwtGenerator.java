package com.iaeste.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.iaeste.model.JwtUser;
import com.iaeste.service.JwtUserService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {

	@Autowired
	private JwtUserService userService;

	public String generate(JwtUser jwtUser) {

		JwtUser activeUser = null;

		activeUser = userService.getActiveUser(jwtUser.getUserName());

		if (activeUser.getUserName() != null && activeUser.getPassword() != null
				&& activeUser.getUserName().equals(jwtUser.getUserName())
				&& new BCryptPasswordEncoder().matches(jwtUser.getPassword(), activeUser.getPassword())) {

			Claims claims = Jwts.claims().setSubject(jwtUser.getUserName());
			claims.put("userId", String.valueOf(activeUser.getId()));
			claims.put("role", activeUser.getRole());

			return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512,SecurityConstant.SECRET).compact();
		}
		return null;

	}
}