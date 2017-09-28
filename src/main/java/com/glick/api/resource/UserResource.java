package com.glick.api.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.glick.api.model.User;
import com.glick.api.service.UserService;

@RestController
@CrossOrigin(origins = {"http://localhost","file://"})
@RequestMapping("/api/v1/user")
public class UserResource {
	@Autowired
	private UserService userService;

	// Get all user
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listAll() {
		return ResponseEntity.status(HttpStatus.OK).body(userService.listAll());
	}

	// Save new user
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody User user) {
		String pass = user.getPassword();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(11);

		user.setPassword(encoder.encode(pass));
		user = userService.save(user);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	// Get a user
	@RequestMapping(value = "/{id:[\\d]+}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable("id") Long id) {
		User user = userService.find(id);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

	// Delete a user
	@RequestMapping(value = "/{id:[\\d]+}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}

	// Update a user
	@RequestMapping(value = "/{id:[\\d]+}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody User user, @PathVariable("id") Long id) {
		user.setId(id);
		userService.update(user);
		return ResponseEntity.noContent().build();
	}
	
	// Get a user
	@RequestMapping(value = "/{id:[\\d]+}/dashboard", method = RequestMethod.GET)
	public ResponseEntity<?> findUserDashboad(@PathVariable("id") Long id) {
		User user = userService.find(id);
		return ResponseEntity.status(HttpStatus.OK).body(userService.findUserDashboad(user));
	}
}
