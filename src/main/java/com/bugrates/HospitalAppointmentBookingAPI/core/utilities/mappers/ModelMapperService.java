package com.bugrates.HospitalAppointmentBookingAPI.core.utilities.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
	
	ModelMapper forResponse();
	
	ModelMapper forRequest();
	
	ModelMapper forDoctorsDetailedResponse(); // GetAllDoctorsResponse
	
	ModelMapper forDoctorDetailedResponse(); // GetByIdDoctorResponse
}
