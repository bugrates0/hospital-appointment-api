package com.bugrates.HospitalAppointmentBookingAPI.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bugrates.HospitalAppointmentBookingAPI.entities.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	
	public boolean existsByEmail(String email);
}
