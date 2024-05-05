package com.bugrates.HospitalAppointmentBookingAPI.services.abstracts;

import java.util.List;

import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.PatientDTO.GetAllPatientsResponse;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.PatientDTO.GetByIdPatientResponse;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.PatientDTO.NewPatientRequest;
import com.bugrates.HospitalAppointmentBookingAPI.entities.Patient;

public interface PatientService {
	
	public void add(NewPatientRequest newPatientRequest);
	
	public List<GetAllPatientsResponse> getAll();
	
	public GetByIdPatientResponse getById(int id);
	
	public void delete(int id);
}
