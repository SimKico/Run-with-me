package com.app.rwm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.rwm.enums.COOPER_RESULT;
import com.app.rwm.enums.GENDER;
import com.app.rwm.enums.INJURY_CATEGORY;
import com.app.rwm.enums.INJURY_TYPE;
import com.app.rwm.enums.INTENSITY;
import com.app.rwm.enums.PHYSICAL_FITNESS;
import com.app.rwm.enums.PREPARATION_TIME;
import com.app.rwm.enums.TIME_GOAL;
import com.app.rwm.enums.USER_ROLE;
import com.app.rwm.model.CooperTable;
import com.app.rwm.model.Injury;
import com.app.rwm.model.RunnerData;
import com.app.rwm.model.TrainingPlan;
import com.app.rwm.model.User;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;

@RunWith(SpringRunner.class)
public class RunnerDataTest {

	 private static KieContainer kieContainer;
	 
	@Before 
	public void setup() {
		 KieServices kieServices = KieServices.Factory.get();
	        kieContainer = kieServices
	                .newKieContainer(kieServices.newReleaseId("com.app.rwm", "rwm-kjar", "1.0.0-SNAPSHOT"));
	}

	@Test
	public void runnerData() {//set physicall fitness
	     KieSession kieSession = kieContainer.newKieSession("test-session");
		 kieSession.getAgenda().getAgendaGroup("cooper").setFocus();
		 
	     RunnerData runnerData = new RunnerData(27,170,75,GENDER.FEMALE,2000);
	     
	     Long id = (long) 1;
	 	 User user = new User(id, "Snjezana", "Simic", "user1@gmail.com", true, "user1", "fasdf",
				USER_ROLE.ROLE_RUNNER, null, runnerData);
	 	 
	     CooperTable cooper = new CooperTable((long)1, GENDER.FEMALE,  20, 30,  1500,  1800,  2200,  2700);
	     kieSession.insert(runnerData);
	     kieSession.insert(cooper);
			
	     String rCooperResult = "NA";
			kieSession.setGlobal("qDistance", 2000);
			kieSession.setGlobal("qYears", 25);
			kieSession.setGlobal("qGender", GENDER.FEMALE);
			kieSession.setGlobal("rCooperResult", rCooperResult);
			
	     kieSession.fireAllRules();
	    
	     assertEquals(COOPER_RESULT.AVERAGE, runnerData.getCooperResult());

	     assertEquals(PHYSICAL_FITNESS.GOOD, runnerData.getPhysicalFitness());
	}
	
	@Test
	public void runnerData_Bad() {//set physicall fitness
	     KieSession kieSession = kieContainer.newKieSession("test-session");
		 kieSession.getAgenda().getAgendaGroup("cooper").setFocus();
		 
	     RunnerData runnerData = new RunnerData(27,170,75,GENDER.FEMALE,1500);
	     
	     Long id = (long) 1;
	 	 User user = new User(id, "Snjezana", "Simic", "user1@gmail.com", true, "user1", "fasdf",
				USER_ROLE.ROLE_RUNNER, null, runnerData);
	 	 
	     CooperTable cooper = new CooperTable((long)1, GENDER.FEMALE,  20, 30,  1500,  1800,  2200,  2700);
	     kieSession.insert(runnerData);
	     kieSession.insert(cooper);
			
	     String rCooperResult = "NA";
			kieSession.setGlobal("qDistance", 1500);
			kieSession.setGlobal("qYears", 25);
			kieSession.setGlobal("qGender", GENDER.FEMALE);
			kieSession.setGlobal("rCooperResult", rCooperResult);
			
	     kieSession.fireAllRules();
	    
	     assertEquals(COOPER_RESULT.VERY_BAD, runnerData.getCooperResult());

	     assertEquals(PHYSICAL_FITNESS.BAD, runnerData.getPhysicalFitness());
	}
	
	@Test
	public void runnerData_EXCELLENT() {//set physicall fitness
	     KieSession kieSession = kieContainer.newKieSession("test-session");
		 kieSession.getAgenda().getAgendaGroup("cooper").setFocus();
		 
	     RunnerData runnerData = new RunnerData(27,170,75,GENDER.FEMALE,3000);
	     
	     Long id = (long) 1;
	 	 User user = new User(id, "Snjezana", "Simic", "user1@gmail.com", true, "user1", "fasdf",
				USER_ROLE.ROLE_RUNNER, null, runnerData);
	 	 
	     CooperTable cooper = new CooperTable((long)1, GENDER.FEMALE,  20, 30,  1500,  1800,  2200,  2700);
	     kieSession.insert(runnerData);
	     kieSession.insert(cooper);
			
	     String rCooperResult = "NA";
			kieSession.setGlobal("qDistance", 3000);
			kieSession.setGlobal("qYears", 25);
			kieSession.setGlobal("qGender", GENDER.FEMALE);
			kieSession.setGlobal("rCooperResult", rCooperResult);
			
	     kieSession.fireAllRules();
	    
	     assertEquals(COOPER_RESULT.EXCELLENT, runnerData.getCooperResult());

	     assertEquals(PHYSICAL_FITNESS.EXCELLENT, runnerData.getPhysicalFitness());
	}
	
//	@Test
//	public void injury() {
//	     KieSession kieSession = kieContainer.newKieSession("test-session");
//
//	     kieSession.getAgenda().getAgendaGroup("injury").setFocus();
//	     LocalDate date = LocalDate.parse("2021-06-15");
//	     Instant instant = date.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
//	     TrainingPlan trainingPlan = new TrainingPlan(instant, "Derventa", TIME_GOAL.BETWEEN_1h20m_AND_1h50m);
//	     RunnerData runnerData = new RunnerData(28,170,75,GENDER.FEMALE,2000);
//	     Long id = (long) 1;
//	 	 User user = new User(id, "Snjezana", "Simic", "user1@gmail.com", true, "user1", "fasdf",
//				USER_ROLE.ROLE_RUNNER, trainingPlan, runnerData);
//	 	 
//	     Instant dateInjury = Instant.now();
//	     Injury injury = new Injury(dateInjury, INJURY_TYPE.KNEE_PAIN, runnerData);
//	     Collection<Injury> injuries = new HashSet<Injury>();
//	     injuries.add(injury);
//	     Set<Injury> injuriesRunner = new HashSet<Injury>();
//	     injuriesRunner.add(injury);
//	     
//	     runnerData.setInjury(injuriesRunner);
//	     kieSession.setGlobal("injuries", injuries);
//		 kieSession.insert(injury);
//		 kieSession.insert(runnerData);
//	     
//	     kieSession.fireAllRules();
//	     
//	     assertEquals(INJURY_CATEGORY.MINOR_INJURY, runnerData.getInjuryCategory());
//	}
//	
//	@Test
//	public void injury_brokenLeg() {
//	     KieSession kieSession = kieContainer.newKieSession("test-session");
//
//	     kieSession.getAgenda().getAgendaGroup("injury").setFocus();
//	     LocalDate date = LocalDate.parse("2021-06-06");
//	     Instant instant = date.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
//	     TrainingPlan trainingPlan = new TrainingPlan(instant, "Derventa", TIME_GOAL.BETWEEN_1h20m_AND_1h50m);
//	     RunnerData runnerData = new RunnerData(28,170,75,GENDER.FEMALE,2000);
//	     Long id = (long) 1;
//	 	 User user = new User(id, "Snjezana", "Simic", "user1@gmail.com", true, "user1", "fasdf",
//				USER_ROLE.ROLE_RUNNER, trainingPlan, runnerData);
//	     Instant dateInjury = Instant.now();
//	     Injury injury = new Injury(dateInjury, INJURY_TYPE.BROKEN_LEG,runnerData);
//	     
//	     kieSession.insert(injury);
//	     
//	     kieSession.fireAllRules();
//	     
//	     assertEquals(runnerData.getInjuryCategory(), INJURY_CATEGORY.SEVERE_INJURY);
//	}
	
//	@Test
//	public void injuryBrokenLeg() {
//	     KieSession kieSession = kieContainer.newKieSession("test-session");
//
//	     kieSession.getAgenda().getAgendaGroup("cooper").setFocus();
//	     LocalDate date = LocalDate.parse("2021-07-31");
//	     Instant instant = date.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
//	     TrainingPlan trainingPlan = new TrainingPlan(instant, "Derventa", TIME_GOAL.BETWEEN_1h20m_AND_1h50m);
//	     RunnerData runnerData = new RunnerData(28,170,75,GENDER.FEMALE,2000);
//	     Long id = (long) 1;
//	 	 User user = new User(id, "Snjezana", "Simic", "user1@gmail.com", true, "user1", "fasdf",
//				USER_ROLE.ROLE_RUNNER, trainingPlan, runnerData);
//	     Instant dateInjury = Instant.now();
//	     Injury injury = new Injury(dateInjury, INJURY_TYPE.BROKEN_LEG,runnerData);
//	     
//	     kieSession.insert(injury);
//	     kieSession.fireAllRules();
//	     assertEquals(runnerData.getInjuryCategory(), INJURY_CATEGORY.SEVERE_INJURY);
//	}
	
	@Test
	public void raceData_MORE_THAN_24() {
	     KieSession kieSession = kieContainer.newKieSession("test-session");
	     kieSession.getAgenda().getAgendaGroup("time").setFocus();
	     
	     LocalDate date = LocalDate.parse("2021-12-09");
	     Instant instant = date.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
	     TrainingPlan trainingPlan = new TrainingPlan(instant, "Derventa", TIME_GOAL.UNDER_1h20m);
	     RunnerData runnerData = new RunnerData(28,170,75,GENDER.FEMALE,3000);
	     runnerData.setPhysicalFitness(PHYSICAL_FITNESS.GOOD);
	     runnerData.setPlannerTaken(false);
	     
	     Long id = (long) 1;
	 	 User user = new User(id, "Snjezana", "Simic", "user1@gmail.com", true, "user1", "fasdf",
				USER_ROLE.ROLE_RUNNER, trainingPlan, runnerData);
	 	
	     kieSession.insert(trainingPlan);
	     kieSession.insert(runnerData);
	     kieSession.fireAllRules();

		 assertEquals(trainingPlan.getPreparationTime(), PREPARATION_TIME.MORE_THAN_24);
	
//	     kieSession.getAgenda().getAgendaGroup("intensity").setFocus();
//		 kieSession.insert(trainingPlan);
//		 kieSession.insert(runnerData);
//		 kieSession.fireAllRules();
			
//		assertEquals(trainingPlan.getIntensityLevel(), INTENSITY.ADVANCED);;
	}
	
	@Test
	public void raceData() {
	     KieSession kieSession = kieContainer.newKieSession("test-session");
	     kieSession.getAgenda().getAgendaGroup("time").setFocus();
	     
	     LocalDate date = LocalDate.parse("2021-10-03");
	     Instant instant = date.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
	     TrainingPlan trainingPlan = new TrainingPlan(instant, "Derventa", TIME_GOAL.BETWEEN_1h20m_AND_1h50m);
	     RunnerData runnerData = new RunnerData(25,170,75,GENDER.MALE,1200);
	     runnerData.setPhysicalFitness(PHYSICAL_FITNESS.BAD);
	     runnerData.setPlannerTaken(false);
	     
	     Long id = (long) 1;
	 	 User user = new User(id, "Snjezana", "Simic", "user1@gmail.com", true, "user1", "fasdf",
				USER_ROLE.ROLE_RUNNER, trainingPlan, runnerData);
	 	
	     kieSession.insert(trainingPlan);
	     kieSession.insert(runnerData);
	     kieSession.fireAllRules();

		 assertEquals(trainingPlan.getPreparationTime(),null);
	
//	     kieSession.getAgenda().getAgendaGroup("intensity").setFocus();
//		 kieSession.insert(trainingPlan);
//		 kieSession.insert(runnerData);
//		 kieSession.fireAllRules();
			
//		assertEquals(trainingPlan.getIntensityLevel(), INTENSITY.ADVANCED);;
	}

	@Test
	public void raceData_noTime() {
	     KieSession kieSession = kieContainer.newKieSession("test-session");
	
	     kieSession.getAgenda().getAgendaGroup("time").setFocus();
	     LocalDate date = LocalDate.parse("2021-07-31");
	     Instant instant = date.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
	     TrainingPlan trainingPlan = new TrainingPlan(instant, "Derventa", TIME_GOAL.BETWEEN_1h20m_AND_1h50m);
	     RunnerData runnerData = new RunnerData(28,170,75,GENDER.FEMALE,2000);
	     Long id = (long) 1;
	 	 User user = new User(id, "Snjezana", "Simic", "user1@gmail.com", true, "user1", "fasdf",
				USER_ROLE.ROLE_RUNNER, trainingPlan, runnerData);
	     kieSession.insert(trainingPlan);
	     kieSession.fireAllRules();
	 
	     kieSession.getAgenda().getAgendaGroup("intensity").setFocus();
		 kieSession.insert(trainingPlan);
		 kieSession.insert(runnerData);
		 kieSession.fireAllRules();
			
		assertEquals(trainingPlan.isCanceledPreparation(), true);
	}
	
	@Test
	public void intensity() {
	     KieSession kieSession = kieContainer.newKieSession("test-session");
	
	     kieSession.getAgenda().getAgendaGroup("time").setFocus();
	     LocalDate date = LocalDate.parse("2021-11-30");
	     Instant instant = date.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
	     TrainingPlan trainingPlan = new TrainingPlan(instant, "Derventa", TIME_GOAL.BETWEEN_1h20m_AND_1h50m);
	     RunnerData runnerData = new RunnerData(25,170,75,GENDER.FEMALE,3000);
	     Long id = (long) 1;
	 	 User user = new User(id, "Snjezana", "Simic", "user1@gmail.com", true, "user1", "fasdf",
				USER_ROLE.ROLE_RUNNER, trainingPlan, runnerData);
	     kieSession.insert(trainingPlan);
	     kieSession.fireAllRules();
	 
	     kieSession.getAgenda().getAgendaGroup("intensity").setFocus();
		 kieSession.insert(trainingPlan);
		 kieSession.insert(runnerData);
		 kieSession.fireAllRules();

		assertEquals(trainingPlan.getIntensityLevel(), null);
	}
	
	@Test
	public void intensity_STARTER() {
	     KieSession kieSession = kieContainer.newKieSession("test-session");
	
	     kieSession.getAgenda().getAgendaGroup("time").setFocus();
	     LocalDate date = LocalDate.parse("2021-10-31");
	     Instant instant = date.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
	     TrainingPlan trainingPlan = new TrainingPlan(instant, "Derventa", TIME_GOAL.OVER_1h50m);
	     RunnerData runnerData = new RunnerData(50,170,75,GENDER.FEMALE,3000);
	     Long id = (long) 1;
	 	 User user = new User(id, "Snjezana", "Simic", "user1@gmail.com", true, "user1", "fasdf",
				USER_ROLE.ROLE_RUNNER, trainingPlan, runnerData);
	     kieSession.insert(trainingPlan);
	     kieSession.fireAllRules();
	 
	     kieSession.getAgenda().getAgendaGroup("intensity").setFocus();
		 kieSession.insert(trainingPlan);
		 kieSession.insert(runnerData);
		 kieSession.fireAllRules();

		assertEquals(trainingPlan.getIntensityLevel(), null);
	}
	
}
