package com.bugrates.HospitalAppointmentBookingAPI.core.utilities.clrunners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.bugrates.HospitalAppointmentBookingAPI.dataAccess.abstracts.UserRepository;
import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.AdminDTO.NewAdminRequest;
import com.bugrates.HospitalAppointmentBookingAPI.services.abstracts.UserService;

@Component
public class FirstAdminInit implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		if(!userRepository.existsByEmail("admin@hotmail.com")) {
			NewAdminRequest firstAdmin = new NewAdminRequest();
			firstAdmin.setFirstName("admin");
			firstAdmin.setLastName("admin");
			firstAdmin.setEmail("admin@hotmail.com");
			firstAdmin.setPassword(passwordEncoder.encode("admin"));
			
			userService.saveNewAdmin(firstAdmin);
		}
		
	
	}

}
