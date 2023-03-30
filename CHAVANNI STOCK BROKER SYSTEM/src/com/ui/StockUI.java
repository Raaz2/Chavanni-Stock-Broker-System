package com.ui;

import java.util.List;
import java.util.Scanner;

import com.colors.ConsoleColors;
import com.dao.StockDAO;
import com.dao.StockDAOImpl;
import com.dto.StockDTO;
import com.dto.StockDTOImpl;
import com.exceptions.SomethingWentWrongException;

public class StockUI {

	public static void addNewStocks(Scanner sc) {
		System.out.println("Enter Company Name to add");
		String comp = sc.next();
		System.out.println("Enter Price for one Stock");
		int price = sc.nextInt();
		
		StockDTO stDto = new StockDTOImpl(0,comp,price); // here zero is psudo data
		StockDAO stDao = new StockDAOImpl();
		
		try {
			stDao.addStock(stDto);
			System.out.println("Stock added successfully");
		} catch (SomethingWentWrongException e) {
			e.printStackTrace();
		}
		
	}

	public static void viewAllStocks() {
		
		StockDAO stDao = new StockDAOImpl();
		List<StockDTO> list = stDao.viewAllStock();
		list.forEach( i -> {
			System.out.println(
		ConsoleColors.ANSI_PURPLE_BACKGROUND +	"StockId: " + ConsoleColors.ANSI_RESET  + ConsoleColors.ANSI_YELLOW_BACKGROUND + ConsoleColors.BLACK +  i.getStockId() + " " + ConsoleColors.ANSI_RESET +
		ConsoleColors.ANSI_PURPLE_BACKGROUND +	"StockName: " + ConsoleColors.ANSI_RESET  + ConsoleColors.ANSI_YELLOW_BACKGROUND + ConsoleColors.BLACK +i.getCompanyName() + " " + ConsoleColors.ANSI_RESET +
		ConsoleColors.ANSI_PURPLE_BACKGROUND +	"TotalQuantity: " + ConsoleColors.ANSI_RESET  + ConsoleColors.ANSI_YELLOW_BACKGROUND + ConsoleColors.BLACK + i.getQuantity() + " " + ConsoleColors.ANSI_RESET +
		ConsoleColors.ANSI_PURPLE_BACKGROUND +	"Price per unit: " + ConsoleColors.ANSI_RESET  + ConsoleColors.ANSI_YELLOW_BACKGROUND + ConsoleColors.BLACK + i.getPrice() + " " + ConsoleColors.ANSI_RESET 
				+ "\n" +
				"===================================================================================="
					);
		});
		
	}

}
