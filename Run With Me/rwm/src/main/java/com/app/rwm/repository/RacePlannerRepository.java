package com.app.rwm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.rwm.model.RacePlanner;

@Repository
public interface RacePlannerRepository extends JpaRepository<RacePlanner, Long> {

}
