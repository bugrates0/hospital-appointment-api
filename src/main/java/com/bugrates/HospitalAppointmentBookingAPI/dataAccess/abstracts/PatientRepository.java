package com.bugrates.HospitalAppointmentBookingAPI.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bugrates.HospitalAppointmentBookingAPI.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
