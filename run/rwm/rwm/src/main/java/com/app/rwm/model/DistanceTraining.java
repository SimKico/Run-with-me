package com.app.rwm.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DistanceTraining {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Date date;
    private int distance;
    
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private TrainingPlan trainingPlan;

	public DistanceTraining() {
		super();
	}

	public DistanceTraining(Long id, Date date, int distance, TrainingPlan trainingPlan) {
		super();
		this.id = id;
		this.date = date;
		this.distance = distance;
		this.trainingPlan = trainingPlan;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public TrainingPlan getTrainingPlan() {
		return trainingPlan;
	}

	public void setTrainingPlan(TrainingPlan trainingPlan) {
		this.trainingPlan = trainingPlan;
	}

}
