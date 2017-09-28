package com.glick.api.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glick.api.model.Glucose;
import com.glick.api.model.User;

public interface GlucoseRepository extends JpaRepository<Glucose, Long> {
	List<Glucose> findByModifyDateBetween(Date startDate, Date endDate);
	List<Glucose> findByUser(User user);	
}
