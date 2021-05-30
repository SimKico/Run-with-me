package com.app.rwm.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.app.rwm.enums.RUNNING_SPEED;

@Entity
public class Sets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	private int time;
	private RUNNING_SPEED speed;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private IntervalTraining intervalTraining;

	public Sets() {
		super();
	}

	public Sets(Long id, int time, RUNNING_SPEED speed, IntervalTraining intervalTraining) {
		super();
		this.id = id;
		this.time = time;
		this.speed = speed;
		this.intervalTraining = intervalTraining;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public RUNNING_SPEED getSpeed() {
		return speed;
	}

	public void setSpeed(RUNNING_SPEED speed) {
		this.speed = speed;
	}

	public IntervalTraining getIntervalTraining() {
		return intervalTraining;
	}

	public void setIntervalTraining(IntervalTraining intervalTraining) {
		this.intervalTraining = intervalTraining;
	}

}
