package com.glick.api.resource;

import java.net.URI;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.glick.api.model.Glucose;
import com.glick.api.model.User;
import com.glick.api.service.GlucoseService;
import com.glick.api.service.UserService;

@RestController
@CrossOrigin(origins = {"http://localhost","file://"})
@RequestMapping("/api/v1/user")
public class GlucoseResource {

	@Autowired
	private GlucoseService glucoseService;

	@Autowired
	private UserService userService;

	// Get a user and glucose
	@CrossOrigin(origins = {"http://localhost:8100","file://"})
	@RequestMapping(value = "/{id:[\\d]+}/glucose", method = RequestMethod.GET)
	public HttpEntity<?> findByGlucose(@PathVariable("id") Long userId) {
		User user = userService.find(userId);
		return ResponseEntity.status(HttpStatus.OK).body(glucoseService.findByUser(user));
	}
	
	// Get a user and glucose
	@CrossOrigin(origins = {"http://localhost:8100","file://"})
	@RequestMapping(value = "/{id:[\\d]+}/glucose/{glucoseId}", method = RequestMethod.GET)
	public HttpEntity<?> findByGlucose(@PathVariable("id") Long userId, @PathVariable("glucoseId") Long glucoseId) {
		// User user = userService.find(userId);
		return ResponseEntity.status(HttpStatus.OK).body(glucoseService.find(glucoseId));
	}

	// Get a user and glucose
	@CrossOrigin(origins = {"http://localhost:8100","file://"})
	@RequestMapping(value = "/{id:[\\d]+}/glucose", params = { "startDate", "endDate" }, method = RequestMethod.GET)
	public HttpEntity<?> findByGlucoseAndDate(@PathVariable("id") Long userId,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {

		userService.find(userId);
		return ResponseEntity.status(HttpStatus.OK).body(glucoseService.findByModifyDateBetween(startDate, endDate));
	}

	// Save new glucose
	@CrossOrigin(origins = {"http://localhost:8100","file://"})
	@RequestMapping(value = "/{id:[\\d]+}/glucose", method = RequestMethod.POST)
	public ResponseEntity<Void> saveGlucose(@PathVariable("id") Long userId, @RequestBody Glucose glucose) {
		User user = userService.find(userId);
		glucose = glucoseService.save(user, glucose);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();

		return ResponseEntity.created(uri).build();
	}

	// Delete glucose
	@CrossOrigin(origins = {"http://localhost:8100","file://"})
	@RequestMapping(value = "/{id:[\\d]+}/glucose/{glucoseId:[\\d]+}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteGlucose(@PathVariable("id") Long id, @PathVariable("glucoseId") Long glucoseId) {
		glucoseService.delete(glucoseId);
		return ResponseEntity.noContent().build();
	}

	// Update glucose
	@CrossOrigin(origins = {"http://localhost:8100","file://"})
	@RequestMapping(value = "/{id:[\\d]+}/glucose/{glucoseId:[\\d]+}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateGlucose(@RequestBody Glucose glucose, @PathVariable("id") Long userId,
			@PathVariable("glucoseId") Long glucoseId) {

		glucose.setId(glucoseId);
		User user = userService.find(userId);
		glucoseService.update(user, glucose);

		return ResponseEntity.noContent().build();
	}
}
