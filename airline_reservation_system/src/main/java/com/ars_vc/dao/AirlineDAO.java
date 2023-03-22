package com.ars_vc.dao;

import javax.persistence.PersistenceException;

import com.ars_vc.entity.Airline;

public interface AirlineDAO {
	void saveAirline(Airline airline);
	void assignAirlineToFlight(int flightId,int airId);
	Airline getAirlineByName(String name);
	Airline updateAirlineById(int id,Airline airline);
	void deleteAirline(int id)throws PersistenceException;
	

}
