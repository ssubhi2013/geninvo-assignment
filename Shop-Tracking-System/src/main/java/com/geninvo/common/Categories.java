package com.geninvo.common;

public enum Categories {
	GENERAL_STORE("General Store"), MALL("Mall"), SUPERMARKET("Super Market"), MEDICAL_STORE("Medical Store");

	private String category;

	private Categories(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}
}
