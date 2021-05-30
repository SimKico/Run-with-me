package com.app.rwm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.rwm.model.Injury;

@Repository
public interface InjuryRepository extends JpaRepository<Injury, Long> {

}
