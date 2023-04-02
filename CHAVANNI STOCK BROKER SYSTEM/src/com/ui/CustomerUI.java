package com.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.dao.CustomerDAO;
import com.dao.CustomerDAOImpl;
import com.dto.CustomerDTO;
import com.dto.CustomerDTOImpl;
import com.exceptions.NoRecordsFoundException;
import com.exceptions.SomethingWentWrongException;

public class CustomerUI {
	public static void showCustomerMenu(Scanner sc) {
		int choice = 0;
		do {
			System.out.println("1. Sign Up ");
			System.out.println("2. Login");
			System.out.println("0. Exit");
			System.out.print("Enter your selection "); 
			choice = sc.nextInt();
			switch(choice) {
				case 1 : customerSignUp(sc);
					break;
				case 2 : CustomerAfterLogin.customerLogin(sc);
					break;
				case 0 : System.out.println("Thanks for using!");
					break;
				default : System.out.println("Invalid selection, try again!");
			}
		} while (choice!=0);
	}

	public static boolean customerLogin(Scanner sc)  {
		boolean loginSuccess = false;
		System.out.println("Enter your username");
		String userName = sc.next();
		System.out.println("Enter your password");
		String password = sc.next();
		
		CustomerDAO customerDao = new CustomerDAOImpl();
		try {
			customerDao.logIn(userName,password);
			loginSuccess = true;
			System.out.println("You have successfully logged in...");
		} catch (Exception e) {
			
		}
		return loginSuccess;
		
	}

	public static void customerSignUp(Scanner sc) {
		System.out.print("Please enter your first name ");
		String firstName = sc.next();
		System.out.print("Please enter your last name ");
		String lastName = sc.next();
		System.out.print("Please enter your username ");
		String userName = sc.next();
		System.out.print("Create password ");
		String password = sc.next();
		System.out.print("Enter your address ");
		String address = sc.next();
		System.out.print("Enter your mobile number ");
		String mob = sc.next();
		System.out.print("Enter your email address ");
		String email = sc.next();
		
		CustomerDTO customerDto = new CustomerDTOImpl(0,firstName, lastName, userName, password, address, mob, email, 0);
		CustomerDAO customerDao = new CustomerDAOImpl();
		try {
			customerDao.addCustomer(customerDto);
			System.out.println("You have successfully signed up");
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
