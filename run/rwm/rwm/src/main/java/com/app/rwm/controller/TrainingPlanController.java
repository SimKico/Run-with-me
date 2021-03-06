package com.app.rwm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.rwm.dto.RaceDataDTO;
import com.app.rwm.model.TrainingPlan;
import com.app.rwm.model.User;
import com.app.rwm.service.TrainingPlanService;
import com.app.rwm.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("rwm/race")
public class TrainingPlanController {

	private final TrainingPlanService trainingPlanService;
	private final UserService userService;
	
	@Autowired
	public TrainingPlanController( TrainingPlanService trainingPlanService, UserService userService) {
		this.trainingPlanService = trainingPlanService;
		this.userService = userService;
	}
	
	
	@PostMapping(path = "/data", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addRaceData(@RequestBody RaceDataDTO raceDataDTO){
		System.out.println("raceDataDTO" + raceDataDTO);
		User user = userService.findOneByUsername(raceDataDTO.getUsername());
//		if(!trainingPlanService.isAlreadyPreparationOn(raceDataDTO)) {
			TrainingPlan trainingPlan = trainingPlanService.addRaceData(raceDataDTO.getRaceDate(), raceDataDTO.getRaceLocation(), raceDataDTO.getTimeGoal(), user);
			if(trainingPlan.isCanceledPreparation()) {
				System.out.println("isCanceledPreparation JES");
				return new ResponseEntity<>("There is no enough time to prepare for that race!", HttpStatus.NOT_ACCEPTABLE);
			}else {
				System.out.println("isCanceledPreparation NO");
				return new ResponseEntity<>(trainingPlan.getTrainingName(), HttpStatus.OK);
			}
//		}else {
//			System.out.println("isCanceledPreparation NO");
//			return new ResponseEntity<>("There is already an active preparation process for a half marathon!", HttpStatus.NOT_ACCEPTABLE);
//		}

	}
	
}
