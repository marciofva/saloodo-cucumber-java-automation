package com.saloodo.common;

public enum Titles {
	
	SHIPPER_REGISTRATION("Saloodo! Thank you for creating your account with Saloodo!"),
	LOGIN("Saloodo! Login"),
	SHIPPER_DASHBOARD("Saloodo! Shipper Dashboard"),
	CARRIER_DASHBOARD("Saloodo! Carrier dashboard");
	
	public String value;
	
	Titles(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}

}
