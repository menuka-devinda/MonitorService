package com.menudev.serviceMontor;

public enum ServiceStatus {
	
	ServiceUp("Up"), ServiceDown("Down");
	
	private String value;
	
	ServiceStatus(String status) {
		this.value=status;
	}

	public String getValue() {
		return value;
	}
}
