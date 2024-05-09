package com.bugrates.HospitalAppointmentBookingAPI.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bugrates.HospitalAppointmentBookingAPI.entities.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
	
	@Query(value = "SELECT * FROM appointments WHERE doctor_id = :doctor_id AND appointment_date = :appointment_date AND appointment_time = :appointment_time", nativeQuery = true)
	public Appointment getAppointmentAlreadyExistsOfDoctor(@Param("doctor_id")int doctorId, @Param("appointment_date")String date, @Param("appointment_time")String time);
	
	@Query(value = "SELECT * FROM appointments WHERE patient_id = :patient_id AND appointment_date = :appointment_date AND appointment_time = :appointment_time", nativeQuery = true)
	public Appointment getAppointmentAlreadyExistsOfPatient(@Param("patient_id")int patientId, @Param("appointment_date")String date, @Param("appointment_time")String time);

	
}
