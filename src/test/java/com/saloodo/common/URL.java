package com.saloodo.common;

public enum URL {
	
	BASE_URL("https://demo.saloodo.com");
	
	public String value;
	
	URL(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
