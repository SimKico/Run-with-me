package com.app.rwm.dto;

public class CooperDTO {

	private String username;
	public int distance;

	public CooperDTO(String username, int distance) {
		super();
		this.username = username;
		this.distance = distance;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public CooperDTO(int distance) {
		super();
		this.distance = distance;
	}

	public CooperDTO() {
		super();
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	
}
