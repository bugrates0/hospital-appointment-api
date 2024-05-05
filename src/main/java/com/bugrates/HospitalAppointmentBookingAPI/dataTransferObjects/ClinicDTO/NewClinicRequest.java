package com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.ClinicDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class NewClinicRequest {
	
	@NotBlank
	@NotNull
	private String clinicName;
	
	public NewClinicRequest() {
		
	}

	public NewClinicRequest(String clinicName) {
		this.clinicName = clinicName;
	}

	public String getClinicName() {
		return clinicName;
	}
	
}
