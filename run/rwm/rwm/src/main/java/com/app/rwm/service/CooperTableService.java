package com.app.rwm.service;

import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.rwm.repository.CooperTableRepository;
import com.app.rwm.repository.RunnerDataRepository;

@Service
public class CooperTableService {

	private final RunnerDataRepository runnerDataRepository;
	private final UserService userService;
	private final CooperTableRepository cooperTableRepository;
	
	private static final Logger log = LoggerFactory.getLogger(InjuryService.class);
	@Autowired
	private KieSession kieSession;

	@Autowired
	public CooperTableService(RunnerDataRepository runnerDataRepository, UserService userService, CooperTableRepository cooperTableRepository) {
		this.runnerDataRepository = runnerDataRepository;
		this.userService = userService;
		this.cooperTableRepository = cooperTableRepository;
		this.kieSession = kieSession;
	}
	
	
}
