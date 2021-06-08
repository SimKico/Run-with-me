package com.app.rwm;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.EntryPoint;

import com.app.rwm.enums.COOPER_RESULT;
import com.app.rwm.enums.GENDER;
import com.app.rwm.enums.INJURY_CATEGORY;
import com.app.rwm.enums.INJURY_TYPE;
import com.app.rwm.enums.INTENSITY;
import com.app.rwm.enums.PHYSICAL_FITNESS;
import com.app.rwm.enums.TIME_GOAL;
import com.app.rwm.model.CooperTable;
import com.app.rwm.model.Injury;
import com.app.rwm.model.RunnerData;
import com.app.rwm.model.TrainingPlan;

import static org.junit.Assert.assertEquals;

import java.time.Instant;
import java.util.Collection;
import java.util.Date;

public class RunnerDataTest {


	@Test
	public void runnerData() {//set physicall fitness
		 KieServices kieServices = KieServices.Factory.get();
	     KieContainer kieContainer = kieServices.getKieClasspathContainer();
	     KieSession kieSession = kieContainer.newKieSession("test-session");

		kieSession.getAgenda().getAgendaGroup("cooper").setFocus();
	     RunnerData runnerData = new RunnerData(28,170,75,GENDER.FEMALE,2000);
	     CooperTable cooper = new CooperTable((long)1, GENDER.FEMALE,  20, 30,  1500,  1800,  2200,  2700);
	     kieSession.insert(cooper);
			
	     String rCooperResult = "NA";
			kieSession.setGlobal("qDistance", 2000);
			kieSession.setGlobal("qYears", runnerData.getYears());
			kieSession.setGlobal("qGender", runnerData.getGender());
			kieSession.setGlobal("rCooperResult", rCooperResult);
			
	     kieSession.fireAllRules();
	    
	     assertEquals(COOPER_RESULT.AVERAGE, runnerData.getCooperResult());

	     assertEquals(PHYSICAL_FITNESS.GOOD, runnerData.getPhysicalFitness());
	}
	
	@Test
	public void injury() {
		 KieServices kieServices = KieServices.Factory.get();
	     KieContainer kieContainer = kieServices.getKieClasspathContainer();
	     KieSession kieSession = kieContainer.newKieSession("test-session");

	     kieSession.getAgenda().getAgendaGroup("cooper").setFocus();
	     RunnerData runnerData = new RunnerData(28,170,75,GENDER.FEMALE,2000);
	     Instant date = Instant.now();
	     Injury injury = new Injury(date, INJURY_TYPE.KNEE_PAIN,runnerData);
	     
	     kieSession.insert(injury);
	     
	     kieSession.fireAllRules();
	     
	     assertEquals(runnerData.getInjuryCategory(), INJURY_CATEGORY.MINOR_INJURY);
	}
	
	@Test
	public void injuryBrokenLeg() {
		 KieServices kieServices = KieServices.Factory.get();
	     KieContainer kieContainer = kieServices.getKieClasspathContainer();
	     KieSession kieSession = kieContainer.newKieSession("test-session");

	     kieSession.getAgenda().getAgendaGroup("cooper").setFocus();
	     RunnerData runnerData = new RunnerData(28,170,75,GENDER.FEMALE,2000);
	     Instant date = Instant.now();
	     Injury injury = new Injury(date, INJURY_TYPE.BROKEN_LEG,runnerData);
	     
	     kieSession.insert(injury);
	     kieSession.fireAllRules();
	     assertEquals(runnerData.getInjuryCategory(), INJURY_CATEGORY.SEVERE_INJURY);
	}
	
	@Test
	public void raceData() {
		 KieServices kieServices = KieServices.Factory.get();
	     KieContainer kieContainer = kieServices.getKieClasspathContainer();
	     KieSession kieSession = kieContainer.newKieSession("test-session");
	
	     kieSession.getAgenda().getAgendaGroup("time").setFocus();
	     Instant date = Instant.now();
	     TrainingPlan trainingPlan = new TrainingPlan(date, "Derventa", TIME_GOAL.BETWEEN_1h20m_AND_1h50m);
	     RunnerData runnerData = new RunnerData(28,170,75,GENDER.FEMALE,2000);
	     kieSession.insert(trainingPlan);
	     kieSession.fireAllRules();
	 
	     kieSession.getAgenda().getAgendaGroup("intensity").setFocus();
		 kieSession.insert(trainingPlan);
		 kieSession.insert(runnerData);
		 kieSession.fireAllRules();
			
		assertEquals(trainingPlan.getIntensityLevel(), INTENSITY.INTERMEDIATE);
	}

	
}
