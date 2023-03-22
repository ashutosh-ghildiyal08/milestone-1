package com.store;

import java.util.Scanner;

import com.store.exception.WrongInputException;
import com.store.logicThread.ifAdmin;
import com.store.logicThread.ifUser;
import com.store.page.AdminPage;

import com.store.page.UserPage;


public class Main {

	public static void main(String[] args) throws WrongInputException {
		
		
		UserPage user = new UserPage();
		AdminPage admin = new AdminPage();
		
		System.out.println("---- Welcome to the Online Book Store ----");
		int option= 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println(" <- - - - Homepage - - - ->");
			System.out.println("1. User Login/Register");
			System.out.println("2. Admin Login/Register");
			System.out.println("3. exit");
			System.out.println("Enter Option Number -> ");
			option = sc.nextInt();
			switch (option) {
			case 1: 
				
				Thread t1 = new Thread(new ifUser());
				t1.start();
				try {
					t1.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2: 
				Thread t2 = new Thread(new ifAdmin());
				t2.start();
				try {
					t2.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3: 
				System.out.println("- - - - Thank You for Visiting - - - - ");
				break;
			default:
				if(option >3) {
					throw new WrongInputException("- - - Wrong Option! Try Again :) - - -");
				}
			
			}
			
		} while (option != 3) ;
		
	}

}
