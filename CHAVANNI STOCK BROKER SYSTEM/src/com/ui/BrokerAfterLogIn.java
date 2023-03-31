package com.ui;

import java.util.Scanner;

import com.dao.CustomerDAO;
import com.dao.CustomerDAOImpl;
import com.dao.StockDAOImpl;

public class BrokerAfterLogIn {

	public static void deleteCustomer(Scanner sc) {
		System.out.println("Enter customer id to delete");
		int id = sc.nextInt();
		
		CustomerDAO custDao = new CustomerDAOImpl();
		custDao.deleteCustomer(id);
		
	}

	public static void deleteStock(Scanner sc) {
		System.out.println("Enter stock id to delete");
		int id = sc.nextInt();
		StockDAOImpl.deleteStock(id);
		
	}

}
