package com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.AppointmentDTO;

import java.time.LocalTime;

public class AppointmentDetailsOfDayResponse {
	
	private LocalTime appointmentTime;
	
	private String appointmentStatus;
	
	
	public AppointmentDetailsOfDayResponse() {

	}


	public AppointmentDetailsOfDayResponse(LocalTime appointmentTime, String appointmentStatus) {
		this.appointmentTime = appointmentTime;
		this.appointmentStatus = appointmentStatus;
	}


	public LocalTime getAppointmentTime() {
		return appointmentTime;
	}


	public void setAppointmentTime(LocalTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}


	public String getAppointmentStatus() {
		return appointmentStatus;
	}


	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}
	
	
	

}
