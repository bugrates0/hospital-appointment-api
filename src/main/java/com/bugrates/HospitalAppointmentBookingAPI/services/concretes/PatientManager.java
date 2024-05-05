package com.bugrates.HospitalAppointmentBookingAPI.services.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugrates.HospitalAppointmentBookingAPI.core.utilities.mappers.ModelMapperService;
import com.bugrates.HospitalAppointmentBookingAPI.dataAccess.abstracts.PatientRepository;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.ClinicDTO.GetAllClinicsResponse;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.DoctorDTO.GetByIdDoctorResponse;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.PatientDTO.GetAllPatientsResponse;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.PatientDTO.GetByIdPatientResponse;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.PatientDTO.NewPatientRequest;
import com.bugrates.HospitalAppointmentBookingAPI.entities.Clinic;
import com.bugrates.HospitalAppointmentBookingAPI.entities.Doctor;
import com.bugrates.HospitalAppointmentBookingAPI.entities.Patient;
import com.bugrates.HospitalAppointmentBookingAPI.services.abstracts.PatientService;

@Service
public class PatientManager implements PatientService {

	private PatientRepository patientRepository;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public PatientManager(PatientRepository patientRepository, ModelMapperService modelMapperService) {
		this.patientRepository = patientRepository;
		this.modelMapperService = modelMapperService;
	}
	
	@Override
	public void add(NewPatientRequest newPatientRequest) {
		
		Patient newPatient = this.modelMapperService.forRequest().map(newPatientRequest, Patient.class);
		
		this.patientRepository.save(newPatient);
	}

	@Override
	public GetByIdPatientResponse getById(int id) {
		
		Patient patient = this.patientRepository.findById(id).get();
		
		GetByIdPatientResponse patientResponse = this.modelMapperService.forResponse().map(patient, GetByIdPatientResponse.class);
		
		return patientResponse;
	}

	@Override
	public void delete(int id) {
		
		Patient patient = this.patientRepository.findById(id).get();
		
		this.patientRepository.delete(patient);
		
	}

	@Override
	public List<GetAllPatientsResponse> getAll() {
		
		List<Patient> patients =  this.patientRepository.findAll();
		
		List<GetAllPatientsResponse> patientsResponse = patients.stream().map(patient-> this.modelMapperService.forResponse().map(patient, GetAllPatientsResponse.class)).collect(Collectors.toList());
	
		return patientsResponse;
	}

	
	
}
