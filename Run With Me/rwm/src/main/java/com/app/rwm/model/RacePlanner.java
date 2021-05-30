package com.app.rwm.model;

import javax.persistence.*;

@Entity
public class RacePlanner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	String test;

	public RacePlanner() {
		super();
	}

	public RacePlanner(Long id, String test) {
		super();
		this.id = id;
		this.test = test;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
	
}
