package com.iaeste.dao;

import com.iaeste.model.JwtUser;

public interface JwtuserDAO {
	public abstract JwtUser getActiveUser(String userName);
}
