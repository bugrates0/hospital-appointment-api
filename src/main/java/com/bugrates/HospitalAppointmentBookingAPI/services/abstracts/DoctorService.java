package com.bugrates.HospitalAppointmentBookingAPI.services.abstracts;

import java.util.List;

import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.DoctorDTO.GetAllDoctorsResponse;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.DoctorDTO.GetByIdDoctorResponse;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.DoctorDTO.NewDoctorRequest;


public interface DoctorService {
	
	public void add(NewDoctorRequest newDoctorRequest) throws Exception;
	
	public List<GetAllDoctorsResponse> getAll();
	
	public GetByIdDoctorResponse getById(int id) throws Exception;
	
	public void delete(int id) throws Exception;
	

}
