package com.ui;

import java.util.Scanner;

import com.dao.CustomerDAO;

public class BrokerUI {

	public static void showBrokerMenu(Scanner sc) {
		System.out.println("Kindly login first! 😉");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("Please enter your  username: " );
		String userName = sc.next();
		System.out.print("Please enter your password: ");
		String password = sc.next();
		if(userName.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
			adminMenu(sc);
			System.out.println("Broker login successful");
		} else {
			System.out.println("Invalid Username or Password");
		}
		
	}

	public static void adminMenu(Scanner sc) {
		int choice = 0;
		do {
			System.out.println("1. View all the Customers");
			System.out.println("2. Add new stocks");
			System.out.println("3. View all the stocks");
			System.out.println("4. View consolidated report of any stock");
			System.out.println("5. Delete customer");
			System.out.println("6. Delete stock");
			System.out.println("7. Logout");
			System.out.println("0. Exit");
			System.out.print("Enter selection ");
			
			choice = sc.nextInt();
			
					switch(choice) {
						case 1: StockUI.viewAllCustomers();
							break;
						case 2: StockUI.addNewStocks(sc);
							break;
						case 3: StockUI.viewAllStocks();
							break;
						case 4: //viewConsolidatedReport();
							break;
						case 5: BrokerAfterLogIn.deleteCustomer(sc);
							break;
						case 6: BrokerAfterLogIn.deleteStock(sc);
							break;
						case 7: //logout();
							break;
						case 0: System.out.println("Thanks for using");
						 	break;
						 default: System.out.println("Invalid selection, try again!");
					}
			} while (choice != 0);
		
	}

}
