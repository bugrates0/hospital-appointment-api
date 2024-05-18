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
import org.springframework.web.bind.annotation.RestController;

import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.AppointmentDTO.AppointmentDetailsForPatientResponse;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.AppointmentDTO.AppointmentDetailsOfDayResponse;
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
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't booked: " + e.getMessage());
		}

	}


	
	
	
	@GetMapping("/{doctorId}/{appointmentDay}")
	public List<AppointmentDetailsOfDayResponse> getAvailabilityOfAppointmentDate(@PathVariable int doctorId, @PathVariable String appointmentDay) throws Exception {

		try {
			return this.appointmentService.checkAllAppointments(appointmentDay, doctorId);
		} catch (Exception e) {
			throw new Exception(e);
		}

	}
	
	@GetMapping()
	public List<AppointmentDetailsForPatientResponse> getAllMyAppointments() throws Exception {

		try {
			return this.appointmentService.getAllMyFutureAppointments();
		} catch (Exception e) {
			throw new Exception(e);
		}

	}
	
	@DeleteMapping("/{appointmentId}")
	public ResponseEntity<String> cancelAppointment(@PathVariable int appointmentId) {
		try {
			this.appointmentService.cancelAppointment(appointmentId);
			return ResponseEntity.ok("Your appointment has been successfully canceled.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

	}

}
