package com.app.rwm.model;

import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.app.rwm.enums.INJURY_TYPE;

@Entity
public class Injury {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	 private Instant dateOfInjury;
	 private INJURY_TYPE injuryType;
	 
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private RunnerData runnerData;
	 
	 public Injury(INJURY_TYPE injuryType) {
		super();
		this.injuryType = injuryType;
	}

	public Injury() {
		super();
	}

	public Injury(Long id, Instant dateOfInjury, INJURY_TYPE injuryType) {
		super();
		this.id = id;
		this.dateOfInjury = dateOfInjury;
		this.injuryType = injuryType;
	}
	

	public Injury( Instant dateOfInjury, INJURY_TYPE injuryType,
			RunnerData runnerData) {
		super();
		this.dateOfInjury = dateOfInjury;
		this.injuryType = injuryType;

		this.runnerData = runnerData;
	}
	

	public RunnerData getRunnerData() {
		return runnerData;
	}

	public void setRunnerData(RunnerData runnerData) {
		this.runnerData = runnerData;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Instant getDateOfInjury() {
		return dateOfInjury;
	}

	public void setDateOfInjury(Instant dateOfInjury) {
		this.dateOfInjury = dateOfInjury;
	}

	public INJURY_TYPE getInjuryType() {
		return injuryType;
	}

	public void setInjuryType(INJURY_TYPE injuryType) {
		this.injuryType = injuryType;
	}

}
