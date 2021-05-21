package com.app.rwm.model;

import javax.persistence.*;

import com.app.rwm.enums.USER_ROLE;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
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
	@JoinColumn(name = "trainig_plan_id", referencedColumnName = "id")
	private TrainingPlan trainingPlan;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "runner_data_id", referencedColumnName = "id")
	private RunnerData runnerData;
	
	
}
