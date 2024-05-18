package com.bugrates.HospitalAppointmentBookingAPI.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bugrates.HospitalAppointmentBookingAPI.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public Optional<User> findByEmail(String email);
	
	public User getByEmail(String email);
	
	public boolean existsByEmail(String email);
}
