package com.bugrates.HospitalAppointmentBookingAPI.entities;

import java.time.LocalDate;


public enum Weekday { // To check if patient books an appointment on weekdays
	
	MONDAY,
	TUESDAY,
	WEDNESDAY,
	THURSDAY,
	FRIDAY;
	
	public static boolean isWeekday(LocalDate localDate) {
		
		for(Weekday day : Weekday.values()) {
    		
    		if(day.toString().equals(localDate.getDayOfWeek().toString())) {
    			return true;
    		}
    		
    	}
		
		
		return false;
	}
	

}
