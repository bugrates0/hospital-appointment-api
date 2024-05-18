package com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.AppointmentDTO;

public class AppointmentDetailsForPatientResponse {

	private int appointmentId;

	private String doctorFirstName;
	
	private String doctorLastName;

	private String appointmentDate;

	private String appointmentTime;

	public AppointmentDetailsForPatientResponse() {

	}

	public AppointmentDetailsForPatientResponse(int appointmentId, String doctorFirstName, String doctorLastName,
			String appointmentDate, String appointmentTime) {
		this.appointmentId = appointmentId;
		this.doctorFirstName = doctorFirstName;
		this.doctorLastName = doctorLastName;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}


	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public String getDoctorFirstName() {
		return doctorFirstName;
	}

	public void setDoctorFirstName(String doctorFirstName) {
		this.doctorFirstName = doctorFirstName;
	}

	public String getDoctorLastName() {
		return doctorLastName;
	}

	public void setDoctorLastName(String doctorLastName) {
		this.doctorLastName = doctorLastName;
	}

	
	
}
