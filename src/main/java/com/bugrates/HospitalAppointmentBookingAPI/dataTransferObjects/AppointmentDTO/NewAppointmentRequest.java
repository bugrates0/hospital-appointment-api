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
	
	@NotNull
	@NotBlank 
	private int patientId;
	
	public NewAppointmentRequest() {
		
	}

	public NewAppointmentRequest(String appointmentDate, String appointmentTime, int doctorId, int patientId) {
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.doctorId = doctorId;
		this.patientId = patientId;
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

	public int getPatientId() {
		return patientId;
	}
	
	
	
	
}
