package com.bugrates.HospitalAppointmentBookingAPI.services.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugrates.HospitalAppointmentBookingAPI.dataAccess.abstracts.ClinicRepository;
import com.bugrates.HospitalAppointmentBookingAPI.dataAccess.abstracts.DoctorRepository;
import com.bugrates.HospitalAppointmentBookingAPI.entities.Clinic;
import com.bugrates.HospitalAppointmentBookingAPI.entities.Doctor;
import com.bugrates.HospitalAppointmentBookingAPI.entities.Patient;
import com.bugrates.HospitalAppointmentBookingAPI.services.abstracts.DoctorService;

@Service
public class DoctorManager implements DoctorService {

	private DoctorRepository doctorRepository;
	private ClinicRepository clinicRepository;

	@Autowired
	public DoctorManager(DoctorRepository doctorRepository, ClinicRepository clinicRepository) {
		this.doctorRepository = doctorRepository;
		this.clinicRepository = clinicRepository;
	}

	@Override
	public void add(Doctor doctor) {

		// we will change here later!
		// gelen stringdeki bosluk vs sil ve oyle dbye gonder
		Doctor newDoctor = new Doctor();
		newDoctor.setFirstName(doctor.getFirstName());
		newDoctor.setLastName(doctor.getLastName());
		newDoctor.setEmail(doctor.getEmail());
		this.doctorRepository.save(newDoctor);

	}

	@Override
	public List<Doctor> getAll() {
		
		return this.doctorRepository.findAll();
	}

	@Override
	public Doctor getById(int id) {
		
		return this.doctorRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		
		this.doctorRepository.delete(this.getById(id));
	}

	@Override
	public void assignClinicToDoctor(int clinicId, int doctorId) {
		
		Clinic clinic = this.clinicRepository.findById(clinicId).get();
		
		Doctor doctor = this.doctorRepository.findById(doctorId).get();
		
		doctor.setClinic(clinic);
		
		this.doctorRepository.save(doctor);
	}

	

}
