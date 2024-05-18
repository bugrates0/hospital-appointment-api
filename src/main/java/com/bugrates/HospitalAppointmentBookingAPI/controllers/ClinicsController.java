package com.bugrates.HospitalAppointmentBookingAPI.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.ClinicDTO.GetAllClinicsResponse;
import com.bugrates.HospitalAppointmentBookingAPI.services.abstracts.ClinicService;

@RestController
@RequestMapping("/api/clinics")
public class ClinicsController {
	
	private ClinicService clinicService;

	
	public ClinicsController(ClinicService clinicService) {
		this.clinicService = clinicService;
	}
	
	
	@GetMapping()
	public List<GetAllClinicsResponse> getAll() {
		return this.clinicService.getAll();
	}
	
	
}
