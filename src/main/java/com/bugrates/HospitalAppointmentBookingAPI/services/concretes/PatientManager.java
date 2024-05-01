package com.bugrates.HospitalAppointmentBookingAPI.services.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugrates.HospitalAppointmentBookingAPI.dataAccess.abstracts.PatientRepository;
import com.bugrates.HospitalAppointmentBookingAPI.entities.Patient;
import com.bugrates.HospitalAppointmentBookingAPI.services.abstracts.PatientService;

@Service
public class PatientManager implements PatientService {

	private PatientRepository patientRepository;
	
	@Autowired
	public PatientManager(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
	
	@Override
	public void add(Patient patient) {
		
		//we will change here later!
		//gelen stringdeki bosluk vs sil ve oyle dbye gonder
		Patient newPatient = new Patient();
		newPatient.setFirstName(patient.getFirstName());
		newPatient.setLastName(patient.getLastName());
		newPatient.setEmail(patient.getEmail());
		
		this.patientRepository.save(newPatient);
	}

	@Override
	public Patient getById(int id) {
		
		return this.patientRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		
		this.patientRepository.delete(this.getById(id));
	}

	@Override
	public List<Patient> getAll() {
		
		return this.patientRepository.findAll();
	}

	
	
}
