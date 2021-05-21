package com.app.rwm.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.rwm.model.Authority;
import com.app.rwm.repository.AuthorityRepository;

@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    public Set<Authority> findById(Long id) {
        Set<Authority> auths = new HashSet<>();
        Authority auth = this.authorityRepository.findById(id).orElse(null);
        if(auth != null)
            auths.add(auth);
        return auths;
    }

	public Authority findByRole(String role) {
		// TODO Auto-generated method stub
		return authorityRepository.findByRole(role);
	}
}