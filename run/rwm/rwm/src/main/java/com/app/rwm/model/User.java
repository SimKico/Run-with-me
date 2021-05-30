package com.app.rwm.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.app.rwm.enums.USER_ROLE;

@Entity
@Table(name = "users")
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String surname;

	@Column(unique=true, length=100)
	private String email;
	
	private boolean verified;

	@Column(unique=true, length=100)
	private String username;

	private String password;

	@Enumerated(EnumType.STRING)
	private USER_ROLE userRole;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "training_plan_id", referencedColumnName = "id")
	private TrainingPlan trainingPlan;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "runner_data_id", referencedColumnName = "id")
	private RunnerData runnerData;
	
	public User() {
		super();
	}

	public User(Long id, String name, String surname, String email, boolean verified, String username, String password,
			USER_ROLE userRole, TrainingPlan trainingPlan, RunnerData runnerData) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.verified = verified;
		this.username = username;
		this.password = password;
		this.userRole = userRole;
		this.trainingPlan = trainingPlan;
		this.runnerData = runnerData;
	}

	public void update(User user) {
		this.username = user.getUsername();
		this.name = user.getName();
		this.surname = user.getSurname();
	}
	
	public void registration() {
		this.userRole = USER_ROLE.ROLE_RUNNER;
		this.verified = false;
	}
	
	public User(Long userId) {
		this.id = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public USER_ROLE getUserRole() {
		return userRole;
	}

	public void setUserRole(USER_ROLE userRole) {
		this.userRole = userRole;
	}

	public TrainingPlan getTrainingPlan() {
		return trainingPlan;
	}

	public void setTrainingPlan(TrainingPlan trainingPlan) {
		this.trainingPlan = trainingPlan;
	}

	public RunnerData getRunnerData() {
		return runnerData;
	}

	public void setRunnerData(RunnerData runnerData) {
		this.runnerData = runnerData;
	}
	

}