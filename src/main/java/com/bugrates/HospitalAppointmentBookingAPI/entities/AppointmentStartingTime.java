package com.bugrates.HospitalAppointmentBookingAPI.entities;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.bugrates.HospitalAppointmentBookingAPI.dataTransferObjects.AppointmentDTO.AppointmentDetailsOfDayResponse;


public enum AppointmentStartingTime {
	
	HOUR_9(LocalTime.of(9, 0)),
	HOUR_9_30(LocalTime.of(9, 30)),
	HOUR_10(LocalTime.of(10, 0)),
	HOUR_10_30(LocalTime.of(10, 30)),
	HOUR_11(LocalTime.of(11, 0)),
	HOUR_11_30(LocalTime.of(11, 30)),
	HOUR_13(LocalTime.of(13, 0)),
	HOUR_13_30(LocalTime.of(13, 30)),
	HOUR_14(LocalTime.of(14, 0)),
	HOUR_14_30(LocalTime.of(14, 30)),
	HOUR_15(LocalTime.of(15, 0)),
	HOUR_15_30(LocalTime.of(15, 30)),
	HOUR_16(LocalTime.of(16, 0)),
	HOUR_16_30(LocalTime.of(16, 30));
	
	private final LocalTime localTime;

	private AppointmentStartingTime(LocalTime localTime) {
		this.localTime = localTime;
	}

    public LocalTime getTime() {
        return localTime;
    }
    
    public static boolean isValidTime(LocalTime localTime) {
    	
    	for(AppointmentStartingTime time : AppointmentStartingTime.values()) {
    		
    		if(time.getTime().equals(localTime)) {
    			return true;
    		}
    		
    	}
    	return false;
    }
    
    public static List<AppointmentDetailsOfDayResponse> getAppointmentAvailabilityOfDay(){
    	
    	List<AppointmentDetailsOfDayResponse> appointmentDetails = new ArrayList<AppointmentDetailsOfDayResponse>();
    	
    	for(AppointmentStartingTime time: AppointmentStartingTime.values()) {
    		AppointmentDetailsOfDayResponse appointmentDetailsOfDayResponse = new AppointmentDetailsOfDayResponse();
    		appointmentDetailsOfDayResponse.setAppointmentTime(time.getTime());
    		appointmentDetailsOfDayResponse.setAppointmentStatus("AVAILABLE"); //TODO change with enum
    		appointmentDetails.add(appointmentDetailsOfDayResponse);
    	}
    	
    	return appointmentDetails;
    }

}
