package com.app.rwm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.rwm.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
}
