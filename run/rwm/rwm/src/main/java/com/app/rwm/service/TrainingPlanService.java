package com.app.rwm.service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.rwm.enums.TIME_GOAL;
import com.app.rwm.model.TrainingPlan;
import com.app.rwm.model.User;
import com.app.rwm.repository.TrainingPlanRepository;

@Service
public class TrainingPlanService {

	private final TrainingPlanRepository trainingPlanRepository;
	private final UserService userService;
	
	@Autowired
	private KieSession kieSession;
	
	@Autowired
	public TrainingPlanService(TrainingPlanRepository trainingPlanRepository, UserService userService) {
		this.trainingPlanRepository = trainingPlanRepository;
		this.userService = userService;
		this.kieSession = kieSession;
	}

	public TrainingPlan addRaceData(Instant raceDate, String raceLocation, TIME_GOAL timeGoal, User user) {
		TrainingPlan trainingPlan = trainingPlanRepository.save(new TrainingPlan(raceDate, raceLocation, timeGoal));
		userService.updateTrainingPlan(trainingPlan, user);
		kieSession.getAgenda().getAgendaGroup("time").setFocus();
//		LocalDate now = LocalDate.now();
//		System.out.println("now" + now);
//		kieSession.setGlobal("nowTime", now);
		kieSession.insert(trainingPlan);
		kieSession.fireAllRules();
		trainingPlanRepository.save(trainingPlan);
		return trainingPlan;
	}
	
}
