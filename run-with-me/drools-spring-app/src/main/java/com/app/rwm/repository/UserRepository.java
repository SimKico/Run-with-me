package com.app.rwm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.rwm.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
