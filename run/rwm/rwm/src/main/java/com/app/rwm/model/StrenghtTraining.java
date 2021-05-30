package com.app.rwm.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.app.rwm.enums.MUSCLES_GROUP;

@Entity
public class StrenghtTraining {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private MUSCLES_GROUP musclesGroup;
    
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private TrainingPlan trainingPlan;

	public StrenghtTraining() {
		super();
	}

	public StrenghtTraining(Long id, MUSCLES_GROUP musclesGroup, TrainingPlan trainingPlan) {
		super();
		this.id = id;
		this.musclesGroup = musclesGroup;
		this.trainingPlan = trainingPlan;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MUSCLES_GROUP getMusclesGroup() {
		return musclesGroup;
	}

	public void setMusclesGroup(MUSCLES_GROUP musclesGroup) {
		this.musclesGroup = musclesGroup;
	}

	public TrainingPlan getTrainingPlan() {
		return trainingPlan;
	}

	public void setTrainingPlan(TrainingPlan trainingPlan) {
		this.trainingPlan = trainingPlan;
	}
}
