package com.app.rwm.service;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.rwm.model.Injury;

import org.springframework.stereotype.Service;

@Service
public class InjuryService {

	private static final Logger log = LoggerFactory.getLogger(InjuryService.class);
	
	@Autowired
	private KieContainer kieContainer;

	@Autowired
	public InjuryService(KieContainer kieContainer) {
		System.out.println("Checking");
		log.info("Initialising a new example session.");
		this.kieContainer = kieContainer;
	}
	public Injury isCanceledPreparation(Injury injury) {
		System.out.println("Checking");
		KieSession kieSession = kieContainer.newKieSession("test-session");
		System.out.println("Checking" + kieSession);
		kieSession.insert(injury);
		System.out.println("Checking");
		kieSession.fireAllRules();
		System.out.println("Rules");
		kieSession.dispose();
		return injury;
		
	}
}
