package com.bugrates.HospitalAppointmentBookingAPI.core.utilities.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.DoctorDTO.GetAllDoctorsResponse;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.DoctorDTO.GetByIdDoctorResponse;
import com.bugrates.HospitalAppointmentBookingAPI.entities.Doctor;

@Service
public class ModelMapperManager implements ModelMapperService {

private ModelMapper modelMapper;
	
	@Autowired
	public ModelMapperManager(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	
	@Override
	public ModelMapper forResponse() {
		this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
		return this.modelMapper;
	}

	@Override
	public ModelMapper forRequest() {
		this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD);
		return this.modelMapper;
	}
	
	@Override
	public ModelMapper forDoctorsDetailedResponse() {
		this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
		this.modelMapper.typeMap(Doctor.class, GetAllDoctorsResponse.class)
		.addMappings(m-> m.map(doctor -> doctor.getClinic().getClinicName(), GetAllDoctorsResponse::setClinicName ));
		this.modelMapper.typeMap(Doctor.class, GetAllDoctorsResponse.class)
		.addMappings(m-> m.map(doctor -> doctor.getClinic().getId(), GetAllDoctorsResponse::setClinicId ));
		return modelMapper;
		
	}


	@Override
	public ModelMapper forDoctorDetailedResponse() {
		this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
		this.modelMapper.typeMap(Doctor.class, GetByIdDoctorResponse.class)
		.addMappings(m-> m.map(doctor -> doctor.getClinic().getClinicName(), GetByIdDoctorResponse::setClinicName ));
		this.modelMapper.typeMap(Doctor.class, GetByIdDoctorResponse.class)
		.addMappings(m-> m.map(doctor -> doctor.getClinic().getId(), GetByIdDoctorResponse::setClinicId ));
		return modelMapper;
	}

}
