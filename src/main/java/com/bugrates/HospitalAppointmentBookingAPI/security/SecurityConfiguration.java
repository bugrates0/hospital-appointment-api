package com.bugrates.HospitalAppointmentBookingAPI.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.bugrates.HospitalAppointmentBookingAPI.services.concretes.UserManager;

@Configuration 	
@EnableWebSecurity 
public class SecurityConfiguration {
	
	@Autowired
	private UserManager userManager;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

		 httpSecurity
				.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(registry->{
			registry.requestMatchers("api/register").permitAll();
			registry.requestMatchers("api/register/admin").hasRole("ADMIN");
			registry.requestMatchers("api/register/doctor").hasRole("ADMIN");
			registry.requestMatchers("api/patient/**").hasRole("PATIENT");
			registry.requestMatchers("api/clinics").permitAll();
			registry.requestMatchers("api/appointments").hasRole("PATIENT");
			registry.requestMatchers("api/appointments/**").hasRole("PATIENT");
			registry.requestMatchers("api/admin/**").hasRole("ADMIN");
			registry.requestMatchers("api/doctor/**").hasRole("DOCTOR");
			registry.anyRequest().authenticated();
		}).httpBasic(Customizer.withDefaults());
		 
		 return httpSecurity.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService (){
		return userManager;
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userManager);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
	
	
	
	@Bean
	public PasswordEncoder passwordEncoder (){
		return new BCryptPasswordEncoder();
	}

}
