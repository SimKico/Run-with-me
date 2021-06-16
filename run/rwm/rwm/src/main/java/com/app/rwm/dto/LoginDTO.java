package com.app.rwm.dto;


public class LoginDTO {

//	@NotNull(message = "Username can not be null")
	private String username;

//	@NotNull(message = "Password can not be null")
//	@Size(min = 8, message = "Password must be at least 8 characters")
	private String password;

	public LoginDTO() {
		super();
	}

	public LoginDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
}
