package com.bugrates.HospitalAppointmentBookingAPI.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Table(name="patients")
@Entity
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull
	@NotBlank(message = "First name is obligatory")
	@Column(name="first_name")
	private String firstName;
	
	@NotNull
	@NotBlank(message = "Last name is obligatory")
	@Column(name="last_name")
	private String lastName;
	
	@NotNull
	@NotBlank(message = "E-Mail is obligatory")
	@Column(name="email", unique=true)
	private String email;
	
	@OneToMany(mappedBy = "patient")
	private List<Appointment> appointments;

	
	public Patient() {
		// TODO Auto-generated constructor stub
	}
	
	public Patient(int id, String firstName, String lastName, String email, List<Appointment> appointments) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.appointments = appointments;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	
	
	
}
