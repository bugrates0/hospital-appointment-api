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

import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.DoctorDTO.GetAllDoctorsResponse;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.DoctorDTO.GetByIdDoctorResponse;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.DoctorDTO.NewDoctorRequest;
import com.bugrates.HospitalAppointmentBookingAPI.services.abstracts.DoctorService;

@RestController
@RequestMapping("/api/doctors")
public class DoctorsController {
	
	private DoctorService doctorService;
	
	
	public DoctorsController(DoctorService doctorService) {
		this.doctorService = doctorService;
	}
	
	@PostMapping()
	public ResponseEntity<String> add(@RequestBody NewDoctorRequest newDoctorRequest) {
		
		try {
			this.doctorService.add(newDoctorRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body("New doctor account has been successfully created.");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't created: " + e.getMessage());
		}
	}
	
	@GetMapping()
	public List<GetAllDoctorsResponse> getAll() {
		return this.doctorService.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GetByIdDoctorResponse> getById(@PathVariable int id) {
		
		try {
			return ResponseEntity.ok(this.doctorService.getById(id));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		
		try {
			this.doctorService.delete(id);
			return ResponseEntity.ok("Doctor's account has been deleted.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't deleted !");
		}

	}
}
