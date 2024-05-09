package com.bugrates.HospitalAppointmentBookingAPI.services.abstracts;


import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.AppointmentDTO.NewAppointmentRequest;

public interface AppointmentService {
	
	public void createAppointment(NewAppointmentRequest newAppointmentRequest) throws Exception ;

}
