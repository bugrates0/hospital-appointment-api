package com.bugrates.HospitalAppointmentBookingAPI.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bugrates.HospitalAppointmentBookingAPI.dataAccess.abstracts.ClinicRepository;
import com.bugrates.HospitalAppointmentBookingAPI.entities.Clinic;
import com.bugrates.HospitalAppointmentBookingAPI.entities.Doctor;
import com.bugrates.HospitalAppointmentBookingAPI.services.abstracts.DoctorService;

@RestController
@RequestMapping("/api/doctors")
public class DoctorsController {
	
	private DoctorService doctorService;
	
	
	public DoctorsController(DoctorService doctorService) {
		this.doctorService = doctorService;
	}
	
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody Doctor doctor) {
		
		
		this.doctorService.add(doctor);
	}
	
	@GetMapping()
	public List<Doctor> getAll() {
		return this.doctorService.getAll();
	}
	
	@GetMapping("/{id}")
	public Doctor getById(@PathVariable int id) {
		return this.doctorService.getById(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.doctorService.delete(id);
	}
	
	@PutMapping("/clinics/{clinicId}/doctors/{doctorId}")
	public void assignClinicToDoctor(@PathVariable int clinicId, @PathVariable int doctorId ) {
		
		this.doctorService.assignClinicToDoctor(clinicId, doctorId);
	}
	
}
