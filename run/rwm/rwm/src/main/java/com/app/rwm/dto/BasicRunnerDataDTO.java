package com.app.rwm.dto;

import com.app.rwm.enums.GENDER;

public class BasicRunnerDataDTO {
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
  
  
  
}
