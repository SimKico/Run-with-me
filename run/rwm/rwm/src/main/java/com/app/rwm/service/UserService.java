package com.app.rwm.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.rwm.model.RunnerData;
import com.app.rwm.model.TrainingPlan;
import com.app.rwm.model.User;
import com.app.rwm.repository.UserRepository;

@Service
public class UserService{
	private final UserRepository userRepository;
//	private final VerificationTokenService verificationTokenService;
	
	
	@Autowired
	public UserService(UserRepository userRepository
//							,VerificationTokenService verificationTokenService
//							, MailService mailService
						   ) {
		this.userRepository = userRepository;
//		this.verificationTokenService = verificationTokenService;
//		this.mailService = mailService;
	}
	
	public User findOne(Long id){
		return userRepository.findById(id).orElseThrow(null);
	}

	public User findOneByUsername(String name) {
		return userRepository.findByUsername(name);
	}

	public User updateRunnerData(RunnerData userRunnerData, String username) {
		User userToUpdate = findOneByUsername(username);
		System.out.println("update runner data "+ userRunnerData.getId());
		userToUpdate.setRunnerData(userRunnerData);
		return userRepository.save(userToUpdate);
	}

	public User updateTrainingPlan(TrainingPlan trainingPlan, User user) {
		user.setTrainingPlan(trainingPlan);
		return userRepository.save(user);

	}
}
