package com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.DoctorDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class NewDoctorRequest {
	
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
	
	@NotNull
	@NotBlank 
	private int clinicId;
	
	public NewDoctorRequest() {
		// TODO Auto-generated constructor stub
	}

	public NewDoctorRequest(String firstName, String lastName, String email, String password, int clinicId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.clinicId = clinicId;
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

	public int getClinicId() {
		return clinicId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}	
