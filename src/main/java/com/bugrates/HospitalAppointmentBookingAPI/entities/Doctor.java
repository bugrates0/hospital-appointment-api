package com.bugrates.HospitalAppointmentBookingAPI.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Doctor extends User{

	@ManyToOne()
	@JoinColumn(name="clinic_id", referencedColumnName = "id")
	private Clinic clinic;
	
	@OneToMany(mappedBy = "doctor")
	private List<Appointment> appointments;
	
	
	public Doctor() {
	}

	public Doctor(int id, String firstName, String lastName, String email, String password, String role, Clinic clinic,  List<Appointment> appointments) {
		super(id, firstName, lastName, email, password, role);
		this.clinic = clinic;
		this.appointments = appointments;
	}
	

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	
	
	
	
}
