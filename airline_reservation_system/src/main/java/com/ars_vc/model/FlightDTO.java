package com.ars_vc.model;

import java.time.LocalDate;

import com.ars_vc.entity.Airline;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class FlightDTO {
	private int flight_id;
	private int avilableSeats;
	private int totalSeates;
	private String travellerClass;
	private String time;
	private LocalDate date;
	private String source;
	private String destination;
	private Airline airline;

}
