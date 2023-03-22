package com.store.page;

import java.util.Scanner;

import com.store.exception.WrongInputException;
import com.store.service.UserService;


public class UserPage {
	BookPage book = new BookPage();
	UserService userService = new UserService();
	Scanner sc = new Scanner(System.in);
	
	
	public void ifUser() {
		int option = 0;
		do {
		System.out.println("---- User Login/Register ----");

		System.out.println("1. User Registration");
		System.out.println("2. User Login");
		System.out.println("3. back");
		System.out.println("Enter Option Number -> ");
		
		option = sc.nextInt();
		switch (option) {
		case 1:
			
			userService.register();
			book.userBookCommands()	;
			break;
		case 2:
			if (userService.login() == 1) {

				System.out.println("Login Successful");

				book.userBookCommands()	;			 
				
			} else {
				

				System.out.println("Login Unsuccessful...");
				
				
			}
			break;
		case 3:
			
			break;
		default:
			if(option >3) {
				try {
					throw new WrongInputException("- - - Wrong Option! Try Again :) - - -");
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		
		}
		
	} while (option != 3) ;
		

	}
}
