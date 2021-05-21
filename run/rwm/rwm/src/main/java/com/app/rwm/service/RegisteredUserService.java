package com.app.rwm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.rwm.model.RegisteredUser;
import com.app.rwm.repository.RegisteredUserRepository;

@Service
public class RegisteredUserService {

	@Autowired
	private RegisteredUserRepository repository;
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;

	public List<RegisteredUser> findAll() {
		return repository.findAllRegisteredUser();
	}

	public RegisteredUser findOne(Long id) {
		return repository.findByIdAndActive(id, true).orElse(null);
	}
}