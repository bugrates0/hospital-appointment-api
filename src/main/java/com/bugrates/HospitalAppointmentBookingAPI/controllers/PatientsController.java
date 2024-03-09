package com.bugrates.HospitalAppointmentBookingAPI.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bugrates.HospitalAppointmentBookingAPI.entities.Patient;
import com.bugrates.HospitalAppointmentBookingAPI.services.abstracts.PatientService;

@RestController
@RequestMapping("/api/patients")
public class PatientsController {
	
	private PatientService patientService;
	
	public PatientsController(PatientService patientService) {
		this.patientService = patientService;
	}
	
	
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody Patient patient) {
		
		this.patientService.add(patient);
	}
	
	
	
}
