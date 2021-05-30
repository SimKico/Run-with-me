package com.app.rwm.dto;

import java.util.Date;

import com.app.rwm.enums.INJURY_TYPE;

public class InjuryDTO {

	private Date dateOfInjury;
	private INJURY_TYPE injuryType;
	 
	public InjuryDTO() {
		super();
	}

	public InjuryDTO(Date dateOfInjury, INJURY_TYPE injuryType) {
		super();
		this.dateOfInjury = dateOfInjury;
		this.injuryType = injuryType;
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
	 
	  
}
