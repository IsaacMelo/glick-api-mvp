package com.glick.api.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.glick.api.model.User;
import com.glick.api.repository.UserRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> userOptional = userRepository.findByEmail(email);
		
		User user = userOptional.orElseThrow(() -> new UsernameNotFoundException("user not found, or invalid password"));
		
		return new UserSystem(user, getRoles(user));
	}

	private Collection<? extends GrantedAuthority> getRoles(User user) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRoles().forEach(p -> authorities.add(new SimpleGrantedAuthority(p.getName().toUpperCase())));
		return authorities;
	}

}
