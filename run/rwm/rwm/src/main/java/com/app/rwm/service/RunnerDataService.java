//package com.app.rwm.service;
//
//import org.kie.api.runtime.KieContainer;
//import org.kie.api.runtime.KieSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.app.rwm.model.RunnerData;
//import com.app.rwm.model.User;
//import com.app.rwm.repository.RunnerDataRepository;
//
//@Service
//public class RunnerDataService {
//	
//	private final RunnerDataRepository runnerDataRepository;
//	private final UserService userService;
//    private final KieContainer kieContainer;
//	
//	@Autowired
//	public RunnerDataService(RunnerDataRepository runnerDataRepository, UserService userService,  KieContainer kieContainer) {
//		this.runnerDataRepository = runnerDataRepository;
//		this.userService = userService;
//		this.kieContainer = kieContainer;
//	}
//
//	public RunnerData findById(Long id) {
//		return runnerDataRepository.findById(id).orElseThrow(null);
//	}
//	
//	public RunnerData addRunnerData(RunnerData runnerData, String username) {
//		runnerData.setId(null);
//		runnerData.setPlannerTaken(false);
//		RunnerData userRunnerData = runnerDataRepository.save(runnerData);
//		userService.updateRunnerData(userRunnerData, username);
//		
//		return userRunnerData;
//	}
//
//	public void calculateRunnerFitness(int distance, User user) {
//		RunnerData runnerData = findById(user.getRunnerData().getId());
//		KieSession kieSession = kieContainer.newKieSession("test-session");
//		kieSession.getAgenda().getAgendaGroup("cooper").setFocus();
//		kieSession.insert(runnerData);
//		kieSession.insert(distance);
//		
//		kieSession.fireAllRules();
//		kieSession.dispose();
//	}
//
//	
//}
