package com.store.to;

import java.util.ArrayList;
import java.util.List;


public class UserTO {
	int id;
	String username, password, firstName, lastName;
	List<BookTO> favouriteBooks = new ArrayList<BookTO>();
	List<BookTO> completedBooks= new ArrayList<BookTO>();
	
	public UserTO(int id, String username, String password, String firstName, String lastName) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<BookTO> getFavouriteBooks() {
		return favouriteBooks;
	}
	public void setFavouriteBooks(List<BookTO> favouriteBooks) {
		this.favouriteBooks = favouriteBooks;
	}
	public List<BookTO> getCompletedBooks() {
		return completedBooks;
	}
	public void setCompletedBooks(List<BookTO> completedBooks) {
		this.completedBooks = completedBooks;
	}
	

}
