package com.bugrates.HospitalAppointmentBookingAPI.core.utilities.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.AppointmentDTO.AppointmentDetailsForPatientResponse;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.AppointmentDTO.AppointmentDetailsOfDayResponse;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.DoctorDTO.GetAllDoctorsResponse;
import com.bugrates.HospitalAppointmentBookingAPI.entities.Appointment;
import com.bugrates.HospitalAppointmentBookingAPI.entities.Doctor;

@Service
public class ModelMapperManager implements ModelMapperService {

	private ModelMapper modelMapper;

	@Autowired
	public ModelMapperManager(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public ModelMapper forResponse() {
		this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
		return this.modelMapper;
	}

	@Override
	public ModelMapper forRequest() {
		this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD);
		return this.modelMapper;
	}

	@Override
	public ModelMapper forDoctorsDetailedResponse() {
		this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
		this.modelMapper.typeMap(Doctor.class, GetAllDoctorsResponse.class).addMappings(
				m -> m.map(doctor -> doctor.getClinic().getClinicName(), GetAllDoctorsResponse::setClinicName));
		this.modelMapper.typeMap(Doctor.class, GetAllDoctorsResponse.class)
				.addMappings(m -> m.map(doctor -> doctor.getClinic().getId(), GetAllDoctorsResponse::setClinicId));
		return this.modelMapper;

	}

	@Override
	public ModelMapper forAppointmentDetailsOfDayResponse() {
		this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
		this.modelMapper.typeMap(Appointment.class, AppointmentDetailsOfDayResponse.class).addMappings(
				m -> m.map(appointment -> appointment.getAppointmentTime(), AppointmentDetailsOfDayResponse::setAppointmentTime));
		return this.modelMapper;
	}

	
	@Override
	public ModelMapper forAppointmentDetailsForPatientResponse() {
		this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
		this.modelMapper.typeMap(Appointment.class, AppointmentDetailsForPatientResponse.class).addMappings(
				m -> m.map(appointment -> appointment.getId(), AppointmentDetailsForPatientResponse::setAppointmentId));
		this.modelMapper.typeMap(Appointment.class, AppointmentDetailsForPatientResponse.class).addMappings(
				m -> m.map(appointment -> appointment.getDoctor().getFirstName(), AppointmentDetailsForPatientResponse::setDoctorFirstName));
		this.modelMapper.typeMap(Appointment.class, AppointmentDetailsForPatientResponse.class).addMappings(
					m -> m.map(appointment -> appointment.getDoctor().getLastName(), AppointmentDetailsForPatientResponse::setDoctorLastName));
		this.modelMapper.typeMap(Appointment.class, AppointmentDetailsForPatientResponse.class).addMappings(
				m -> m.map(appointment -> appointment.getFormattedAppointmentDate(), AppointmentDetailsForPatientResponse::setAppointmentDate));
		this.modelMapper.typeMap(Appointment.class, AppointmentDetailsForPatientResponse.class).addMappings(
				m -> m.map(appointment -> appointment.getFormattedAppointmentTime(), AppointmentDetailsForPatientResponse::setAppointmentTime));
		return this.modelMapper;
	}
	
}
