package com.bugrates.HospitalAppointmentBookingAPI;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HospitalAppointmentBookingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalAppointmentBookingApiApplication.class, args);
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
