package com.ars_vc.dao;

import java.time.LocalDate;

import com.ars_vc.entity.Airline;
import com.ars_vc.entity.Flight;
import com.ars_vc.entity.Passenger;
import com.ars_vc.entity.TicketBooking;

public interface TicketDAO {
	
	TicketBooking bookFlight(Airline airline,Passenger p,LocalDate date,Flight f,int no_of_passenger,float total_fare,int avilable_seat);
	void cancelBooking(int id);
	TicketBooking getTicket(int id);

}
