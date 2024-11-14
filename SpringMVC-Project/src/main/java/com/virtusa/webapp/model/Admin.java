package com.virtusa.webapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin{
	
	@Id
	private String useranme;
	
	private String password;
	
	private String details;

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getUseranme() {
		return useranme;
	}

	public void setUseranme(String useranme) {
		this.useranme = useranme;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
