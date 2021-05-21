package com.app.rwm.model;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class IntervalTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date trainingDay;
    
    @OneToMany(mappedBy = "intervalTraining", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   	private Set<Sets> sets = new HashSet<Sets>();
     
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private TrainingPlan trainingPlan;
}
