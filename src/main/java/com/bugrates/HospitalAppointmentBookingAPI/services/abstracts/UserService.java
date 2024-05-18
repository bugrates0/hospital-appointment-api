package com.bugrates.HospitalAppointmentBookingAPI.services.abstracts;

import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.AdminDTO.NewAdminRequest;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.DoctorDTO.NewDoctorRequest;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.PatientDTO.NewPatientRequest;

public interface UserService {

	public void saveNewPatient(NewPatientRequest newPatientRequest) throws Exception;
	
	public void saveNewAdmin(NewAdminRequest newAdminRequest) throws Exception;
	
	public void saveNewDoctor(NewDoctorRequest newDoctorRequest) throws Exception;
	
	public void deleteAccount(int id) throws Exception;

}
