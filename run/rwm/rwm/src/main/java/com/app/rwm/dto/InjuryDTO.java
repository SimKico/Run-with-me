package com.app.rwm.dto;


import java.time.Instant;
import com.app.rwm.enums.INJURY_TYPE;

public class InjuryDTO {

	private Instant dateOfInjury;
	private INJURY_TYPE injuryType;
	 
	public InjuryDTO() {
		super();
	}

	public InjuryDTO(Instant dateOfInjury, INJURY_TYPE injuryType) {
		super();
		this.dateOfInjury = dateOfInjury;
		this.injuryType = injuryType;
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
