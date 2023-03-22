package com.ars_vc;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.ars_vc.config.HibernateUtil;
import com.ars_vc.entity.Flight;
import com.ars_vc.exception.GlobalException;
import com.ars_vc.model.FlightDTO;
import com.ars_vc.service.AirlineService;
import com.ars_vc.service.FlightService;
import com.ars_vc.serviceImpl.AirlineServiceImpl;
import com.ars_vc.serviceImpl.FlightServiceImpl;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FlightTest {
	FlightService flightService = new FlightServiceImpl();
	AirlineService airlineService = new AirlineServiceImpl();
	
	
	private static SessionFactory sessionFactory;
	private Session session;
	
	@BeforeAll
	static void setUp()
	{
		sessionFactory=HibernateUtil.getSessionFactory();
	}
	
	@BeforeEach
	 void OpenSession()
	{
		session=sessionFactory.openSession();
	}
	
	@AfterEach
	void closeSession()
	{
		if(session!= null)
			session.close();
		System.out.println("Session closed");
	}
	
	@AfterAll
	static void tearDown()
	{
		if(sessionFactory!=null)
			sessionFactory.close();
		System.out.println("Session factory closed");
	}
	//testing for save flight
	@Test
	@Order(1)
	void testSaveFlight()
	{
		Transaction tx = session.beginTransaction();
		Flight flight = Flight.builder().avilableSeats(150).totalSeats(200).travellerClass("business").time("18:30").date(LocalDate.parse("2022-10-26")).destination("Mumbai").source("Mangalore").build();
		Integer i = (Integer) session.save(flight);
		tx.commit();
		assertThat(i>0).isTrue();
	}
	//testing for update flight
	@Test
	@Order(3)
	void testUpdateFlightUsingService()
	{
		Transaction tx=session.beginTransaction();
		Flight fl=new Flight();
		fl.setAvilableSeats(160);
		fl.setTotalSeats(200);
		fl.setTravellerClass("Economy");
		fl.setTime("18:00");
		fl.setDestination("Kolkata");
		fl.setSource("Mumbai");
		fl.setDate(LocalDate.parse("2022-10-22"));
		
		FlightDTO fdto=flightService.updateFlight(7, fl);
		tx.commit();
		assertThat(fdto.getFlight_id()).isEqualTo(7);
	}
	//testing for get flight by name
	@Test
	@DisplayName("Positive test case")
	@Order(2)
	void testGetFlightNameById1()
	{
		FlightDTO fdto = flightService.getFlight(7);
		assertThat(fdto.getFlight_id()).isEqualTo(7);
		
	}
	//testing for delete flight
	@Test
	@Order(4)
	void testDeleteFlight()
{
		flightService.deleteFlight(7);
		assertThrows(GlobalException.class,()-> flightService.getFlight(7));
	}
	
//	testing for get flight by name for negetive test case
	@Test
	@DisplayName("Negetive test case")
	@Order(5)
	void testGetFlightNameById()
	{
		FlightDTO fdto = flightService.getFlight(8);
		assertThat(fdto.getFlight_id()).isEqualTo(8);
	}
}