package com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.AdminDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class NewAdminRequest {
	
	@NotNull
	@NotBlank 
	private String firstName;
	
	@NotNull
	@NotBlank 
	private String lastName;
	
	@NotNull
	@NotBlank 
	private String email;
	
	@NotNull
	@NotBlank 
	private String password;
	
	public NewAdminRequest() {
		
	}

	public NewAdminRequest(String firstName, String lastName ,String email,  String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
