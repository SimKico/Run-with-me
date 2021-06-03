package com.app.rwm.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.app.rwm.enums.GENDER;

@Entity
public class CooperTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private GENDER gender;
	
	private int ageMin; // 17
	private int ageMax; //19

	private int veryBad; // <2100 m

	private int bad; // 2199

	private int average; // 2200

	private int good; // 2700 m

	public CooperTable() {
		super();
	}

	public CooperTable(Long id, GENDER gender, int ageMin,int ageMax, int veryBad, int bad, int average, int good) {
		super();
		this.id = id;
		this.gender = gender;
		this.ageMin = ageMin;
		this.ageMax = ageMax;
		this.veryBad = veryBad;
		this.bad = bad;
		this.average = average;
		this.good = good;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public GENDER getGender() {
		return gender;
	}

	public void setGender(GENDER gender) {
		this.gender = gender;
	}

	public int getAgeMin() {
		return ageMin;
	}

	public void setAgeMin(int age) {
		this.ageMin = age;
	}

	public int getVeryBad() {
		return veryBad;
	}

	public void setVeryBad(int veryBad) {
		this.veryBad = veryBad;
	}

	public int getBad() {
		return bad;
	}

	public void setBad(int bad) {
		this.bad = bad;
	}

	public int getAverage() {
		return average;
	}

	public void setAverage(int average) {
		this.average = average;
	}

	public int getGood() {
		return good;
	}

	public void setGood(int good) {
		this.good = good;
	}

	public int getAgeMax() {
		return ageMax;
	}

	public void setAgeMax(int ageMax) {
		this.ageMax = ageMax;
	}
}
