package com.bugrates.HospitalAppointmentBookingAPI.services.concretes;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.bugrates.HospitalAppointmentBookingAPI.core.utilities.mappers.ModelMapperService;
import com.bugrates.HospitalAppointmentBookingAPI.dataAccess.abstracts.ClinicRepository;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.ClinicDTO.GetAllClinicsResponse;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.ClinicDTO.NewClinicRequest;
import com.bugrates.HospitalAppointmentBookingAPI.entities.Clinic;
import com.bugrates.HospitalAppointmentBookingAPI.services.abstracts.ClinicService;

import jakarta.validation.Valid;

@Service
public class ClinicManager implements ClinicService{
	
	private ClinicRepository clinicRepository;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public ClinicManager(ClinicRepository clinicRepository, ModelMapperService modelMapperService) {
		this.clinicRepository = clinicRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public List<GetAllClinicsResponse> getAll() {
		
		List<Clinic> clinics = this.clinicRepository.findAll();
		
		List<GetAllClinicsResponse> clinicsResponse = clinics.stream().map(clinic-> this.modelMapperService.forResponse().map(clinic, GetAllClinicsResponse.class)).collect(Collectors.toList());
		
		return clinicsResponse;
	}

	@Override
	public void add(@RequestBody @Valid NewClinicRequest newClinicRequest) {
		
		Clinic newClinic = this.modelMapperService.forRequest().map(newClinicRequest, Clinic.class);
		
		this.clinicRepository.save(newClinic);
		
	}

}
