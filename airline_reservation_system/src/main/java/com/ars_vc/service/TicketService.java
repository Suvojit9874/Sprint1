package com.ars_vc.service;

import java.time.LocalDate;

import com.ars_vc.entity.Airline;
import com.ars_vc.entity.Flight;
import com.ars_vc.entity.Passenger;
import com.ars_vc.entity.TicketBooking;
import com.ars_vc.model.TicketBookingDTO;

public interface TicketService {
	
	TicketBookingDTO bookFlight(int flight_id,LocalDate date,String pEmail,int no_of_passenger,String airName);
	void cancelBooking(int id);
	TicketBookingDTO getTicket(int id);


}
