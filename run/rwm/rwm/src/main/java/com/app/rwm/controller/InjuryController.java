package com.app.rwm.controller;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.rwm.dto.InjuryDTO;
import com.app.rwm.dto.RunnerDataDTO;
import com.app.rwm.enums.INJURY_TYPE;
import com.app.rwm.model.Injury;
import com.app.rwm.model.RunnerData;
import com.app.rwm.model.User;
import com.app.rwm.service.InjuryService;
import com.app.rwm.service.RunnerDataService;
//import com.app.rwm.service.RunnerDataService;
import com.app.rwm.service.UserService;

@RestController
@CrossOrigin(origins= "http://localhost:4200/*")
@RequestMapping(value = "/injuries", produces = MediaType.APPLICATION_JSON_VALUE)
public class InjuryController{

	@Autowired
	private InjuryService injuryService;
	
	@Autowired
	private RunnerDataService runnerDataService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<RunnerDataDTO> isCancelingPreparation(@RequestBody InjuryDTO injury) {
		User user = userService.findOneByUsername("user1");
		System.out.println("Injury add - CONTROLLER" + injury.getInjuryType());
		RunnerData runnerData = user.getRunnerData();
		Injury i = new Injury(injury.getDateOfInjury(),injury.getInjuryType(), runnerData);
		injuryService.addInjury(i, runnerData);
		
		return new ResponseEntity<RunnerDataDTO>(HttpStatus.OK);
	
    }
//	
//	private final InjuryService injuryService;
//	private final RunnerDataService runnerDataService;
//	private final UserService userService;
//	
//	@Autowired
//	public InjuryController(InjuryService injuryService, RunnerDataService runnerDataService, UserService userService) {
//		this.injuryService = injuryService;
//		this.runnerDataService = runnerDataService;
//		this.userService = userService;
//	}
//	
//	@PostMapping(path = "/add",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Long> addInjury(@RequestBody String injuryType){
//		User user = userService.findOneByUsername("user1");
//		RunnerData runnerData = runnerDataService.findById(user.getRunnerData().getId());
//		Injury injury = new Injury(new Date(),INJURY_TYPE.valueOf(injuryType));
//		injuryService.addInjury(injury);
//		return new ResponseEntity<>(runnerData.getId(), HttpStatus.OK);
//	}
//	
//	
}
