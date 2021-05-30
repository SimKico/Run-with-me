package com.app.rwm.dto;

import com.app.rwm.enums.USER_ROLE;

public class UserDTO {

	private Long id;

//	@Email(message="Email should be valid")
	private String email;

//	@NotBlank(message = "Name can not be empty string")
	private String name;

//	@NotBlank(message = "Surname can not be empty string")
	private String surname;

//	@NotBlank(message = "Username can not be empty string")
	private String username;

//	@Size(min = 8, message = "Password must be at least {value}")
	private String password;

	private USER_ROLE userRole;
}
