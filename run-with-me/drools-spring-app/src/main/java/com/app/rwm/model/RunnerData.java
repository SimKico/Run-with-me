package com.app.rwm.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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

    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "injury_id", referencedColumnName = "id")
	private List<Injury> injuries;
    
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "training_plan_id", referencedColumnName = "id")
    private TrainingPlan trainingPlan;
    
    
    
    
    
	
	
}
