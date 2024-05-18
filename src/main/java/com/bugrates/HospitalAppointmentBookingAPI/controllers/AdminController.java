package com.bugrates.HospitalAppointmentBookingAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.ClinicDTO.NewClinicRequest;
import com.bugrates.HospitalAppointmentBookingAPI.services.abstracts.ClinicService;
import com.bugrates.HospitalAppointmentBookingAPI.services.abstracts.UserService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private ClinicService clinicService;
	
	@Autowired
	private UserService userService;

	

	//Add new clinic
	@PostMapping("/clinics")
	public ResponseEntity<String> addNewClinic(@RequestBody NewClinicRequest newClinicRequest) {
		
		try {
			this.clinicService.add(newClinicRequest);
			return ResponseEntity.ok("New clinic has been added: " + newClinicRequest.getClinicName());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't added: " + e.getMessage());
		}
		
		
	}
	

	//Delete account
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable int id) {
		
		try {
			this.userService.deleteAccount(id);
			return ResponseEntity.ok("Account has been deleted.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't deleted: " + e.getMessage());
		}
	}

}
