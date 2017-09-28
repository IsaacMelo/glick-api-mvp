package com.glick.api.repository.user;

import com.glick.api.model.User;
import com.glick.api.repository.projection.UserDashboard;

public interface UserRepositoryQuery {
	
	public UserDashboard findUserDashboad(User user);

}
