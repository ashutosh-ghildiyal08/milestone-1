package com.store.to;

public class BookTO {
	int bookid;
	String bookName, authorName, publisherName, description; 
	int noOfCopiesSold, price;
	public BookTO(int bookid, String bookName, String authorName, String publisherName, String description,
			int noOfCopiesSold, int price) {
		super();
		this.bookid = bookid;
		this.bookName = bookName;
		this.authorName = authorName;
		this.publisherName = publisherName;
		this.description = description;
		this.noOfCopiesSold = noOfCopiesSold;
		this.price = price;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNoOfCopiesSold() {
		return noOfCopiesSold;
	}
	public void setNoOfCopiesSold(int noOfCopiesSold) {
		this.noOfCopiesSold = noOfCopiesSold;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
