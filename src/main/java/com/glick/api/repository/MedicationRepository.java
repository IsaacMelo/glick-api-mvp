package com.glick.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glick.api.model.Medication;
import com.glick.api.model.User;

public interface MedicationRepository extends JpaRepository<Medication, Long> {
	List<Medication> findByUser(User user);
}
