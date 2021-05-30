package com.app.rwm.services;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import com.app.rwm.repository.RacePlannerRepository;

@Service
public class RacePlannerService {
//	private static Logger log = LoggerFactory.getLogger(RacePlannerService.class);
	
//	private final RacePlannerRepository racePlannerRepository;
	private final KieContainer kieContainer;
	
	@Autowired
	public RacePlannerService(
//			RacePlannerRepository racePlannerRepository,
			KieContainer kieContainer) {
//		this.racePlannerRepository = racePlannerRepository;
		this.kieContainer = kieContainer;
	}
	
	public String testPlanner(String test) {
		KieSession kieSession = kieContainer.newKieSession("test-session");
		kieSession.insert(test);
		kieSession.fireAllRules();
		kieSession.dispose();
		return "test testPlanner(String test)";
	}
	
}
