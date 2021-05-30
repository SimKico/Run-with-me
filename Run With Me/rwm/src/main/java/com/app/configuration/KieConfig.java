//package com.app.configuration;
//
//
//import org.kie.api.KieServices;
//import org.kie.api.builder.KieScanner;
//import org.kie.api.runtime.KieContainer;
//import org.kie.api.runtime.KieSession;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import lombok.AllArgsConstructor;
//
//@EnableTransactionManagement
//@EnableAsync
//@Configuration
//@AllArgsConstructor
//public class KieConfig {
//    @Bean
//    public KieServices kieServices() { return KieServices.Factory.get(); }
//
//    @Bean
//    public KieContainer kieContainer(KieServices kieServices) {
//    	System.out.println("kie Services " + kieServices);
//        KieContainer kieContainer = kieServices
//                .newKieContainer(kieServices.newReleaseId("com.app.rwm", "rwm-kjar", "1.0.0-SNAPSHOT"));
//    	System.out.println("kieContainer " + kieContainer);
//        KieScanner kieScanner = kieServices.newKieScanner(kieContainer);
//    	System.out.println("kieScanner " + kieScanner);
//        kieScanner.start(10_000);
//        
//        return kieContainer;
//    }
//
//    @Bean
//    public KieSession kieSession(KieContainer kieContainer) {
//        KieSession kieSession = kieContainer.newKieSession("test-session");
//    	System.out.println("kieSession from kieSession" + kieSession);
//   
//        return kieSession;
//    }
//}
