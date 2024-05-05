package com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.ClinicDTO;

import java.util.List;

import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.DoctorDTO.GetAllDoctorsResponse;

public class GetAllClinicsResponse {
	
	private int id;
	
	private String clinicName;
	
	private List<GetAllDoctorsResponse> doctors;
	
	public GetAllClinicsResponse() {
		
	}

	public GetAllClinicsResponse(int id, List<GetAllDoctorsResponse> doctors, String clinicName) {
		this.id = id;
		this.doctors = doctors;
		this.clinicName = clinicName;
	}

	public int getId() {
		return id;
	}

	public List<GetAllDoctorsResponse> getDoctors() {
		return doctors;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDoctors(List<GetAllDoctorsResponse> doctors) {
		this.doctors = doctors;
	}

	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}
	
}
