package com.bugrates.HospitalAppointmentBookingAPI.services.abstracts;

import java.util.List;

import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.PatientDTO.GetAllPatientsResponse;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.PatientDTO.GetByIdPatientResponse;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.PatientDTO.NewPatientRequest;
import com.bugrates.HospitalAppointmentBookingAPI.entities.Patient;

public interface PatientService {
	
	public void add(NewPatientRequest newPatientRequest) throws Exception;
	
	public List<GetAllPatientsResponse> getAll();
	
	public GetByIdPatientResponse getById(int id) throws Exception;
	
	public void delete(int id) throws Exception;
}
