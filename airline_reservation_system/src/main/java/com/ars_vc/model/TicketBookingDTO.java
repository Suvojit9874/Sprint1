package com.ars_vc.model;

import java.time.LocalDate;
import java.util.Date;


import com.ars_vc.entity.Airline;
import com.ars_vc.entity.Flight;
import com.ars_vc.entity.Passenger;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class TicketBookingDTO {
	
	private int ticketId;
	private int no_of_passenger;
	private double totalFare;
	private LocalDate date;
	private Flight fid;
	private Airline aid;
	private Passenger pid;

}
