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

@Table(name="clinics")
@Entity
public class Clinic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotBlank(message = "Clinic name is obligatory")
	@Column(name="clinic_name")
	private String clinicName;
	
	@OneToMany(mappedBy = "clinic")
	private List<Doctor> doctors;
	
	public Clinic() {
		// TODO Auto-generated constructor stub
	}
	
	public Clinic(int id, String clinicName) {
		this.id = id;
		this.clinicName = clinicName;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	
	

}
