package com.bugrates.HospitalAppointmentBookingAPI.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<String> add(@RequestBody NewPatientRequest newPatientRequest) {
		
		try {
			this.patientService.add(newPatientRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body("New patient account has been successfully created.");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't created: " + e.getMessage());
		}
		
	}
	
	@GetMapping()
	public List<GetAllPatientsResponse> getAll() {
		return this.patientService.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GetByIdPatientResponse> getById(@PathVariable int id) {	
		try {
			return ResponseEntity.ok(patientService.getById(id));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		
		try {
			this.patientService.delete(id);
			return ResponseEntity.ok("Patient's account has been deleted.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't deleted: " + e.getMessage());
		}
	}
	
	
}
