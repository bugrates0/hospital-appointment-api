package com.bugrates.HospitalAppointmentBookingAPI.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Table(name="users")
@Entity
public abstract class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull
	@NotBlank(message = "First name is obligatory")
	@Column(name="first_name")
	private String firstName;
	
	@NotNull
	@NotBlank(message = "Last name is obligatory")
	@Column(name="last_name")
	private String lastName;
	
	@NotNull
	@NotBlank(message = "E-Mail is obligatory")
	@Column(name="email", unique=true)
	private String email;
	
	@NotNull
	@NotBlank(message = "Password is obligatory")
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private String role;
	
	
	
	public User() {
		
	}
	

	public User(int id, String firstName, String lastName, String email, String password, String role) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	

}
