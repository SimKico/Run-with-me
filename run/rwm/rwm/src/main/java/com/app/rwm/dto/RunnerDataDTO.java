package com.app.rwm.dto;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.app.rwm.enums.COOPER_RESULT;
import com.app.rwm.enums.GENDER;
import com.app.rwm.enums.PHYSICAL_FITNESS;
import com.app.rwm.enums.TIME_GOAL;

public class RunnerDataDTO {
	private Long id;

//    @NotNull(message = "Years can not be null")
//    @Min(value = 0, message = "Years min is {value}")
    private int years;

//    @NotNull(message = "Height can not be null")
//    @Min(value = 0, message = "Height min is {value}")
    private double height;

//    @NotNull(message = "Weight can not be null")
//    @Min(value = 0, message = "Weight min is {value}")
    private double weight;
    private int distance;
    
    private GENDER gender;
    
	private PHYSICAL_FITNESS physicalFitness;
	
	private COOPER_RESULT cooperResult;
	
	private Collection<InjuryDTO> injuryDTO;

	public RunnerDataDTO() {
		super();
	}

	public RunnerDataDTO(Long id, int years, double height, double weight, GENDER gender,
			PHYSICAL_FITNESS physicalFitness, Collection<InjuryDTO> injuryDTO, int distance, COOPER_RESULT cooperResult) {
		super();
		this.id = id;
		this.years = years;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
		this.physicalFitness = physicalFitness;
		this.injuryDTO = injuryDTO;
		this.distance = distance;
		this.cooperResult = cooperResult;
	}

	public COOPER_RESULT getCooperResult() {
		return cooperResult;
	}

	public void setCooperResult(COOPER_RESULT cooperResult) {
		this.cooperResult = cooperResult;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public PHYSICAL_FITNESS getPhysicalFitness() {
		return physicalFitness;
	}

	public void setPhysicalFitness(PHYSICAL_FITNESS physicalFitness) {
		this.physicalFitness = physicalFitness;
	}

	public Collection<InjuryDTO> getInjuryDTO() {
		return injuryDTO;
	}

	public void setInjuryDTO(Collection<InjuryDTO> injuryDTO) {
		this.injuryDTO = injuryDTO;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

 
	
}
