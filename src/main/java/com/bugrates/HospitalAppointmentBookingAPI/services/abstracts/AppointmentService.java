package com.bugrates.HospitalAppointmentBookingAPI.services.abstracts;


import java.util.List;

import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.AppointmentDTO.AppointmentDetailsForPatientResponse;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.AppointmentDTO.AppointmentDetailsOfDayResponse;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.AppointmentDTO.NewAppointmentRequest;

public interface AppointmentService {
	
	public void createAppointment(NewAppointmentRequest newAppointmentRequest) throws Exception;
	
	public List<AppointmentDetailsOfDayResponse> checkAllAppointments(String date, int doctorId) throws Exception;
	
	public List<AppointmentDetailsForPatientResponse> getAllMyFutureAppointments() throws Exception;
	
	public void cancelAppointment(int appointmentId) throws Exception;

}
