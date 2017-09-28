package com.glick.api.service.event.score;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.glick.api.model.Score;
import com.glick.api.repository.ScoreRepository;

@Component
public class ScoreListener {
	
	@Autowired
	private ScoreRepository scoreRepository;

	@EventListener
	public void insertScore(ScoreEvent scoreEvent){
		Score score = new Score();
		score.setQuantity(scoreEvent.getQuantity());
		score.setUser(scoreEvent.getUser());
		
		scoreRepository.save(score);
	}
}
