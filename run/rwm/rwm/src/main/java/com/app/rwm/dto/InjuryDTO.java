package com.app.rwm.dto;


import java.time.Instant;
import com.app.rwm.enums.INJURY_TYPE;

public class InjuryDTO {
	private String username;
	
	private Instant dateOfInjury;
	private INJURY_TYPE injuryType;
	 
	public InjuryDTO() {
		super();
	}

	public InjuryDTO(String username, Instant dateOfInjury, INJURY_TYPE injuryType) {
		super();
		this.username = username;
		this.dateOfInjury = dateOfInjury;
		this.injuryType = injuryType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
