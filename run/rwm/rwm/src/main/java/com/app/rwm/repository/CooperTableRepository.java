package com.app.rwm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.rwm.model.CooperTable;

@Repository
public interface CooperTableRepository extends JpaRepository<CooperTable, Long>  {

}
