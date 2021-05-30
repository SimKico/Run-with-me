package com.app.rwm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.rwm.model.RunnerData;
import com.app.rwm.model.User;
import com.app.rwm.repository.UserRepository;

@Service
public class UserService {
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
		return userRepository.findByUsername(name).orElseThrow(null);
	}

	public User updateRunnerData(RunnerData userRunnerData, String username) {
		User userToUpdate = userRepository.findByUsername(username).orElseThrow(null);
		userToUpdate.setRunnerData(userRunnerData);
		return userRepository.save(userToUpdate);
	}
	
}
