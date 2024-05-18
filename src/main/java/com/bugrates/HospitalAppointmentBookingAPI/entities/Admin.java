package com.bugrates.HospitalAppointmentBookingAPI.entities;

import jakarta.persistence.Entity;

@Entity
public class Admin extends User{
	
	public Admin() {
		
	}

	public Admin(int id, String firstName, String lastName, String email, String password, String role) {
		super(id, firstName, lastName, email, password, role);
	}


}
