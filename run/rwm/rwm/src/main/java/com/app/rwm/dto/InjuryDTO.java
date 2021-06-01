package com.app.rwm.dto;

import java.util.Date;

import com.app.rwm.enums.INJURY_TYPE;

public class InjuryDTO {

	private Date dateOfInjury;
	private INJURY_TYPE injuryType;
	private int runnerData;
	 
	public InjuryDTO() {
		super();
	}

	public InjuryDTO(Date dateOfInjury, INJURY_TYPE injuryType, int runnerData) {
		super();
		this.dateOfInjury = dateOfInjury;
		this.injuryType = injuryType;
		this.setRunnerData(runnerData);
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

	public int getRunnerData() {
		return runnerData;
	}

	public void setRunnerData(int runnerData) {
		this.runnerData = runnerData;
	}
	 
	  
}
