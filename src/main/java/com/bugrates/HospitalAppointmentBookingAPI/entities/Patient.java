package com.bugrates.HospitalAppointmentBookingAPI.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Patient extends User {

	@OneToMany(mappedBy = "patient")
	private List<Appointment> appointments;

	public Patient() {

	}

	public Patient(int id, String firstName, String lastName, String email, String password, String role,
			List<Appointment> appointments) {
		super(id, firstName, lastName, email, password, role);
		this.appointments = appointments;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

}
