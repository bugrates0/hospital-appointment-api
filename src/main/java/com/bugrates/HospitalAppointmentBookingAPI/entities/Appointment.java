package com.bugrates.HospitalAppointmentBookingAPI.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;

@Table(name="appointments", uniqueConstraints = {
		   @UniqueConstraint(name = "Unique_Doctor-Date-Time", columnNames = {"appointment_date", "appointment_time", "doctor_id"}),
		   @UniqueConstraint(name = "Unique_Patient-Date-Time", columnNames = {"appointment_date", "appointment_time", "patient_id"})})
@Entity
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull
	@Column(name="appointment_date")
	private LocalDate appointmentDate;
	
	@NotNull
	@Column(name="appointment_time")
	private LocalTime appointmentTime;
	
	@ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id", nullable = false)
	private User doctor;
	
	@ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
	private User patient;

	
	public Appointment() {
		
	}


	public Appointment(int id,LocalDate appointmentDate, LocalTime appointmentTime, Doctor doctor, User patient) {
		this.id = id;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.doctor = doctor;
		this.patient = patient;
	}


	public int getId() {
		return id;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}


	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}


	public LocalTime getAppointmentTime() {
		return appointmentTime;
	}


	public void setAppointmentTime(LocalTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}


	public User getDoctor() {
		return doctor;
	}


	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}


	public User getPatient() {
		return patient;
	}


	public void setPatient(User patient) {
		this.patient = patient;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFormattedAppointmentDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return appointmentDate.format(formatter);
    }
	
	public String getFormattedAppointmentTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return appointmentTime.format(formatter);
    }
	
}
