package com.glick.api.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.glick.api.model.Medication;
import com.glick.api.model.User;
import com.glick.api.service.MedicationService;
import com.glick.api.service.UserService;

@RestController
@CrossOrigin(origins = {"http://localhost","file://"})
@RequestMapping("/api/v1/user")
public class MedicationResource {
	@Autowired
	private MedicationService medicationService;

	@Autowired
	private UserService userService;

	// Get a user and medication
	@RequestMapping(value = "/{id:[\\d]+}/medication", method = RequestMethod.GET)
	public ResponseEntity<?> findByMedication(@PathVariable("id") Long userId) {
		User user = userService.find(userId);
		return ResponseEntity.status(HttpStatus.OK).body(medicationService.findByUser(user));
	}

	// Save new medication
	@RequestMapping(value = "/{id:[\\d]+}/medication", method = RequestMethod.POST)
	public ResponseEntity<Void> saveMedication(@PathVariable("id") Long userId, @RequestBody Medication medication) {
		User user = userService.find(userId);
		medication = medicationService.save(user, medication);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();

		return ResponseEntity.created(uri).build();
	}

	// Delete medication
	@RequestMapping(value = "/{id:[\\d]+}/medication/{medicationId:[\\d]+}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteMedication(@PathVariable("id") Long id,
			@PathVariable("medicationId") Long medicationId) {
		medicationService.delete(medicationId);
		return ResponseEntity.noContent().build();
	}

	// Update medication
	@RequestMapping(value = "/{id:[\\d]+}/medication/{medicationId:[\\d]+}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateMedication(@RequestBody Medication medication, @PathVariable("id") Long userId,
			@PathVariable("medicationId") Long medicationId) {

		medication.setId(medicationId);
		User user = userService.find(userId);
		medicationService.update(user, medication);

		return ResponseEntity.noContent().build();
	}
}
