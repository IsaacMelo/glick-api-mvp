package com.glick.api.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.glick.api.model.User;


public class UserSystem extends UserSecurity {

	private static final long serialVersionUID = 1L;

	private User user;

	public UserSystem(User user, Collection<? extends GrantedAuthority> authorities) {
		super(user.getEmail() , user.getPassword(), authorities);
		this.user = user;
	}

	public User getUser() {
		return user;
	}

}
