package com.app.rwm.model;

import java.util.Date;

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
	 
	 public enum InjuryCategory{
		 NA, SEVERE_INJURY, MINOR_INJURY
	 }

	 private Date dateOfInjury;
	 private INJURY_TYPE injuryType;
	 private InjuryCategory injuryCategory;
	 
	 public Injury(INJURY_TYPE injuryType) {
		super();
		this.injuryType = injuryType;
	}

	public Injury() {
		super();
	}

	public Injury(Long id, RunnerData runnerData, Date dateOfInjury, INJURY_TYPE injuryType,
			InjuryCategory injuryCategory) {
		super();
		this.id = id;
		this.dateOfInjury = dateOfInjury;
		this.injuryType = injuryType;
		this.injuryCategory = injuryCategory;
	}
	

	public Injury(Long id, Date dateOfInjury, INJURY_TYPE injuryType) {
		super();
		this.id = id;
		this.dateOfInjury = dateOfInjury;
		this.injuryType = injuryType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Date getDateOfInjury() {
		return dateOfInjury;
	}

	public void setDateOfInjury(Date dateOfInjury) {
		this.dateOfInjury = dateOfInjury;
	}

	public INJURY_TYPE getInjuryType() {
		return injuryType;
	}

	public void setInjuryType(INJURY_TYPE injuryType) {
		this.injuryType = injuryType;
	}

	public InjuryCategory getInjuryCategory() {
		return injuryCategory;
	}

	public void setInjuryCategory(InjuryCategory injuryCategory) {
		this.injuryCategory = injuryCategory;
	}
}
