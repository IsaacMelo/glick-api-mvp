package com.glick.api.repository.user;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.glick.api.model.User;
import com.glick.api.repository.projection.UserDashboard;

public class UserRepositoryImpl implements UserRepositoryQuery{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public UserDashboard findUserDashboad(User user) {
		return manager.createNamedQuery("User.dashboard", UserDashboard.class)
				.setParameter("userID", user.getId()).getSingleResult();
	}

}
