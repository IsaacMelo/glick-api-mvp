package com.glick.api.service.event.score;

import com.glick.api.model.User;

public class ScoreEvent {
	private User user;
	private Double quantity;

	public ScoreEvent(User user, double quantity) {
		this.user = user;
		this.quantity = quantity;
	}

	public User getUser() {
		return user;
	}

	public Double getQuantity() {
		return quantity;
	}
	
	
}
