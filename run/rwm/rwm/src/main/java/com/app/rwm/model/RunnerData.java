package com.app.rwm.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.app.rwm.enums.GENDER;
import com.app.rwm.enums.PHYSICAL_FITNESS;
import com.app.rwm.enums.TIME_GOAL;

@Entity
public class RunnerData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	private int years;
	private double height;
    private double weight;
    private GENDER gender;
    private int distance; //for COOPER
    
    private boolean plannerTaken;
    
	private PHYSICAL_FITNESS physicalFitness;

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Injury> injury;

	public RunnerData() {
		super();
	}

	public RunnerData(Long id, int years, double height, double weight, GENDER gender, PHYSICAL_FITNESS physicalFitness,
			List<Injury> injury, boolean plannerTaken, int distance) {
		super();
		this.id = id;
		this.years = years;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
		this.physicalFitness = physicalFitness;
		this.injury = injury;
		this.plannerTaken = plannerTaken;
		this.distance = distance;
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

	public List<Injury> getInjury() {
		return injury;
	}

	public void setInjury(List<Injury> injury) {
		this.injury = injury;
	}

	public boolean isPlannerTaken() {
		return plannerTaken;
	}

	public void setPlannerTaken(boolean plannerTaken) {
		this.plannerTaken = plannerTaken;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
}
