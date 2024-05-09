package com.bugrates.HospitalAppointmentBookingAPI.services.concretes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugrates.HospitalAppointmentBookingAPI.dataAccess.abstracts.AppointmentRepository;
import com.bugrates.HospitalAppointmentBookingAPI.dataAccess.abstracts.DoctorRepository;
import com.bugrates.HospitalAppointmentBookingAPI.dataAccess.abstracts.PatientRepository;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.AppointmentDTO.NewAppointmentRequest;
import com.bugrates.HospitalAppointmentBookingAPI.entities.Appointment;
import com.bugrates.HospitalAppointmentBookingAPI.entities.AppointmentStartingTime;
import com.bugrates.HospitalAppointmentBookingAPI.entities.Doctor;
import com.bugrates.HospitalAppointmentBookingAPI.entities.Patient;
import com.bugrates.HospitalAppointmentBookingAPI.entities.Weekday;
import com.bugrates.HospitalAppointmentBookingAPI.services.abstracts.AppointmentService;

@Service
public class AppointmentManager implements AppointmentService {

	private AppointmentRepository appointmentRepository;
	private DoctorRepository doctorRepository;
	private PatientRepository patientRepository;
	
	@Autowired
	public AppointmentManager(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository, PatientRepository patientRepository) {
		this.appointmentRepository = appointmentRepository;
		this.doctorRepository = doctorRepository;
		this.patientRepository = patientRepository;
	}
	
	
	@Override
	public void createAppointment(NewAppointmentRequest newAppointmentRequest) throws Exception{
		
		//TODO try-catch
		
		LocalDate newAppointmentDate;
		LocalTime newAppointmentTime;
		
		try {
			newAppointmentDate = LocalDate.parse(newAppointmentRequest.getAppointmentDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")); // 13-12-2024
		} catch (Exception e) {
			throw new Exception("Please write the appointment day like '19-05-2026' (Day/Month/Year)");
		}
		
		try {
			newAppointmentTime = LocalTime.parse(newAppointmentRequest.getAppointmentTime(), DateTimeFormatter.ofPattern("HH:mm")); // 10:30
		} catch (Exception e) {
			throw new Exception("Please write the appointment time like '11:30'");
		}
		
		
		if(newAppointmentDate.isEqual(LocalDate.now()) == true  // Appointment day is not today
				|| newAppointmentDate.isAfter(LocalDate.now()) == false  // Appointment day is not a past day
				|| AppointmentStartingTime.isValidTime(newAppointmentTime)== false // Appointment time is valid
				|| Weekday.isWeekday(newAppointmentDate) == false) { // Appointment day is a week day (not weekend)
			throw new Exception("Please choose a valid time and date!");
		}else {
			
			
			Doctor doctor = this.doctorRepository.findById(newAppointmentRequest.getDoctorId()).get();
			Patient patient = this.patientRepository.findById(newAppointmentRequest.getPatientId()).get();
			
			//If Doctor-Day-Time and Patient-Day-Time constraints are appropriate then create an appointment (to avoid unused id's in database)
			if(this.appointmentRepository.getAppointmentAlreadyExistsOfDoctor(doctor.getId(), newAppointmentDate.toString(), newAppointmentTime.toString()) == null
					&& this.appointmentRepository.getAppointmentAlreadyExistsOfPatient(patient.getId(), newAppointmentDate.toString(), newAppointmentTime.toString()) == null) {
				
				//TODO implement a proper modelmapper method
				
				Appointment appointment = new Appointment();
				
				appointment.setDoctor(doctor);
				appointment.setPatient(patient);
				appointment.setAppointmentDate(newAppointmentDate);
				appointment.setAppointmentTime(newAppointmentTime);
				
				
				this.appointmentRepository.save(appointment);
			}else {
				throw new Exception("Appointment not available!");
			}
			
			
		}
		
	}

}
