package com.app.rwm.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.rwm.enums.COOPER_RESULT;
import com.app.rwm.enums.INJURY_CATEGORY;
import com.app.rwm.enums.PHYSICAL_FITNESS;
import com.app.rwm.model.CooperTable;
import com.app.rwm.model.Injury;
import com.app.rwm.model.RunnerData;
import com.app.rwm.model.User;
import com.app.rwm.repository.CooperTableRepository;
import com.app.rwm.repository.InjuryRepository;
import com.app.rwm.repository.RunnerDataRepository;

@Service
public class RunnerDataService {
	
	private final RunnerDataRepository runnerDataRepository;
	private final UserService userService;
	private final CooperTableRepository cooperTableRepository;
	private final InjuryRepository injuryRepository;
	
	private static final Logger log = LoggerFactory.getLogger(InjuryService.class);
	@Autowired
	private KieSession kieSession;

	@Autowired
	public RunnerDataService(RunnerDataRepository runnerDataRepository, UserService userService, CooperTableRepository cooperTableRepository,InjuryRepository injuryRepository) {
		this.runnerDataRepository = runnerDataRepository;
		this.userService = userService;
		this.cooperTableRepository = cooperTableRepository;
		this.injuryRepository = injuryRepository;
		this.kieSession = kieSession;
	}

	public RunnerData findById(Long id) {
		return runnerDataRepository.findById(id).orElseThrow(null);
	}
	
	public RunnerData addRunnerData(RunnerData runnerData, String username) {
		runnerData.setId((long) 1);
		runnerData.setDistance(-1);
		runnerData.setPlannerTaken(false);
		runnerData.setPhysicalFitness(PHYSICAL_FITNESS.NA);
		runnerData.setCooperResult(COOPER_RESULT.NA);
		runnerData.setInjury(null);
		runnerData.setInjuryCategory(INJURY_CATEGORY.NA);
		
		RunnerData userRunnerData = runnerDataRepository.save(runnerData);
		
		userService.updateRunnerData(userRunnerData, username);

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

		kieSession.fireAllRules();
		runnerDataRepository.save(runnerData);

		return runnerData;
	}

	private Collection<CooperTable> findAll() {
		return cooperTableRepository.findAll();
	}

	public RunnerData addInjury(Injury injury, RunnerData runnerData) {
		kieSession.getAgenda().getAgendaGroup("injury").setFocus();
		
		if(runnerData.getInjury().isEmpty()) {
			Set<Injury> injuries = new HashSet<Injury>();
			injuries.add(injury);
			runnerData.setInjury(injuries);
		}else {
			Set<Injury> injuries = runnerData.getInjury();
			injuries.add(injury);
			runnerData.setInjury(injuries);
		}
		Collection<Injury> injuries = injuryRepository.findAll();

		kieSession.setGlobal("injuries", injuries);
		kieSession.insert(injury);
		kieSession.insert(runnerData);
		kieSession.fireAllRules();
//		kieSession.dispose();
		runnerDataRepository.save(runnerData);
		return runnerData;
	}

	
}
