package com.glick.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.glick.api.model.Medication;
import com.glick.api.model.User;
import com.glick.api.repository.MedicationRepository;

@Service
public class MedicationService {
	@Autowired
	private MedicationRepository medicationRepository;

	public List<Medication> listAll() {
		return medicationRepository.findAll();
	}

	public Medication find(Long id) {
		Medication medication = medicationRepository.findOne(id);

		if (medication == null) {
			throw new ResourceNotFoundException("Medication reading not found.");
		}

		return medication;
	}

	public List<Medication> findByUser(User User) {
		return medicationRepository.findByUser(User);
	}

	public Medication save(User user, Medication medication) {
		medication.setUser(user);

		return medicationRepository.save(medication);
	}

	public void delete(Long id) {
		try {
			medicationRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Medication not found.");
		}
	}

	public void update(User user, Medication medication) {
		isPresent(medication);
		medication.setUser(user);
		medicationRepository.save(medication);
	}

	private void isPresent(Medication medication) {
		find(medication.getId());
	}
}
