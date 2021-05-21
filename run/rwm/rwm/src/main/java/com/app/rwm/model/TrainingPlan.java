package com.app.rwm.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.app.rwm.enums.INTENSITY;
import com.app.rwm.enums.LEVEL;
import com.app.rwm.enums.MUSCLES_GROUP;
import com.app.rwm.enums.PREPARATION_TIME;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TrainingPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	private Date raceDate;
	private String raceLocation;
	
	private boolean canceledPreparation;

    private INTENSITY intensityLevel;
    private LEVEL level;
	private PREPARATION_TIME preparationTime;
    
    @OneToMany(mappedBy = "trainingPlan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<IntervalTraining> intervalTraining = new HashSet<IntervalTraining>();
	 
    @OneToMany(mappedBy = "trainingPlan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<StrenghtTraining> strenghtTraining = new HashSet<StrenghtTraining>();

    @OneToMany(mappedBy = "trainingPlan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<DistanceTraining> distanceTraining = new HashSet<DistanceTraining>();

    
}
