package com.ars_vc;

import java.util.Scanner;

import javax.swing.JOptionPane;

import com.ars_vc.entity.Admin;
import com.ars_vc.entity.Passenger;
import com.ars_vc.model.PassengerDTO;
import com.ars_vc.service.AdminService;
import com.ars_vc.service.PassengerService;
import com.ars_vc.serviceImpl.AdminServiceImpl;
import com.ars_vc.serviceImpl.PassengerServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	mainMenu();
       }
    static Scanner sc=new Scanner(System.in);
    //main menu
    public static void mainMenu()
    {
    	System.out.println("Press A for Admin\nPress U for Passenger\nPress Q for quit");
    	String choice=JOptionPane.showInputDialog("Enter choice","Type here");
    	switch(choice)
    	{
    	case "A":
    		mainAdmin();
    		break;
    	case "U":
    		mainUser();
    		break;
    	case "Q":
    		System.exit(0);
    	}
    }
    //this method responsible for registration and login of Admin
    public static void mainAdmin()
    {
    	AdminService aService=new AdminServiceImpl();
    	String choice;
    	while(true)
    	{
    		System.out.println("Press R for Registration\nPress L for login\nPress Q for exit");
    		choice=JOptionPane.showInputDialog("enter choice","type here");
    		switch (choice) {
			case "R":
				Admin admin=new Admin();
				System.out.println("Enter Name: ");
				String ad_name=sc.nextLine();
				System.out.println("Enter email: ");
				String ad_email=sc.nextLine();
				System.out.println("Enter username: ");
				String ad_uname=sc.nextLine();
				System.out.println("Enter the password: ");
				String ad_pass=sc.nextLine();
				System.out.println("Enter the role: ");
				String ad_role=sc.nextLine();
				
				admin.setAName(ad_name);
				admin.setEmail(ad_email);
				admin.setUserName(ad_uname);
				admin.setPassword(ad_pass);
				admin.setRole(ad_role);
				aService.registerAdmin(admin);
				System.out.println("Admin registration done successfully");
				break;
			case "L":
				boolean status=aService.loginAdmin(JOptionPane.showInputDialog("enter the username","type here"),JOptionPane.showInputDialog("enter the password","type here"));
				if(status==true)
					CrudOperation.AdminOperation();
				else 
					System.out.println("Invalid credential");
				System.exit(0);
				break;
			case "Q":
				mainMenu();
			}
    		
    	}
    }
    //this method is responsible for registration and login passenger
    public static void mainUser()
    {
    	PassengerService pservice=new PassengerServiceImpl();
    	String choice;
    	while(true)
    	{
    		System.out.println("Press R for Registration\nPress L for Login\nPress Q for exit");
    		choice=JOptionPane.showInputDialog("enter choice","type here");
    		switch(choice)
    		{
    		case "R":
    			Passenger passenger1=new Passenger();
    			System.out.println("Enter name: ");
    			String p_name=sc.nextLine();
    			System.out.println("enter the email: ");
    			String p_email=sc.nextLine();
    			System.out.println("enter the user name");
    			String p_uname=sc.nextLine();
    			System.out.println("Enter the password: ");
    			String p_pass=sc.nextLine();
    			System.out.println("Enter the role: ");
    			String p_role=sc.nextLine();
    			System.out.println("enter the phone number: ");
    			String p_ph=sc.nextLine();
    			passenger1.setName(p_name);
    			passenger1.setEmail(p_email);
    			passenger1.setPhno(p_ph);
    			passenger1.setUserName(p_uname);
    			passenger1.setPassword(p_pass);
    			passenger1.setRole(p_role);
    			
    			pservice.savePassenger(passenger1);
    			System.out.println("passenger Registration done successfully");
    			break;
    		case "L":
    			boolean status=pservice.login(JOptionPane.showInputDialog("enter User Name","Type here"),JOptionPane.showInputDialog("enter Password","Type here"));
    			if (status==true)
    				CrudOperation.crudOperation();
    			else
    				System.out.println("invalid credential!!");
    			System.exit(0);
    			break;
    		case "Q":
    			mainMenu();
    		}
    	}
    }
}