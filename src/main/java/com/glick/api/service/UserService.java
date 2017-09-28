package com.glick.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.glick.api.model.User;
import com.glick.api.repository.UserRepository;
import com.glick.api.repository.projection.UserDashboard;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<User> listAll() {
		return userRepository.findAll();
	}

	public User find(Long id) {
		User user = userRepository.findOne(id);

		if (user == null) {
			throw new ResourceNotFoundException("User not found");
		}

		return user;
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public void delete(Long id) {
		try {
			userRepository.delete(id);
		} catch (EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException("User not found: " + ex);
		}
	}

	public void update(User user) {
		isPresent(user);
		userRepository.save(user);
	}

	private void isPresent(User user) {
		find(user.getId());
	}
	
	public UserDashboard findUserDashboad(User user) {
		return userRepository.findUserDashboad(user);
	}
}
