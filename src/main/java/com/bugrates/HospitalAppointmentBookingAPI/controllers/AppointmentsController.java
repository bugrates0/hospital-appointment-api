package com.bugrates.HospitalAppointmentBookingAPI.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.AppointmentDTO.NewAppointmentRequest;
import com.bugrates.HospitalAppointmentBookingAPI.services.abstracts.AppointmentService;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentsController {

	private AppointmentService appointmentService;
	
	public AppointmentsController(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}
	
	
	@PostMapping()
	public ResponseEntity<String> add(@RequestBody NewAppointmentRequest newAppointmentRequest) {
		try {
			this.appointmentService.createAppointment(newAppointmentRequest);
			return ResponseEntity.ok("Your appointment has been successfully created.");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't created: " + e.getMessage());
		}
		
	}
	
	
}
