package com.bugrates.HospitalAppointmentBookingAPI.entities;



import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Table(name="doctors")
@Entity
public class Doctor {
	
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
	@Column(name="email", unique = true)
	private String email;
	

	@ManyToOne()
	@JoinColumn(name="clinic_id", referencedColumnName = "id", nullable = false)
	private Clinic clinic;
	
	@OneToMany(mappedBy = "doctor")
	private List<Appointment> appointments;
	
	public Doctor() {
	}
	
	public Doctor(int id, String firstName, String lastName, String email, Clinic clinic, List<Appointment> appointments) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.clinic = clinic;
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
