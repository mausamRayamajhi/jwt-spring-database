package com.iaeste.service;

import com.iaeste.model.JwtUser;

public interface JwtUserService {
	public abstract JwtUser getActiveUser(String userName);
}
