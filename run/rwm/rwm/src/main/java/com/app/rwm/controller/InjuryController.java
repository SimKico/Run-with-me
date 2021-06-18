package com.app.rwm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;

import com.app.rwm.dto.InjuryDTO;
import com.app.rwm.dto.RunnerDataDTO;
import com.app.rwm.model.Injury;
import com.app.rwm.model.RunnerData;
import com.app.rwm.model.User;
import com.app.rwm.security.TokenUtils;
import com.app.rwm.service.CustomUserDetailsService;
import com.app.rwm.service.InjuryService;
import com.app.rwm.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/injuries", produces = MediaType.APPLICATION_JSON_VALUE)
public class InjuryController{

    @Autowired
    private TokenUtils tokenUtils;
    
	@Autowired
	private InjuryService injuryService;
	
	@Autowired
	private UserService userService;

    @Autowired
    private CustomUserDetailsService userDetailsService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<RunnerDataDTO> isCancelingPreparation(@RequestBody InjuryDTO injury) {

//		System.out.println("Injury add" + injury.getInjuryType());
		 // Ocitavamo trenutno ulogovanog korisnika
//        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();

//		System.out.println("currentUser add" + currentUser);
//        String username = ((User) currentUser.getPrincipal()).getEmail();

//		System.out.println("username add" + username);
//	    User user = (User) this.userDetailsService.loadUserByUsername(username);
//		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userService.findOneByUsername("admin");
		System.out.println("Injury add - injury type" + injury.getInjuryType());
		System.out.println("Injury add - date of injury" + injury.getDateOfInjury());
		System.out.println("Injury add - user");
		System.out.println("Injury add - user" + user.getUsername());
		
		RunnerData runnerData = user.getRunnerData();
		Injury i = new Injury(injury.getDateOfInjury(),injury.getInjuryType(), runnerData);
		injuryService.addInjury(i, runnerData);
		
		return new ResponseEntity<RunnerDataDTO>(HttpStatus.OK);
	
    }
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	 public ResponseEntity<?> test(){
		System.out.println("test1");
		return new ResponseEntity<>(HttpStatus.OK);
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
