package com.store.service;

import java.util.Scanner;

import com.store.repo.AdminRepo;
import com.store.to.AdminTO;

public class AdminService {

	Scanner sc = new Scanner(System.in);
	AdminRepo repository = new AdminRepo();
	
	public void register() {
		System.out.println("Press Enter to write your Details ->");

		System.out.println("Enter your Id ->");
		int id = sc.nextInt();
		System.out.println("Enter your UserName ->");
		String aname = sc.next();
		System.out.println("Enter your Password ->");
		String password = sc.next();
		System.out.println("Enter your First Name ->");
		String fname = sc.next();
		System.out.println("Enter your Last Name ->");
		String lname = sc.next();
		// System.out.println(id+"-"+aname+"-"+password+"-"+fname+"-"+lname);
		
		AdminTO admin = new AdminTO(id, aname, password, fname, lname);

		repository.register(admin);
	}

	public int login() {

		System.out.println("Enter your UserName ->");
		String username = sc.next();
		System.out.println("Enter your Password ->");
		String password = sc.next();
		

		return repository.login(username, password);
	}
}
