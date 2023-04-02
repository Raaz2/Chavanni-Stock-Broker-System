package com.ui;

import java.io.Console;
import java.util.Scanner;

import com.colors.ConsoleColors;

public class UIMain {
	static {
		System.out.println(ConsoleColors.ANSI_YELLOW_BACKGROUND+ConsoleColors.BLACK+"Welcome to 'CHAVANNI' stock broker system for future of India ."+ConsoleColors.RESET);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("You are a :-  ");
			System.out.println("1. Broker");
			System.out.println("2. Customer");
			System.out.println("0. Exit");
			System.out.print("Enter Selection here!  ");
			choice = sc.nextInt();
			
			switch(choice) {
				case 1 : BrokerUI.showBrokerMenu(sc);
					break;
				case 2 : CustomerUI.showCustomerMenu(sc);
					break;
				case 0 : System.out.println("Thanks for using our services.");
					break;
				default : System.out.println("Invalid Selection, try again!");
			}
			
			
		} while (choice != 0);
		sc.close();
	}

}
