package com.app.rwm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.rwm.dto.BasicRunnerDataDTO;
import com.app.rwm.dto.RunnerDataDTO;
import com.app.rwm.mappers.BasicRunnerDataMapper;
import com.app.rwm.mappers.RunnerDataMapper;
import com.app.rwm.model.RunnerData;
import com.app.rwm.model.User;
import com.app.rwm.service.RunnerDataService;
import com.app.rwm.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("rwm/runner")
public class RunnerDataController {
	
	private final RunnerDataService runnerDataService;
	private final UserService userService;
	
	
	@Autowired
	public RunnerDataController(RunnerDataService runnerDataService, UserService userService) {
		this.runnerDataService = runnerDataService;
		this.userService = userService;
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> addRunnerData(@RequestBody BasicRunnerDataDTO basicRunnerDataDTO){
//		User user = userService.findOneByUsername("user1");
		System.out.println("basicRunnerData" + basicRunnerDataDTO.getGender());

		System.out.println("basicRunnerData" +(basicRunnerDataDTO.getGender()).getClass());
		RunnerData runnerData = runnerDataService.addRunnerData(BasicRunnerDataMapper.toRunnerData(basicRunnerDataDTO), "user1");
		System.out.println("basicRunnerData" + runnerData);
		 return new ResponseEntity<>(runnerData.getId(), HttpStatus.OK);
	}
	
	@PostMapping(path = "/cooper", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> addCooper(@RequestBody int distance){
		User user = userService.findOneByUsername("user1");
		runnerDataService.calculateRunnerFitness(distance, user);
		 return new ResponseEntity<>(user.getId(), HttpStatus.OK);
	}
	
	
}