package com.ui;

import java.util.Scanner;

public class CustomerAfterLogin {

	public static void customerLogin(Scanner sc) {
		
		if(!CustomerUI.customerLogin(sc)) {
			return;
		}
		//you are here means login is successful;
		int choice = 0;
		do {
			System.out.println("1. View all the stocks ");
			System.out.println("2. Buy Stocks ");
			System.out.println("3. Sell Stocks ");
			System.out.println("4. View Transaction history ");
			System.out.println("5. Logout");
			System.out.println("6. Delete Account");
			System.out.println("7. Exit");
			System.out.println("Enter selection ");
			choice = sc.nextInt();
			
			switch(choice) {
				case 1 : //viewAllStocks();
					break;
				case 2 : //buyStocks();
					break;
				case 3 : //sellStocks();
					break;
				case 4 : //viewTransactionHistory();
					break;
				case 5 : //logout();
					break;
				case 6 : //delete();
					break;
				case 7 : 
					break;
				case 0 : System.out.println("Thanks for using");
					break;
				default : System.out.println("Invalid selection");
			}
		} while (choice != 0);
		
	}

}
