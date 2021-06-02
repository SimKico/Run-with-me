package com.app.rwm.model;

import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.app.rwm.enums.INTENSITY;
import com.app.rwm.enums.LEVEL;
import com.app.rwm.enums.PREPARATION_TIME;
import com.app.rwm.enums.TIME_GOAL;

@Entity
public class TrainingPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	private Instant raceDate;
	private String raceLocation;
	private TIME_GOAL timeGoal;
	
	private boolean canceledPreparation;

    private INTENSITY intensityLevel;
    private LEVEL level;
	private PREPARATION_TIME preparationTime;
    
    @OneToMany(mappedBy = "trainingPlan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<IntervalTraining> intervalTraining = new HashSet<IntervalTraining>();
	 
    @OneToMany(mappedBy = "trainingPlan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<StrenghtTraining> strenghtTraining = new HashSet<StrenghtTraining>();

    @OneToMany(mappedBy = "trainingPlan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<DistanceTraining> distanceTraining = new HashSet<DistanceTraining>();

	public TrainingPlan() {
		super();
	}

	public TrainingPlan(Long id, Instant raceDate, String raceLocation, boolean canceledPreparation,
			INTENSITY intensityLevel, LEVEL level, PREPARATION_TIME preparationTime,
			Set<IntervalTraining> intervalTraining, Set<StrenghtTraining> strenghtTraining,
			Set<DistanceTraining> distanceTraining, TIME_GOAL timeGoal) {
		super();
		this.id = id;
		this.raceDate = raceDate;
		this.raceLocation = raceLocation;
		this.canceledPreparation = canceledPreparation;
		this.intensityLevel = intensityLevel;
		this.level = level;
		this.preparationTime = preparationTime;
		this.intervalTraining = intervalTraining;
		this.strenghtTraining = strenghtTraining;
		this.distanceTraining = distanceTraining;
		this.setTimeGoal(timeGoal);
	}

	public TrainingPlan(Instant raceDate, String raceLocation, TIME_GOAL timeGoal) {
		this.raceDate = raceDate;
		this.raceLocation = raceLocation;
		this.setTimeGoal(timeGoal);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public boolean isCanceledPreparation() {
		return canceledPreparation;
	}

	public void setCanceledPreparation(boolean canceledPreparation) {
		this.canceledPreparation = canceledPreparation;
	}

	public INTENSITY getIntensityLevel() {
		return intensityLevel;
	}

	public void setIntensityLevel(INTENSITY intensityLevel) {
		this.intensityLevel = intensityLevel;
	}

	public LEVEL getLevel() {
		return level;
	}

	public void setLevel(LEVEL level) {
		this.level = level;
	}

	public PREPARATION_TIME getPreparationTime() {
		return preparationTime;
	}

	public void setPreparationTime(PREPARATION_TIME preparationTime) {
		this.preparationTime = preparationTime;
	}

	public Set<IntervalTraining> getIntervalTraining() {
		return intervalTraining;
	}

	public void setIntervalTraining(Set<IntervalTraining> intervalTraining) {
		this.intervalTraining = intervalTraining;
	}

	public Set<StrenghtTraining> getStrenghtTraining() {
		return strenghtTraining;
	}

	public void setStrenghtTraining(Set<StrenghtTraining> strenghtTraining) {
		this.strenghtTraining = strenghtTraining;
	}

	public Set<DistanceTraining> getDistanceTraining() {
		return distanceTraining;
	}

	public void setDistanceTraining(Set<DistanceTraining> distanceTraining) {
		this.distanceTraining = distanceTraining;
	}

	public TIME_GOAL getTimeGoal() {
		return timeGoal;
	}

	public void setTimeGoal(TIME_GOAL timeGoal) {
		this.timeGoal = timeGoal;
	}
}
