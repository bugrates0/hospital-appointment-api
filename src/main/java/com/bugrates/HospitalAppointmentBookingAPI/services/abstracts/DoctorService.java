package com.bugrates.HospitalAppointmentBookingAPI.services.abstracts;

import java.util.List;

import com.bugrates.HospitalAppointmentBookingAPI.entities.Doctor;


public interface DoctorService {
	
	public void add(Doctor doctor);
	
	public List<Doctor> getAll();
	
	public Doctor getById(int id);
	
	public void delete(int id);
	
	public void assignClinicToDoctor(int clinicId, int doctorId);

}
