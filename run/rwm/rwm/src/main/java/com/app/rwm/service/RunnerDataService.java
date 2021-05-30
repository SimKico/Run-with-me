package com.app.rwm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.rwm.model.RunnerData;
import com.app.rwm.repository.RunnerDataRepository;

@Service
public class RunnerDataService {
	
	private final RunnerDataRepository runnerDataRepository;
	private final UserService userService;
	
	@Autowired
	public RunnerDataService(RunnerDataRepository runnerDataRepository, UserService userService) {
		this.runnerDataRepository = runnerDataRepository;
		this.userService = userService;
	}

	public RunnerData addRunnerData(RunnerData runnerData, String username) {
		runnerData.setId(null);
		runnerData.setPlannerTaken(false);
		RunnerData userRunnerData = runnerDataRepository.save(runnerData);
		userService.updateRunnerData(userRunnerData, username);
		
		return userRunnerData;
	}

	
}
