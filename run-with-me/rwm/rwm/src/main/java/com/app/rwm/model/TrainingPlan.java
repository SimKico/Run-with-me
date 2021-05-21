package com.app.rwm.model;

import java.util.Date;
import java.util.List;

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
    
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "intervals_training_id", referencedColumnName = "id")
    private List<IntervalTraining> intervals;
	 
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "strenght_training_id", referencedColumnName = "id")
    private List<StrenghtTraining> strenghtTraining;
	 
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "distance_training_id", referencedColumnName = "id") 
    private List<DistanceTraining> distanceTraining;
    
}
