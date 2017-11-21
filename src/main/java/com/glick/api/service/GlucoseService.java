package com.glick.api.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.glick.api.model.Glucose;
import com.glick.api.model.Score;
import com.glick.api.model.ScoreType;
import com.glick.api.model.User;
import com.glick.api.repository.GlucoseRepository;
import com.glick.api.service.event.score.ScoreEvent;

@Service
public class GlucoseService {
	@Autowired
	private GlucoseRepository glucoseRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;

	public List<Glucose> listAll() {
		return glucoseRepository.findAll();
	}

	public Glucose find(Long id) {
		Glucose glucose = glucoseRepository.findOne(id);

		if (glucose == null) {
			throw new ResourceNotFoundException("Glucose reading not found.");
		}

		return glucose;

	}

	public List<Glucose> findByModifyDateBetween(Date startDate, Date endDate) {
		return glucoseRepository.findByModifyDateBetween(startDate, endDate);
	}

	public List<Glucose> findByUser(User user) {
		return glucoseRepository.findByUser(user);
	}

	@Transactional
	public Glucose save(User user, Glucose glucose) {
		Score score = new Score();
		score.setUser(user);
		score.setQuantity(100);
		score.setType(ScoreType.GLUCOSE);
		
		glucose.setUser(user);
		glucose.setScore(score);
		return glucoseRepository.save(glucose);
	}

	public void delete(Long id) {
		try {
			glucoseRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Glucose not found.");
		}
	}

	public void update(User member, Glucose glucose) {
		isPresent(glucose);
		glucose.setUser(member);
		glucoseRepository.save(glucose);
	}

	private void isPresent(Glucose glucose) {
		find(glucose.getId());
	}
}
