package com.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.colors.ConsoleColors;
import com.dao.LoggedInUser;
import com.dao.OrdersDAO;
import com.dao.OrdersDAOImpl;
import com.exceptions.NoRecordsFoundException;

public class CustomerAfterLogin {

	public static void customerLogin(Scanner sc) {
		
		if(!CustomerUI.customerLogin(sc)) {
			return;
		}
		//you are here means login is successful;
		int choice = 0;
		do {
			System.out.println("1. View all the stocks ");
			System.out.println("2. Add fund into wallet");
			System.out.println("3. Buy Stocks ");
			System.out.println("4. Sell Stocks ");
			System.out.println("5. Withdraw fund from wallet");
//			System.out.println("6. View Transaction history ");
			System.out.println("6. Logout");
//			System.out.println("8. Delete Account");
			System.out.println("0. Exit");
			System.out.println("Enter selection ");
			choice = sc.nextInt();
			
			switch(choice) {
				case 1 : try {
					StockUI.viewAllStocks();
				} catch (NoRecordsFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
				case 2 : addFund(sc);
					break;
				case 3 : buyStocks(sc);
					break;
				case 4 : sellStocks(sc);
					break;
				case 5 : withdrawFund(sc);
					break;
				case 6 : logout();//viewTransactionHistory();
					break;
				case 7 : //logout();
					break;
				case 8 : //delete();
					break;
				case 0 : System.out.println("Thanks for using");
					break;
				default : System.out.println("Invalid selection");
			}
		} while (LoggedInUser.loggedInUserId != 0);
		
	}

	private static void withdrawFund(Scanner sc) {
		System.out.println("Enter amount to withdraw from wallet");
		int amount = sc.nextInt();
		OrdersDAO orderDao = new OrdersDAOImpl();
		orderDao.withdraw(amount);
		System.out.println("Amount withdrawl successful");
	}

	private static void sellStocks(Scanner sc) {
		System.out.println("Enter Stock Id to sell  stock");
		int stId = sc.nextInt();
		System.out.println("Enter Stock quantity");
		int quan = sc.nextInt();
		OrdersDAO orderDao = new OrdersDAOImpl();
		orderDao.sellStock(stId,quan);
		System.out.println("Stock sold successfully");
		
	}

	private static void addFund(Scanner sc) {
		System.out.println("Enter amount to add into wallet from your account");
		int amount = sc.nextInt();
		OrdersDAO orderDao = new OrdersDAOImpl();
		orderDao.addFund(amount);
		System.out.println("Amount added successfully into wallet");
	}

	public static void buyStocks(Scanner sc) {
		System.out.println("Enter Stock Id to buy particular stock");
		int stId = sc.nextInt();
		System.out.println("Enter Stock quantity");
		int quan = sc.nextInt();
		OrdersDAO orderDao = new OrdersDAOImpl();
		try {
			orderDao.buyStock(stId,quan);
			System.out.println("Stock bought successfully");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void logout() {
		System.out.println(ConsoleColors.ANSI_WHITE_BACKGROUND+ConsoleColors.BLACK+"Logged out!"+ConsoleColors.BLACK+ConsoleColors.ANSI_RESET);
		LoggedInUser.loggedInUserId = 0;
	}

}
