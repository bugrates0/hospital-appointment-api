package com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.DoctorDTO;


public class GetAllDoctorsResponse {
	
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private int clinicId;
	
	private String clinicName;
	
	public GetAllDoctorsResponse() {
	}

	public GetAllDoctorsResponse(int id, String firstName, String lastName, String email, int clinicId, String clinicName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.clinicId = clinicId;
		this.clinicName = clinicName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getClinicId() {
		return clinicId;
	}

	public void setClinicId(int clinicId) {
		this.clinicId = clinicId;
	}

	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	

}
