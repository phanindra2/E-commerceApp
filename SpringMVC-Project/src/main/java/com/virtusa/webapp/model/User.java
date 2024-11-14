package com.virtusa.webapp.model;

import javax.validation.constraints.NotEmpty;

public class User {
	
	@NotEmpty(message = "User name is Mandotary")
	String username;
	@NotEmpty(message = "password is mandatory")
	String password;
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User() {
		super();
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
