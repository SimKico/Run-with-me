package com.app.rwm.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.rwm.services.RacePlannerService;

@RestController
public class RacePlannerController {
	private static Logger log = LoggerFactory.getLogger(RacePlannerController.class);
	
	private final RacePlannerService racePlannerService;
	
	@Autowired
	public RacePlannerController(RacePlannerService racePlannerService) {
		this.racePlannerService = racePlannerService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
}
