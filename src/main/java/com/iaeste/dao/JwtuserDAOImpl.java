package com.iaeste.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iaeste.model.JwtUser;

@Repository
@Transactional
public class JwtuserDAOImpl implements JwtuserDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public JwtUser getActiveUser(String userName) {
		JwtUser user = new JwtUser();
		List<?> list = entityManager.createQuery("SELECT u FROM JwtUser u WHERE u.userName=?")
				.setParameter(0, userName).getResultList();
		if (!list.isEmpty()) {
			user = (JwtUser) list.get(0);
		}
		return user;
	}

}
