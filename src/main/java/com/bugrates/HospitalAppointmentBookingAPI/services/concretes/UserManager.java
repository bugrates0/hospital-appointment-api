package com.bugrates.HospitalAppointmentBookingAPI.services.concretes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bugrates.HospitalAppointmentBookingAPI.core.utilities.mappers.ModelMapperService;
import com.bugrates.HospitalAppointmentBookingAPI.dataAccess.abstracts.ClinicRepository;
import com.bugrates.HospitalAppointmentBookingAPI.dataAccess.abstracts.UserRepository;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.AdminDTO.NewAdminRequest;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.DoctorDTO.NewDoctorRequest;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.PatientDTO.NewPatientRequest;
import com.bugrates.HospitalAppointmentBookingAPI.entities.Admin;
import com.bugrates.HospitalAppointmentBookingAPI.entities.Doctor;
import com.bugrates.HospitalAppointmentBookingAPI.entities.Patient;
import com.bugrates.HospitalAppointmentBookingAPI.entities.User;
import com.bugrates.HospitalAppointmentBookingAPI.services.abstracts.UserService;

@Service
public class UserManager implements UserService, UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ClinicRepository clinicRepository;

	@Autowired
	private ModelMapperService modelMapperService;

	// Authentication using email not username!!
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Optional<User> user = userRepository.findByEmail(email);

		if (user.isPresent()) {
			var userObj = user.get();
			return org.springframework.security.core.userdetails.User.builder().username(userObj.getEmail())
					.password(userObj.getPassword()).roles(getRoles(userObj)).build();
		} else {
			throw new UsernameNotFoundException(email);
		}
	}

	private String[] getRoles(User user) {
		return user.getRole().split(",");
	}

	@Override
	public void saveNewPatient(NewPatientRequest newPatientRequest) throws Exception {
		if (this.userRepository.existsByEmail(newPatientRequest.getEmail()) == false) {
			Patient newPatient = this.modelMapperService.forRequest().map(newPatientRequest, Patient.class);
			newPatient.setRole("PATIENT"); // TODO Change with roles enum !
			this.userRepository.save(newPatient);
		} else {
			throw new Exception("E-Mail already exists!");
		}
	}

	@Override
	public void saveNewAdmin(NewAdminRequest newAdminRequest) throws Exception {
		if (this.userRepository.existsByEmail(newAdminRequest.getEmail()) == false) {
			Admin newAdmin = this.modelMapperService.forRequest().map(newAdminRequest, Admin.class);
			newAdmin.setRole("ADMIN"); // TODO Change with roles enum !
			this.userRepository.save(newAdmin);
		} else {
			throw new Exception("E-Mail already exists!");
		}
	}

	@Override
	public void saveNewDoctor(NewDoctorRequest newDoctorRequest) throws Exception {
		if (this.userRepository.existsByEmail(newDoctorRequest.getEmail()) == false) {

			if (this.clinicRepository.existsById(newDoctorRequest.getClinicId()) == true) {
				Doctor newDoctor = this.modelMapperService.forRequest().map(newDoctorRequest, Doctor.class);
				newDoctor.setRole("DOCTOR"); // TODO Change with roles enum !
				this.userRepository.save(newDoctor);
			}else {
				throw new Exception("Clinic ID is wrong !");
			}

		} else {
			throw new Exception("E-Mail already exists!");
		}
	}

	@Override
	public void deleteAccount(int id) throws Exception {
		if (this.userRepository.existsById(id) == true) {
			User user = this.userRepository.findById(id).get();

			this.userRepository.delete(user);
		} else {
			throw new Exception("No account with this ID !");
		}

	}

}
