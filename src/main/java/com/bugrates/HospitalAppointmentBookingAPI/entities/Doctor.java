package com.bugrates.HospitalAppointmentBookingAPI.entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Table(name="doctors")
@Entity
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotBlank(message = "First name is obligatory")
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank(message = "Last name is obligatory")
	@Column(name="last_name")
	private String lastName;
	
	@NotBlank(message = "E-Mail is obligatory")
	@Column(name="email")
	private String email;

	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="clinic_id", referencedColumnName = "id")
	private Clinic clinic;
	
	public Doctor() {
		// TODO Auto-generated constructor stub
	}
	
	public Doctor(int id, String firstName, String lastName, String email, Clinic clinic) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.clinic = clinic;
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
	
	
	
	
}
