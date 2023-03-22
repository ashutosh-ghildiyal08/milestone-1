package com.store.page;

import java.util.Scanner;

import com.store.exception.WrongInputException;
import com.store.service.AdminService;

public class AdminPage {
	BookPage book = new BookPage();
	AdminService adminService = new AdminService();
	Scanner sc = new Scanner(System.in);

	public void ifadmin()  {
		int option = 0;
		do {
			System.out.println("---- Admin Login/Register ----");

			System.out.println("1. Admin Registration");
			System.out.println("2. Admin Login");
			System.out.println("3. back");
			System.out.println("Enter Option Number -> ");

			option = sc.nextInt();
			switch (option) {
			case 1:

				adminService.register();
				book.adminBookCommands();
				break;
			case 2:
				if (adminService.login() == 1) {

					System.out.println("Login Successful");

					book.adminBookCommands();

				} else {

					System.out.println("Wrong Credentials...");
				}
				break;
			case 3:

				break;
			default:
				if (option > 3) {
					System.out.println("- - - Wrong Option! Try Again :) - - -");
				}

			}

		} while (option != 3);

	}
}
