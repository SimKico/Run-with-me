package com.app.rwm.dto;

import java.time.Instant;
import java.util.Date;

import com.app.rwm.enums.TIME_GOAL;

public class RaceDataDTO {

	private Instant raceDate;
	private String raceLocation;
	private TIME_GOAL timeGoal;
	public RaceDataDTO() {
		super();
	}
	public RaceDataDTO(Instant raceDate, String raceLocation, TIME_GOAL timeGoal) {
		super();
		this.raceDate = raceDate;
		this.raceLocation = raceLocation;
		this.timeGoal = timeGoal;
	}
	public Instant getRaceDate() {
		return raceDate;
	}
	public void setRaceDate(Instant raceDate) {
		this.raceDate = raceDate;
	}
	public String getRaceLocation() {
		return raceLocation;
	}
	public void setRaceLocation(String raceLocation) {
		this.raceLocation = raceLocation;
	}
	public TIME_GOAL getTimeGoal() {
		return timeGoal;
	}
	public void setTimeGoal(TIME_GOAL timeGoal) {
		this.timeGoal = timeGoal;
	}
}
