package com.app.rwm.dto;

import java.util.Collection;

import com.app.rwm.enums.GENDER;

public class BasicRunnerDataDTO {

  private String username;	
//  @NotNull(message = "Years can not be null")
//  @Min(value = 0, message = "Years min is {value}")
  private int years;

//  @NotNull(message = "Height can not be null")
//  @Min(value = 0, message = "Height min is {value}")
  private double height;

//  @NotNull(message = "Weight can not be null")
//  @Min(value = 0, message = "Weight min is {value}")
  private double weight;
  
  private GENDER gender;
  
  private Collection<InjuryDTO> injuries;

	public BasicRunnerDataDTO() {
		super();
	}

public BasicRunnerDataDTO(int years, double height, double weight, GENDER gender) {
	super();
	this.years = years;
	this.height = height;
	this.weight = weight;
	this.gender = gender;
}


public BasicRunnerDataDTO(int years, double height, double weight, GENDER gender, Collection<InjuryDTO> injuries) {
	super();
	this.years = years;
	this.height = height;
	this.weight = weight;
	this.gender = gender;
	this.injuries = injuries;
}



public BasicRunnerDataDTO(String username, int years, double height, double weight, GENDER gender,
		Collection<InjuryDTO> injuries) {
	super();
	this.username = username;
	this.years = years;
	this.height = height;
	this.weight = weight;
	this.gender = gender;
	this.injuries = injuries;
}

public Collection<InjuryDTO> getInjuries() {
	return injuries;
}

public void setInjuries(Collection<InjuryDTO> injuries) {
	this.injuries = injuries;
}

public int getYears() {
	return years;
}

public void setYears(int years) {
	this.years = years;
}

public double getHeight() {
	return height;
}

public void setHeight(double height) {
	this.height = height;
}

public double getWeight() {
	return weight;
}

public void setWeight(double weight) {
	this.weight = weight;
}

public GENDER getGender() {
	return gender;
}

public void setGender(GENDER gender) {
	this.gender = gender;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}
  
  
  
}
