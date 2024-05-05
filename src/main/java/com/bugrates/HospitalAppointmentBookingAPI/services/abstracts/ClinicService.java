package com.bugrates.HospitalAppointmentBookingAPI.services.abstracts;

import java.util.List;

import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.ClinicDTO.GetAllClinicsResponse;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.ClinicDTO.NewClinicRequest;

public interface ClinicService {
	
	public void add(NewClinicRequest newClinicRequest);
	
	public List<GetAllClinicsResponse> getAll();

}
