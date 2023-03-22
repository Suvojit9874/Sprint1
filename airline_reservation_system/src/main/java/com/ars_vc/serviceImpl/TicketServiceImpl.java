package com.ars_vc.serviceImpl;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;

import com.ars_vc.dao.AirlineDAO;
import com.ars_vc.dao.FlightDAO;
import com.ars_vc.dao.PassengerDao;
import com.ars_vc.dao.TicketDAO;
import com.ars_vc.daoImpl.AirlineDAOImpl;
import com.ars_vc.daoImpl.FlightDAOImpl;
import com.ars_vc.daoImpl.PassengerDaoImpl;
import com.ars_vc.daoImpl.TicketDAOImpl;
import com.ars_vc.entity.Airline;
import com.ars_vc.entity.Flight;
import com.ars_vc.entity.Passenger;
import com.ars_vc.entity.TicketBooking;
import com.ars_vc.exception.GlobalException;
import com.ars_vc.model.TicketBookingDTO;
import com.ars_vc.service.TicketService;

public class TicketServiceImpl implements TicketService{
FlightDAO fdao=new FlightDAOImpl();
AirlineDAO adao=new AirlineDAOImpl();
PassengerDao pdao=new PassengerDaoImpl();
TicketDAO tdao=new TicketDAOImpl();
	
@Override
public TicketBookingDTO bookFlight(int flight_id, LocalDate date, String pEmail, int no_of_passenger,
		String airName) {
	Flight flight=fdao.getFlight(flight_id);
	if(flight.getAvilableSeats()>no_of_passenger)
	{
		Passenger p=pdao.getPassengerByEmail(pEmail);
		Airline airline=adao.getAirlineByName(airName);
		float totalfare=airline.getFare()*no_of_passenger;
		int avilable_seat=(flight.getAvilableSeats()-no_of_passenger);
		TicketBooking bookedTicket=tdao.bookFlight(airline, p, date, flight, no_of_passenger, totalfare, avilable_seat);
	return new ModelMapper().map(bookedTicket,TicketBookingDTO.class);
	}
	return null;
}
	@Override
	public void cancelBooking(int id) {
		tdao.cancelBooking(id);
		
	}

	@Override
	public TicketBookingDTO getTicket(int id) {
		TicketBooking tick=tdao.getTicket(id);
		if(tick!=null)
			return new ModelMapper().map(tick, TicketBookingDTO.class);
	
	
	throw new GlobalException("Passenger details not exist!!!");
	}

	
	

}
