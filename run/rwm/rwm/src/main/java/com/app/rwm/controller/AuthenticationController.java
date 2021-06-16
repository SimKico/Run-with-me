package com.app.rwm.controller;
import java.security.Principal;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import com.app.rwm.dto.LoginDTO;
import com.app.rwm.dto.UserTokenStateDTO;
import com.app.rwm.model.User;
import com.app.rwm.security.TokenUtils;
import com.app.rwm.service.UserService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {


	private final AuthenticationManager authenticationManager;

	private final UserDetailsService userDetailsService;

	private final TokenUtils tokenUtils;
//	private final UserService userService;
//    
    @Autowired
	public AuthenticationController(AuthenticationManager authenticationManager, UserDetailsService userDetailsService,
						  TokenUtils tokenUtils, UserService userService) {
		this.authenticationManager = authenticationManager;
		this.userDetailsService = userDetailsService;
		this.tokenUtils = tokenUtils;
//		this.userService = userService;
	}

    @PostMapping(value="/log-in",
			 consumes = MediaType.APPLICATION_JSON_VALUE,
			 produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createAuthenticationToken( @RequestBody LoginDTO loginDTO) throws UsernameNotFoundException {

    	System.out.println("here" + loginDTO.getUsername());
    	
    	Authentication authentication = authenticationManager
                 .authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(),
                         loginDTO.getPassword()));
         // Ubaci korisnika u trenutni security kontekst
         SecurityContextHolder.getContext().setAuthentication(authentication);

         // Kreiraj token za tog korisnika
         User user = (User) authentication.getPrincipal();
         String jwt = tokenUtils.generateToken(user.getEmail()); // prijavljujemo se na sistem sa email adresom
         int expiresIn = tokenUtils.getExpiredIn();

         // Vrati token kao odgovor na uspesnu autentifikaciju
         return ResponseEntity.ok(new UserTokenStateDTO(jwt, expiresIn)); 
}	
//	@PostMapping(value="/registration", 
//			 consumes = MediaType.APPLICATION_JSON_VALUE,
//			 produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<String>registration( @RequestBody UserDTO userDTO) throws Exception {
//	userService.registration(UserMapper.toUser(userDTO));
//	return new ResponseEntity<>("You are registered, now you need to verify your email", HttpStatus.OK);
//}
    
}