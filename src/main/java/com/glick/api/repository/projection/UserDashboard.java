package com.glick.api.repository.projection;

public class UserDashboard {
	
	private double carbohydrates;
	private Integer highs;
	private Integer lows;
	private double average;
	private double changes;
	private double score;
	
	public UserDashboard(Double carbohydrates, Integer highs, Integer lows, double average, double changes, double score){
		this.carbohydrates = carbohydrates;
		this.highs = highs;
		this.lows = lows;
		this.average = average;
		this.changes = changes;
		this.score = score;
	}
	
	public double getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(double carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	public Integer getHighs() {
		return highs;
	}

	public void setHighs(Integer highs) {
		this.highs = highs;
	}

	public Integer getLows() {
		return lows;
	}

	public void setLows(Integer lows) {
		this.lows = lows;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public double getChanges() {
		return changes;
	}

	public void setChanges(double changes) {
		this.changes = changes;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
}
