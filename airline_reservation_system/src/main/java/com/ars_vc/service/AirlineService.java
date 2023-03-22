package com.ars_vc.service;

import javax.persistence.PersistenceException;

import com.ars_vc.entity.Airline;
import com.ars_vc.model.AirlineDTO;

public interface AirlineService {
	void saveAirline(Airline airline);
	void assignAirlineToFlight(int flightId,int airId);
	AirlineDTO getAirlineByName(String name);
	AirlineDTO updateAirlineById(int id,Airline airline);
	void deleteAirline(int id)throws PersistenceException;

}
