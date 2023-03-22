package com.store.service;


import java.util.Scanner;

import com.store.to.UserTO;
import com.store.repo.UserRepo;

public class UserService {
	
	UserRepo repository = new UserRepo();

	Scanner sc = new Scanner(System.in);
	
	public void register() {
		System.out.println("Press Enter to write your Details ->");
		
		System.out.println("Enter your Id ->");
		int id = sc.nextInt();
		System.out.println("Enter your UserName ->");
		String uname = sc.next();
		System.out.println("Enter your Password ->");
		String password = sc.next();
		System.out.println("Enter your First Name ->");
		String fname= sc.next();
		System.out.println("Enter your Last Name ->");
		String lname = sc.next();
		//System.out.println(id+"-"+uname+"-"+password+"-"+fname+"-"+lname);
		UserTO user = new UserTO(id, uname, password, fname, lname);
		
		repository.register(user);	
	}

	public int login() {

		System.out.println("Enter your UserName ->");
		String uname = sc.next();
		System.out.println("Enter your Password ->");
		String password = sc.next();
		

		return repository.login(uname, password);
	}
	
}
