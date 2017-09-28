package com.glick.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glick.api.model.User;
import com.glick.api.repository.user.UserRepositoryQuery;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryQuery {
	Optional<User> findByEmail(String email);
}
