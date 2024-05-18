package com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.AppointmentDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class NewAppointmentRequest {
	
	@NotNull
	@NotBlank
	private String appointmentDate;
	
	@NotNull
	@NotBlank
	private String appointmentTime;
	
	@NotNull
	@NotBlank 
	private int doctorId;
	
	
	public NewAppointmentRequest() {
		
	}

	public NewAppointmentRequest(String appointmentDate, String appointmentTime, int doctorId) {
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.doctorId = doctorId;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public int getDoctorId() {
		return doctorId;
	}
	
	
}
