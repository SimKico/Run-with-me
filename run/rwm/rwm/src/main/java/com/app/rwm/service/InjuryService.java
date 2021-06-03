package com.app.rwm.service;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.rwm.model.Injury;
import com.app.rwm.model.RunnerData;
import com.app.rwm.repository.InjuryRepository;
import com.app.rwm.repository.RunnerDataRepository;

@Service
public class InjuryService {

	
	
//	
//	private final InjuryRepository injuryRepository;
//	private final UserService userService;
//    private final KieContainer kieContainer;
//	
//	@Autowired
//	public InjuryService(InjuryRepository injuryRepository, UserService userService,  KieContainer kieContainer) {
//		this.injuryRepository = injuryRepository;
//		this.userService = userService;
//		this.kieContainer = kieContainer;
//	}
//	
//	public Injury addInjury(Injury injury) {
//		KieSession kieSession = kieContainer.newKieSession("test-session");
//		kieSession.getAgenda().getAgendaGroup("test").setFocus();
//		System.out.println("Checking" + kieSession);
//		kieSession.insert(injury);
//		System.out.println("Checking");
//		kieSession.fireAllRules();
//		System.out.println("Rules");
//		kieSession.dispose();
//		
//		injury = injuryRepository.save(injury);
//		return injury;
//	}

	private static final Logger log = LoggerFactory.getLogger(InjuryService.class);
	private final InjuryRepository injuryRepository;
	private final RunnerDataService runnerDataService;
	
	@Autowired
	private KieSession kieSession;

	@Autowired
	public InjuryService(KieSession kieSession, InjuryRepository injuryRepository, RunnerDataService runnerDataService) {
		System.out.println("Checking");
		this.injuryRepository = injuryRepository;
		this.runnerDataService = runnerDataService;
		this.kieSession = kieSession;
	}

	public RunnerData addInjury(Injury injury, RunnerData runnerData) {
//		injuryRepository.save(injury);
		return runnerDataService.addInjury(injury, runnerData);
	}
}
