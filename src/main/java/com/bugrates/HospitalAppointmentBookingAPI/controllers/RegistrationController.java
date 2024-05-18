package com.bugrates.HospitalAppointmentBookingAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.AdminDTO.NewAdminRequest;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.DoctorDTO.NewDoctorRequest;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.PatientDTO.NewPatientRequest;
import com.bugrates.HospitalAppointmentBookingAPI.services.abstracts.UserService;

@RestController
@RequestMapping("/api/register")
public class RegistrationController {

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping()
	public ResponseEntity<String> createPatient(@RequestBody NewPatientRequest newPatientRequest) {

		try {
			newPatientRequest.setPassword(passwordEncoder.encode(newPatientRequest.getPassword()));
			this.userService.saveNewPatient(newPatientRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body("New patient account has been successfully created.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't created: " + e.getMessage());
		}
	}
	
	@PostMapping("/admin")
	public ResponseEntity<String> createAdmin(@RequestBody NewAdminRequest newAdminRequest) {

		try {
			newAdminRequest.setPassword(passwordEncoder.encode(newAdminRequest.getPassword()));
			this.userService.saveNewAdmin(newAdminRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body("New admin account has been successfully created.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't created: " + e.getMessage());
		}
	}
	
	@PostMapping("/doctor")
	public ResponseEntity<String> createDoctor(@RequestBody NewDoctorRequest newDoctorRequest) {

		try {
			newDoctorRequest.setPassword(passwordEncoder.encode(newDoctorRequest.getPassword()));
			this.userService.saveNewDoctor(newDoctorRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body("New doctor account has been successfully created.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't created: " + e.getMessage());
		}
	}
	
}
