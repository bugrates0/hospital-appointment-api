package com.bugrates.HospitalAppointmentBookingAPI.services.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.bugrates.HospitalAppointmentBookingAPI.core.utilities.mappers.ModelMapperService;
import com.bugrates.HospitalAppointmentBookingAPI.dataAccess.abstracts.DoctorRepository;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.DoctorDTO.GetAllDoctorsResponse;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.DoctorDTO.GetByIdDoctorResponse;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.DoctorDTO.NewDoctorRequest;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.PatientDTO.GetByIdPatientResponse;
import com.bugrates.HospitalAppointmentBookingAPI.entities.Doctor;
import com.bugrates.HospitalAppointmentBookingAPI.entities.Patient;
import com.bugrates.HospitalAppointmentBookingAPI.services.abstracts.DoctorService;

import jakarta.validation.Valid;

@Service
public class DoctorManager implements DoctorService {

	private DoctorRepository doctorRepository;
	private ModelMapperService modelMapperService;

	@Autowired
	public DoctorManager(DoctorRepository doctorRepository, ModelMapperService modelMapperService) {
		this.doctorRepository = doctorRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public void add(@RequestBody @Valid NewDoctorRequest newDoctorRequest) throws Exception{
		
		if(this.doctorRepository.existsByEmail(newDoctorRequest.getEmail()) == false) {
			Doctor newDoctor = this.modelMapperService.forRequest().map(newDoctorRequest, Doctor.class);
			this.doctorRepository.save(newDoctor);
		}else {
			throw new Exception("E-Mail already exits!");
		}

	}

	@Override
	public List<GetAllDoctorsResponse> getAll() {
		
		List<Doctor> doctors = this.doctorRepository.findAll();
		
		List<GetAllDoctorsResponse> doctorsResponse = doctors.stream().map(doctor-> this.modelMapperService.forDoctorsDetailedResponse().map(doctor, GetAllDoctorsResponse.class)).collect(Collectors.toList());
		
		return doctorsResponse;
	}

	@Override
	public GetByIdDoctorResponse getById(int id) throws Exception {
		
		if(this.doctorRepository.existsById(id) == true) {
			Doctor doctor = this.doctorRepository.findById(id).get();
			
			GetByIdDoctorResponse doctorResponse = this.modelMapperService.forDoctorDetailedResponse().map(doctor, GetByIdDoctorResponse.class);
			
			return doctorResponse;
		}else {
			throw new Exception("No doctor with this ID !");
		}

	}
	
	@Override
	public void delete(int id) throws Exception {
		
		if(this.doctorRepository.existsById(id) == true) {
			Doctor doctor = this.doctorRepository.findById(id).get();
			
			this.doctorRepository.delete(doctor);
		}else {
			throw new Exception("No doctor with this ID !");
		}
		
		
		
	}

}
