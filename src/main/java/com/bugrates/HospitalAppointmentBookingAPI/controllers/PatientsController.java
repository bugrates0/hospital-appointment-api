package com.bugrates.HospitalAppointmentBookingAPI.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.PatientDTO.GetAllPatientsResponse;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.PatientDTO.GetByIdPatientResponse;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.PatientDTO.NewPatientRequest;
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
	public void add(@RequestBody NewPatientRequest newPatientRequest) {
		this.patientService.add(newPatientRequest);
	}
	
	@GetMapping()
	public List<GetAllPatientsResponse> getAll() {
		return this.patientService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdPatientResponse getById(@PathVariable int id) {
		return this.patientService.getById(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.patientService.delete(id);
	}
	
	
}
