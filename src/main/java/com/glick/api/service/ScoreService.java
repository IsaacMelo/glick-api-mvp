package com.glick.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glick.api.model.Score;
import com.glick.api.model.User;
import com.glick.api.repository.ScoreRepository;

@Service
public class ScoreService {
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	public Score insertScore(User user, double quantity){
		Score score = new Score();
		score.setQuantity(quantity);
		score.setUser(user);
		
		return scoreRepository.save(score);
	}
}
