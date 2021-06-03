package com.app.rwm.service;

import java.util.ArrayList;
import java.util.Collection;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.rwm.enums.COOPER_RESULT;
import com.app.rwm.enums.PHYSICAL_FITNESS;
import com.app.rwm.model.CooperTable;
import com.app.rwm.model.RunnerData;
import com.app.rwm.model.User;
import com.app.rwm.repository.CooperTableRepository;
import com.app.rwm.repository.RunnerDataRepository;

@Service
public class RunnerDataService {
	
	private final RunnerDataRepository runnerDataRepository;
	private final UserService userService;
	private final CooperTableRepository cooperTableRepository;
	
	private static final Logger log = LoggerFactory.getLogger(InjuryService.class);
	@Autowired
	private KieSession kieSession;

	@Autowired
	public RunnerDataService(RunnerDataRepository runnerDataRepository, UserService userService, CooperTableRepository cooperTableRepository) {
		this.runnerDataRepository = runnerDataRepository;
		this.userService = userService;
		this.cooperTableRepository = cooperTableRepository;
		this.kieSession = kieSession;
	}

	public RunnerData findById(Long id) {
		return runnerDataRepository.findById(id).orElseThrow(null);
	}
	
	public RunnerData addRunnerData(RunnerData runnerData, String username) {
		runnerData.setId((long) 1);
		System.out.println("addRunnerData1");
		runnerData.setDistance(-1);
		runnerData.setPlannerTaken(false);
		runnerData.setPhysicalFitness(PHYSICAL_FITNESS.NA);
		runnerData.setCooperResult(COOPER_RESULT.NA);
		runnerData.setInjury(null);
		System.out.println("addRunnerData2sfs");
		System.out.println("addRunnerData :"  + runnerData.getYears() + runnerData.getGender() + runnerData.getId());
		RunnerData userRunnerData = runnerDataRepository.save(runnerData);
		System.out.println("addRunnerData3 + username" + runnerData + username);
		userService.updateRunnerData(userRunnerData, username);
		System.out.println("addRunnerData4");
		
		return userRunnerData;
	}

	public RunnerData calculateRunnerFitness(int distance, User user) {
		RunnerData runnerData = user.getRunnerData();
		runnerData.setDistance(distance);
		runnerDataRepository.save(runnerData);

		kieSession.getAgenda().getAgendaGroup("cooper").setFocus();
		
		Collection<CooperTable> cooperTable = findAll();
		kieSession.insert(runnerData);
		for(CooperTable cooper : cooperTable) {
			kieSession.insert(cooper);
		}
		String rCooperResult = "NA";
		kieSession.setGlobal("qDistance", distance);
		kieSession.setGlobal("qYears", runnerData.getYears());
		kieSession.setGlobal("qGender", runnerData.getGender());
		kieSession.setGlobal("rCooperResult", rCooperResult);
//		kieSession.insert(runnerData);
		kieSession.fireAllRules();
//		rCooperResult = (String) kieSession.getGlobal("rCooperResult");
//		System.out.println("rCooperResult" + rCooperResult);
		runnerDataRepository.save(runnerData);

		System.out.println("after save physical fitness" + runnerData.getPhysicalFitness());

		System.out.println("after save cooper" + runnerData.getCooperResult());
//		kieSession.dispose();
		return runnerData;
	}

	private Collection<CooperTable> findAll() {
		return cooperTableRepository.findAll();
	}

	
}
