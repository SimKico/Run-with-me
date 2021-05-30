package com.app.rwm.model;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class IntervalTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date trainingDay;
    
    @OneToMany(mappedBy = "intervalTraining", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   	private Set<Sets> sets = new HashSet<Sets>();
     
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private TrainingPlan trainingPlan;

	public IntervalTraining() {
		super();
	}

	public IntervalTraining(Long id, Date trainingDay, Set<Sets> sets, TrainingPlan trainingPlan) {
		super();
		this.id = id;
		this.trainingDay = trainingDay;
		this.sets = sets;
		this.trainingPlan = trainingPlan;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTrainingDay() {
		return trainingDay;
	}

	public void setTrainingDay(Date trainingDay) {
		this.trainingDay = trainingDay;
	}

	public Set<Sets> getSets() {
		return sets;
	}

	public void setSets(Set<Sets> sets) {
		this.sets = sets;
	}

	public TrainingPlan getTrainingPlan() {
		return trainingPlan;
	}

	public void setTrainingPlan(TrainingPlan trainingPlan) {
		this.trainingPlan = trainingPlan;
	}
    
}
