package com.app.rwm.service;

import java.util.Date;

import org.kie.api.runtime.KieContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.rwm.enums.TIME_GOAL;
import com.app.rwm.model.TrainingPlan;
import com.app.rwm.repository.TrainingPlanRepository;

@Service
public class TrainingPlanService {

	private final TrainingPlanRepository trainingPlanRepository;
//	private final KieContainer kieContainer;
	
	@Autowired
	public TrainingPlanService(TrainingPlanRepository trainingPlanRepository
//			, KieContainer kieContainer
			) {
		this.trainingPlanRepository = trainingPlanRepository;
//		 this.kieContainer = kieContainer;
	}

	public TrainingPlan addRaceData(Date raceDate, String raceLocation, TIME_GOAL timeGoal) {
		TrainingPlan trainingPlan = trainingPlanRepository.save(new TrainingPlan(raceDate, raceLocation, timeGoal));
		return trainingPlan;
	}
	
}
