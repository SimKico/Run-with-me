package com.app.rwm.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.app.rwm.enums.GENDER;
import com.app.rwm.enums.PHYSICAL_FITNESS;
import com.app.rwm.enums.PREPARATION_TIME;
import com.app.rwm.enums.TIME_GOAL;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RunnerData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	private int years;
	private double height;
    private double weight;
    private GENDER gender;
    
	private PHYSICAL_FITNESS physicalFitness;
	private TIME_GOAL timeGoal;

//	@OneToOne
//	@MapsId
//	private User user;
	
//    @OneToMany(mappedBy = "runnerData", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private Set<Injury> injury = new HashSet<Injury>();
//    
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private TrainingPlan trainingPlan;
    
}
