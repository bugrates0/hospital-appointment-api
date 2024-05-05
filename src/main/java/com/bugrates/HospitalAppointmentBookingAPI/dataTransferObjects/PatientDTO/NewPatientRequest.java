package com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.PatientDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class NewPatientRequest {
	
	@NotNull
	@NotBlank 
	private String firstName;
	
	@NotNull
	@NotBlank 
	private String lastName;
	
	@NotNull
	@NotBlank 
	private String email;
	
	public NewPatientRequest() {
		
	}

	public NewPatientRequest(String firstName,String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
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
	
	
	
}
