package com.ars_vc.dao;

import javax.persistence.PersistenceException;

import com.ars_vc.entity.Passenger;

public interface PassengerDao {
void savePassenger(Passenger passenger);
boolean login(String userName,String password);
Passenger getPassenger(int id);
Passenger updatePassenger(int id,Passenger passenger);
void deletePassenger(int id)throws PersistenceException;
Passenger getPassengerByEmail(String email);
}
