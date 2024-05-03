package com.bugrates.HospitalAppointmentBookingAPI.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bugrates.HospitalAppointmentBookingAPI.entities.Clinic;

public interface ClinicRepository extends JpaRepository<Clinic, Integer> {

}
