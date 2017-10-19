package com.glick.api.model;

public enum ScoreType {
	FOOD("Food"),
	INSULIN("Insulin"),
	GLUCOSE("Glucose");
	
	private String label;

	ScoreType(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
