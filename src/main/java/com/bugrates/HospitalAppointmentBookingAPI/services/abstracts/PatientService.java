package com.bugrates.HospitalAppointmentBookingAPI.services.abstracts;

import java.util.List;

import com.bugrates.HospitalAppointmentBookingAPI.entities.Patient;

public interface PatientService {
	
	public void add(Patient patient);
	
	public List<Patient> getAll();
	
	public Patient getById(int id);
	
	public void delete(int id);
}
