package com.ars_vc;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

import com.ars_vc.entity.Airline;
import com.ars_vc.model.AirlineDTO;
import com.ars_vc.entity.Admin;
import com.ars_vc.entity.Flight;
import com.ars_vc.entity.Passenger;
import com.ars_vc.entity.TicketGenerationPdf;
import com.ars_vc.model.AdminDTO;
import com.ars_vc.model.FlightDTO;
import com.ars_vc.model.PassengerDTO;
import com.ars_vc.model.TicketBookingDTO;
import com.ars_vc.service.AdminService;
import com.ars_vc.service.AirlineService;
import com.ars_vc.service.FlightService;
import com.ars_vc.service.PassengerService;
import com.ars_vc.service.TicketService;
import com.ars_vc.serviceImpl.AdminServiceImpl;
import com.ars_vc.serviceImpl.AirlineServiceImpl;
import com.ars_vc.serviceImpl.FlightServiceImpl;
import com.ars_vc.serviceImpl.PassengerServiceImpl;
import com.ars_vc.serviceImpl.TicketServiceImpl;

public class CrudOperation {
	static AdminService aservice=new AdminServiceImpl();
	static PassengerService pservice=new PassengerServiceImpl();
	static FlightService fService=new FlightServiceImpl();
	static AirlineService aService=new AirlineServiceImpl();
	static TicketService tService=new TicketServiceImpl();
	static Scanner sc=new Scanner(System.in);
	//this method is responsible for CRUD of admin
	public static void crudAdmin()
	{
		String xx;
		while(true)
		{
			System.out.println("==================================================");
			System.out.println("Press r for read admin\nPress u for update admin"
					+ "\nPress d for delete admin\n Press q for quit");
			System.out.println("===================================================");
			xx=JOptionPane.showInputDialog("Enter choice","type here");
			switch(xx)
			{
			case "r":
				try {
					AdminDTO aDto=aservice.getAdminById(Integer.parseInt(JOptionPane.showInputDialog("Enter admin id","type here")));
					System.out.println("Admin detalis");
					System.out.println("id: "+aDto.getId());
					System.out.println("name: "+aDto.getAName());
					System.out.println("Email: "+aDto.getEmail());
				}catch (Exception e) {
					System.out.println(e);
				}
				break;
			case "u":
				Admin admin=new Admin();
				String name=JOptionPane.showInputDialog("Enter name","Type here");
				String email=JOptionPane.showInputDialog("Enter email","Type here");
				String uname=JOptionPane.showInputDialog("Enter Username","Type here");
				String pass=JOptionPane.showInputDialog("Enter password","Type here");
				admin.setAName(name);
				admin.setEmail(email);
				admin.setUserName(uname);
				admin.setPassword(pass);
				
				AdminDTO upAdmin=aservice.updateAdmin(Integer.parseInt(JOptionPane.showInputDialog("enter admin id to update")), admin);
				System.out.println("Admin updated successfully");
			break;
			case "d":
				try {
					aservice.deleteAdmin(Integer.parseInt(JOptionPane.showInputDialog("Enter the admin id to delete","type here")));
					
				}catch (PersistenceException e) {
					System.out.println(e.getMessage());
				}
				break;
			case "q":
				AdminOperation();
				break;
				
			}// end of switch
		}//end of while
	}//end of CRUD admin
	
	// this method is responsible for CRUD of Passenger
	public static void crudPassenger()
	{
		String xx;
		while(true) {
		System.out.println("============================================================================");
System.out.println( "Press r. for read Passenger details\n Press u.for update Passenger details\n Press d.for delete Passenger details\n"
		+ " Press q for quit");
System.out.println("============================================================================");
 xx=JOptionPane.showInputDialog("Enter choice","Type here");

 switch(xx) {
 

 case "r":

	try {

	
		PassengerDTO pDto=pservice.getPassengerById(Integer.parseInt(JOptionPane.showInputDialog("Enter id", "type here")));
		System.out.println("Passenger details: ");
		System.out.println("Id: "+pDto.getId());
		System.out.println("Name: "+pDto.getName());
        System.out.println("Ph. No: "+pDto.getPhno());
        System.out.println("Email: "+pDto.getEmail());
	}
	catch (Exception e) {
		System.out.println(e);
	}
	
break;
	
 case "u":
	 
	Passenger passenger=new Passenger();
	String name=JOptionPane.showInputDialog("Enter name for Update:","Type here");
	String email=JOptionPane.showInputDialog("Enter email for Update:","Type here");
	String phno=JOptionPane.showInputDialog("Enter Phone Number for Update:","Type here");
	String uname=JOptionPane.showInputDialog("Enter user_name for Update:","Type here");
	String pass=JOptionPane.showInputDialog("Enter password for Update:","Type here");
	
	passenger.setName(name);
	passenger.setEmail(email);
	passenger.setPhno(phno);
	passenger.setUserName(uname);
	passenger.setPassword(pass);
	
	PassengerDTO upPass=pservice.updatePassenger(Integer.parseInt(JOptionPane.showInputDialog("enter id to update", "type here")),
			passenger);
	System.out.println("Passenger updated successfully");
break;	

 case "d":
	 try {
	pservice.deletePassenger(Integer.parseInt(JOptionPane.showInputDialog("enter id to delete", "type here")));
	JOptionPane.showMessageDialog(null, "Object is deleted!!!!");
	 }catch(PersistenceException e)
	 {
		 System.out.println(e.getMessage());
	 }
	 break;

 case "q":
	 crudOperation();
	 break;

 }//end of switch
		}
	} //crud passenger
	
	//this method is resposible for CRUD Flight
	public static void crudFlight()
	{
		String xx;
		while(true) {
		System.out.println("============================================================================");
System.out.println( "Press c. for create Flight details\n Press r.for read Flight details\n Press u.for update Flight details\nPress d.for delete flight details\n"
		+ " Press q for quit");
System.out.println("============================================================================");
 xx=JOptionPane.showInputDialog("Enter choice","Type here");

 switch(xx) {
 case "c":
		Flight flight=new Flight();
		System.out.println("Enter available seats: ");
		int aseat=sc.nextInt();
		System.out.println("Enter Total seats: ");
		int tseat=sc.nextInt();
		sc.nextLine();
		System.out.println("Enetr traveller class: ");
		String tclass=sc.nextLine();
		System.out.println("Enter the time: ");
		String t=sc.nextLine();
		System.out.println("Enter the date: ");
		String d=sc.nextLine();
		LocalDate date1=LocalDate.parse(d);
		System.out.println("Enter the source: ");
		String fsource=sc.nextLine();
		System.out.println("enter the destination: ");
		String dest=sc.nextLine();
		
		flight.setAvilableSeats(aseat);
		flight.setTotalSeats(tseat);
		flight.setTravellerClass(tclass);
		flight.setTime(t);
		flight.setDate(date1);
		flight.setSource(fsource);
		flight.setDestination(dest);
		fService.saveFlight(flight);
		System.out.println("Flight added successfully");
		break;
		
 case "r":
	 try {
		 int id;
		 System.out.println("enter id: ");
		 id=sc.nextInt();
		 FlightDTO fDto=fService.getFlight(id);
		 System.out.println("Flight Id: "+fDto.getFlight_id());
		 System.out.println("Avilable seats: "+fDto.getAvilableSeats());
		 System.out.println("Total seats: "+fDto.getTotalSeates());
		 System.out.println("Date "+fDto.getDate());
		 System.out.println("Time: "+fDto.getTime());
		 System.out.println("Source: "+fDto.getSource());
		 System.out.println("Destination: "+fDto.getDestination());
		 System.out.println("Traveller class: "+fDto.getTravellerClass());
		 System.out.println("Airline id: "+fDto.getAirline());
		
	} catch (Exception e) {
		System.out.println(e);
	}
	 break;
	 
 case "u":
		Flight flight1=new Flight();
		int aSeat=Integer.parseInt(JOptionPane.showInputDialog("Enter Available seats","type here"));
		int tSeat=Integer.parseInt(JOptionPane.showInputDialog("Enter Total seats","type here"));
		String d1=JOptionPane.showInputDialog("Enter Date","type here");
		LocalDate date=LocalDate.parse(d1);
		String time=JOptionPane.showInputDialog("Enter Time","type here");
		String source=JOptionPane.showInputDialog("Enter Source","type here");
		String destination=JOptionPane.showInputDialog("Enter Destination","type here");
		String tClass=JOptionPane.showInputDialog("Enter Traveller Class","type here");
		flight1.setAvilableSeats(aSeat);
		flight1.setTotalSeats(tSeat);
		flight1.setTravellerClass(tClass);
		flight1.setTime(time);
		flight1.setDate(date);
		flight1.setSource(source);
		flight1.setDestination(destination);
		
		FlightDTO upFlight=fService.updateFlight(Integer.parseInt(JOptionPane.showInputDialog("Enter Flight ID")), flight1);
		System.out.println("Flight updated successfully");
		break;
		
	case "d":
		try
		{
			fService.deleteFlight(Integer.parseInt(JOptionPane.showInputDialog("Enter Flight ID to delete","type here")));
			
		}catch (PersistenceException e) {
			System.out.println(e.getMessage());
		}
		break;
	case "q":
		AdminOperation();
		break;
	}//end of switch
 }//end of loop

}//end of crud flight
	
	//this method is responsible to assign flights to airline
	public static void assignAirlineToFlight()
	{
		System.out.println("enter the flight id: ");
		int f_id=sc.nextInt();
		System.out.println("enter the airline id: ");
		int a_id=sc.nextInt();
		aService.assignAirlineToFlight(f_id, a_id);
		System.out.println("flight assign to airline successfully");	
	}
	
	//this method is responsible to perform crud opr of airline
		public static void crudAirline()
		{
			String in;
			while(true)
			{
				System.out.println("===============================================");
				System.out.println("Press c.for add Airline\nPress r for get airline details\npress u for update airline\npress d for delete airline\npress q for quit");
				System.out.println("===============================================");
				in=sc.nextLine();
				switch(in)
				{
				case "c":
					Airline airline=new Airline();
					System.out.println("Enter the airline name: ");
					String a_name=sc.nextLine();
					System.out.println("Enter the fare: ");
					float a_fare=sc.nextFloat();
					airline.setAirlineName(a_name);
					airline.setFare(a_fare);
					aService.saveAirline(airline);
					System.out.println("Airline saved successfully");
					break;
				case "r":
					try {
						String name;
						System.out.println("Enter Airline Name :- ");
						name=sc.nextLine();
						AirlineDTO aDto=aService.getAirlineByName(name);
						System.out.println("Airline details: ");
						System.out.println("Airline Name :- "+aDto.getAirlineName());
						System.out.println("Fare :- "+aDto.getFare());
						System.out.println("Airline Id :- "+aDto.getId());
				        
					}
					catch (Exception e) {
						System.out.println(e);
					}
					break;
				case "u":
					Airline airline_up=new Airline();
					System.out.println("Enter the airline name: ");
					String au_name=sc.nextLine();
					System.out.println("Enter the fare: ");
					float au_fare=sc.nextFloat();
					airline_up.setAirlineName(au_name);
					airline_up.setFare(au_fare);
					AirlineDTO upairline=aService.updateAirlineById(Integer.parseInt(JOptionPane.showInputDialog("Enter Airline id to update","type here")),airline_up);
					System.out.println("Flight updated successfully");
				break;
				case "d":
					try {
						aService.deleteAirline(Integer.parseInt(JOptionPane.showInputDialog("Enter Airline id to delete","type here")));
						JOptionPane.showMessageDialog(null, "Airline is deleted");
					} catch (PersistenceException e) {
						System.out.println(e.getMessage());
					}
					break;
				case "q":
					AdminOperation();
					break;
				}//end of switch
				
			}//end of while loop
		}
		//this method is responsible for book flights
		public static void bookFlight()
		{
			List<Flight> flights=fService.checkFlight(JOptionPane.showInputDialog("Enter from","type here"), JOptionPane.showInputDialog("Enter to","type here"), LocalDate.parse(JOptionPane.showInputDialog("Enter Date","type here")));
		System.out.println("Flight id:\tAirline Name\tFrom\tTo\tFare\tTiming\tDate");
		for(Flight flight:flights)
		{
			System.out.println(flight.getFlight_id()+"\t\t"+flight.getAirline().getAirlineName()
					+"\t\t"+flight.getSource()+"\t\t"+flight.getDestination()+"\t\t"+flight.getTime()+"\t\t"+flight.getDate());
		}
		System.out.println("For booking press Yes");
		String choice=JOptionPane.showInputDialog("Enter here","type here");
		
		if(choice.equalsIgnoreCase("yes"))
		{
			int flight_id=Integer.parseInt(JOptionPane.showInputDialog("Enter flight Id","type here"));
			int no_of_passenger=Integer.parseInt(JOptionPane.showInputDialog("Enter number of passenger","type here"));
			LocalDate date=LocalDate.parse(JOptionPane.showInputDialog("enter date","type here"));
			String pEmail=JOptionPane.showInputDialog("Enter passenger email","type here");
			String airName=JOptionPane.showInputDialog("Enter airline Name","Type here");
			TicketBookingDTO ticketDTO=tService.bookFlight(flight_id, date, pEmail, no_of_passenger, airName);
			System.out.println("Your booking has done successfully");
			TicketGenerationPdf.ticketGeneration(ticketDTO);
		}
		}
		
		//this method lets you print your boarding pass
		public static void boardingPass()
		{
			System.out.println();
			TicketBookingDTO tDto=tService.getTicket(Integer.parseInt(JOptionPane.showInputDialog("enter ticket id","type here")));
			System.out.println("=========================================================");
			System.out.println("Airways: "+tDto.getAid().getAirlineName()+"\t\tBOARDING PASS");
			System.out.println("Ticket No: "+tDto.getTicketId());
			System.out.println("Name: "+tDto.getPid().getName()+"\tNo_of_passengers "+tDto.getNo_of_passenger());
			System.out.println("from "+tDto.getFid().getSource()+"\t\t To: "+tDto.getFid().getDestination());
			System.out.println("Flight: "+tDto.getFid().getFlight_id()+"\t\tDate: "+tDto.getFid().getDate());
			System.out.println("=========================================================");
		}
public static void checkFlights()
{
	List<Flight> flights=fService.checkFlight(JOptionPane.showInputDialog("Enter from","type here"), JOptionPane.showInputDialog("Enter to","type here"), LocalDate.parse(JOptionPane.showInputDialog("Enter Date","type here")));
	System.out.println("Flight id:\tAirline Name\tFrom\tTo\tFare\tTiming\tDate");
	for(Flight flight:flights)
	{
		System.out.println(flight.getFlight_id()+"\t\t"+flight.getAirline().getAirlineName()
				+"\t\t"+flight.getSource()+"\t\t"+flight.getDestination()+"\t\t"+flight.getTime()+"\t\t"+flight.getDate());
	}
	
	}

//sub menu to choose menu
public static void crudOperation()
{
	int input;
	while(true)
	{
		System.out.println("=====================================");
		System.out.println("1. passenger details\n2.Check flights"
				+ "\n3.Book flights\n4.Cancel booking\n5.get boarding pass\n6.quit");
		input=Integer.parseInt(JOptionPane.showInputDialog("enter choice","type here"));
		System.out.println("=====================================");
		switch(input)
		{
		case 1:
			crudPassenger();
			break;
		case 2:
			checkFlights();
			break;
		case 3:
			bookFlight();
			break;
		case 4:
			System.out.println("enter your ticket id: ");
			int id=sc.nextInt();
			tService.cancelBooking(id);
			JOptionPane.showMessageDialog(null, "object is deleted");
			break;
		case 5:
			boardingPass();
			break;
		case 6:
			App.mainMenu();
		}
	}
	}
public static void AdminOperation()
{
	int input;
	while(true)
	{
		System.out.println("============================================");
		System.out.println("1.Flight details\n2.Airline details\n3.add flight to airline\n4.admincrud\n5.quit");
		input=Integer.parseInt(JOptionPane.showInputDialog("Enter choice","type here"));
		System.out.println("============================================");
		switch(input)
		{
		case 1:
			crudFlight();
			break;
		case 2:
			crudAirline();
			break;
		case 3:
			assignAirlineToFlight();
			break;
		case 4:
			crudAdmin();
			break;
		case 5:
			App.mainMenu();
			break;
		}
		
	}
	}
	
	}
