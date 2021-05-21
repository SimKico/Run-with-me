package com.app.rwm.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.app.rwm.enums.INJURY_TYPE;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Injury {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	 private RunnerData runnerData;
	 
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
	 
	 
	 
}
