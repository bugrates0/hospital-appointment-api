
package com.bugrates.HospitalAppointmentBookingAPI.services.concretes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.bugrates.HospitalAppointmentBookingAPI.core.utilities.mappers.ModelMapperService;
import com.bugrates.HospitalAppointmentBookingAPI.dataAccess.abstracts.AppointmentRepository;
import com.bugrates.HospitalAppointmentBookingAPI.dataAccess.abstracts.UserRepository;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.AppointmentDTO.AppointmentDetailsForPatientResponse;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.AppointmentDTO.AppointmentDetailsOfDayResponse;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.AppointmentDTO.NewAppointmentRequest;
import com.bugrates.HospitalAppointmentBookingAPI.entities.Appointment;
import com.bugrates.HospitalAppointmentBookingAPI.entities.AppointmentStartingTime;
import com.bugrates.HospitalAppointmentBookingAPI.entities.User;
import com.bugrates.HospitalAppointmentBookingAPI.entities.Weekday;
import com.bugrates.HospitalAppointmentBookingAPI.services.abstracts.AppointmentService;

@Service
public class AppointmentManager implements AppointmentService {

	private ModelMapperService modelMapperService;
	private AppointmentRepository appointmentRepository;
	private UserRepository userRepository;

	@Autowired
	public AppointmentManager(AppointmentRepository appointmentRepository, UserRepository userRepository,
			ModelMapperService modelMapperService) {
		this.appointmentRepository = appointmentRepository;
		this.userRepository = userRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public void createAppointment(NewAppointmentRequest newAppointmentRequest) throws Exception {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		LocalDate newAppointmentDate;
		LocalTime newAppointmentTime;

		try {
			newAppointmentDate = LocalDate.parse(newAppointmentRequest.getAppointmentDate(),
					DateTimeFormatter.ofPattern("dd-MM-yyyy")); // 13-12-2024
		} catch (Exception e) {
			throw new Exception("Please write the appointment day like '19-05-2026' (Day/Month/Year)");
		}

		try {
			newAppointmentTime = LocalTime.parse(newAppointmentRequest.getAppointmentTime(),
					DateTimeFormatter.ofPattern("HH:mm")); // 10:30
		} catch (Exception e) {
			throw new Exception("Please write the appointment time like '11:30'");
		}

		if (newAppointmentDate.isEqual(LocalDate.now()) == true // Appointment day is not today
				|| newAppointmentDate.isAfter(LocalDate.now()) == false // Appointment day is not a past day
				|| AppointmentStartingTime.isValidTime(newAppointmentTime) == false // Appointment time is valid
				|| Weekday.isWeekday(newAppointmentDate) == false) { // Appointment day is a week day (not weekend)
			throw new Exception("Please choose a valid time and date!");
		} else {

			UserDetails userDetails = (UserDetails) authentication.getPrincipal();

			User doctor = this.userRepository.findById(newAppointmentRequest.getDoctorId()).get();
			User patient = this.userRepository.findByEmail(userDetails.getUsername()).get();

			if (!doctor.getRole().equals("DOCTOR")) {
				throw new Exception("Doctor ID is wrong !");
			}

			if (doctor.getId() == patient.getId()) {
				throw new Exception("You can not book a reservation from you !");
			}

			// If Doctor-Day-Time and Patient-Day-Time constraints are appropriate
			// then create an appointment (to avoid unused id's in database)
			if (this.appointmentRepository.getAppointmentAlreadyExistsOfDoctor(doctor.getId(),
					newAppointmentDate.toString(), newAppointmentTime.toString()) == null
					&& this.appointmentRepository.getAppointmentAlreadyExistsOfPatient(patient.getId(),
							newAppointmentDate.toString(), newAppointmentTime.toString()) == null) {

				// TODO implement a proper modelmapper method

				Appointment appointment = new Appointment();

				appointment.setDoctor(doctor);
				appointment.setPatient(patient);
				appointment.setAppointmentDate(newAppointmentDate);
				appointment.setAppointmentTime(newAppointmentTime);

				this.appointmentRepository.save(appointment);
			} else {
				throw new Exception("Appointment not available!");
			}

		}

	}

	@Override
	public List<AppointmentDetailsOfDayResponse> checkAllAppointments(String date, int doctorId) throws Exception {

		LocalDate appointmentDate;

		try {
			appointmentDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy")); // 13-12-2024
		} catch (Exception e) {
			throw new Exception("Please write the appointment day like '19-05-2026' (Day/Month/Year)");
		}

		if (appointmentDate.isEqual(LocalDate.now()) == true // Appointment day is not today
				|| appointmentDate.isAfter(LocalDate.now()) == false // Appointment day is not a past day
				|| Weekday.isWeekday(appointmentDate) == false) { // Appointment day is a week day (not weekend)
			throw new Exception("Please choose a valid time and date!");
		} else {

			List<Appointment> appointments = this.appointmentRepository
					.getAllAppointmentsOfDay(appointmentDate.toString(), doctorId);

			List<AppointmentDetailsOfDayResponse> appointmentsInDB = appointments.stream()
					.map(appointment -> this.modelMapperService.forAppointmentDetailsOfDayResponse().map(appointment,
							AppointmentDetailsOfDayResponse.class))
					.collect(Collectors.toList());

			List<AppointmentDetailsOfDayResponse> appointmentsResponse = AppointmentStartingTime
					.getAppointmentAvailabilityOfDay();

			for (int i = 0; i < appointmentsResponse.size(); i++) {
				for (int y = 0; y < appointmentsInDB.size(); y++) {
					if (appointmentsResponse.get(i).getAppointmentTime() == appointmentsInDB.get(y)
							.getAppointmentTime()) {
						appointmentsResponse.get(i).setAppointmentStatus("BOOKED");
					}
				}
			}

			return appointmentsResponse;

		}

	}

	@Override
	public List<AppointmentDetailsForPatientResponse> getAllMyFutureAppointments() throws Exception {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		User patient = this.userRepository.findByEmail(userDetails.getUsername()).get();

		List<Appointment> myAppointments = this.appointmentRepository
				.getAllMyFutureAppointments(LocalDate.now().toString(), patient.getId());
		
		List<AppointmentDetailsForPatientResponse> myAppointmentsResponse = myAppointments.stream()
				.map(appointment -> this.modelMapperService.forAppointmentDetailsForPatientResponse().map(appointment,
						AppointmentDetailsForPatientResponse.class))
				.collect(Collectors.toList());
		
		return myAppointmentsResponse;

	}

	@Override
	public void cancelAppointment(int appointmentId) throws Exception {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		User patient = this.userRepository.findByEmail(userDetails.getUsername()).get();
		
		Appointment appointment;
		
		try {
			appointment = this.appointmentRepository.findById(appointmentId).get();
		}catch(Exception e) {
			throw new Exception("Couldn't find the appointment !");
		}
		
		if(patient.getEmail() == appointment.getPatient().getEmail()) {
			
			if (appointment.getAppointmentDate().isEqual(LocalDate.now()) == true // Appointment day is not today
					|| appointment.getAppointmentDate().isAfter(LocalDate.now()) == false // Appointment day is not a past day
					|| Weekday.isWeekday(appointment.getAppointmentDate()) == false) { // Appointment day is a week day (not weekend)
				throw new Exception("Please choose a valid time and date!");
			} else {
				this.appointmentRepository.delete(appointment);
			}
			
			
		}else {
			throw new Exception("Wrong Appointment ID !");
		}
		
		
		
	}

}
