package com.iaeste.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaeste.dao.JwtuserDAO;
import com.iaeste.model.JwtUser;

@Service
public class JwtUserServiceImpl implements JwtUserService {

	@Autowired
	private JwtuserDAO user;
	
	@Override
	public JwtUser getActiveUser(String userName) {
		return user.getActiveUser(userName);
	}

}
