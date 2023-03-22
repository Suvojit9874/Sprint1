package com.ars_vc;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.hibernate.HibernateException;
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
import com.ars_vc.entity.Admin;
import com.ars_vc.entity.Passenger;
import com.ars_vc.model.AdminDTO;
import com.ars_vc.model.PassengerDTO;
import com.ars_vc.service.AdminService;
import com.ars_vc.service.PassengerService;
import com.ars_vc.serviceImpl.AdminServiceImpl;
import com.ars_vc.serviceImpl.PassengerServiceImpl;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PassengerTest{
	PassengerService pService=new PassengerServiceImpl();
	public static SessionFactory sessionFactory;
	private Session session;
	@BeforeAll
	static void setUp()
	{
		sessionFactory=HibernateUtil.getSessionFactory();
	}
@BeforeEach
void openSession()
{
	session= sessionFactory.openSession();
	}
@AfterEach
void closeSession()
{
	if(session!=null)
		session.close();
	System.out.println("session closed");
	}
@AfterAll
static void tearDown()
{
	if(sessionFactory!=null)
		sessionFactory.close();
	System.out.println("Session factory closed");
	}

//testing for Passenger registration
@Test
@Order(1)
void testRegisterPassenger()
{
	Transaction tx=session.beginTransaction();
	Passenger p=Passenger.builder().name("Nilanjan").email("nilanjan@gmail.com").UserName("nil123").password("nil@123").role("admin").phno("9831745364").build();
	Integer i=(Integer)session.save(p);
	tx.commit();
	assertThat(i>0).isTrue();
}


// testing for get Passenger
@Test
@Order(2)
void testGetPassengerById()
{
	PassengerDTO pDto=pService.getPassengerById(5);
	assertThat(pDto.getName()).isEqualTo("Nilanjan");
	
	}

//this method is use for update Passenger
@Test
@Order(3)
void testUpdatePassengerById()
{
	Transaction tx=session.beginTransaction();
	Passenger passenger=new Passenger();
	passenger.setName("Nilanjan Dasgupta");
	PassengerDTO pDto=pService.updatePassenger(5, passenger);
	tx.commit();
	assertThat(pDto.getName()).isEqualTo("Nilanjan Dasgupta");
	}

//testing for delete Passenger
@Test
@Order(4)
@DisplayName(value="Negetive Test Case")
void testDeleteAdmin()
{
	pService.deletePassenger(16);
	assertThrows(HibernateException.class,()->pService.getPassengerById(16));
	}
}