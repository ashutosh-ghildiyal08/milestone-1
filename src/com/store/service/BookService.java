package com.store.service;

import java.util.List;
import java.util.Scanner;

import com.store.repo.BookRepo;
import com.store.to.BookTO;

public class BookService {

	BookRepo bookRepository = new BookRepo();
	Scanner sc = new Scanner(System.in);

	public List<BookTO> getAllBooks() {

		return bookRepository.findAllBooks();
	}

	public List<BookTO> getByAuthName(String str) {
		return bookRepository.searchByAuthName(str);
	}

	public List<BookTO> getByTitleName(String str) {
		return bookRepository.searchByTitleName(str);
	}

	public List<BookTO> getByPublisherName(String str) {
		return bookRepository.searchByPublisherName(str);
	}

	public BookTO getById(int id) {
		return bookRepository.searchById(id);
	}
	public int count() {
		return bookRepository.count();
	}
	public List<BookTO> orderByPriceLowToHigh() {

		return bookRepository.orderByPriceLowToHigh();
	}
	public List<BookTO> orderByPriceHighToLow() {

		return bookRepository.orderByPriceHighToLow();
	}
	public List<BookTO> BestSelling() {

		return bookRepository.BestSelling();
	}
	
	public void insertBook() {
		System.out.println("Press Enter to write Book Details ->");
		System.out.println("Enter Book Id ->");
		int id = sc.nextInt();
		System.out.println("Enter Book TitleName ->");
		String bookName = sc.next();
		System.out.println("Enter Book AuthName->");
		String authName = sc.next();
		System.out.println("Enter Book PublisherName->");
		String publisherName = sc.next();
		System.out.println("Enter Book Description ->");
		String description = sc.next();
		System.out.println("Enter Number of Copies Sold ->");
		int noOfCopiesSold = sc.nextInt();
		System.out.println("Enter Book Price ->");
		int price = sc.nextInt();

		BookTO book = new BookTO(id, bookName, authName, publisherName, description, noOfCopiesSold, price);

		bookRepository.insert(book);

	}

	public void removeBook() {
		System.out.println("Enter Id to Remove Book -> ");
		int id = sc.nextInt();
		bookRepository.remove(id);
	}

	public void updateBook() {
		System.out.println("Enter Id -> ");
		int id1 = sc.nextInt();
		BookTO book = bookRepository.searchById(id1);
		if (book != null) {
			System.out.println("Update Book Details -> ");

			System.out.println("Enter Book TitleName ->");
			String bookName = sc.next();
			System.out.println("Enter Book AuthName->");
			String authName = sc.next();
			System.out.println("Enter Book PublisherName->");
			String publisherName = sc.next();
			System.out.println("Enter Book Description ->");
			String description = sc.next();
			System.out.println("Enter Number of Copies Sold ->");
			int noOfCopiesSold = sc.nextInt();
			System.out.println("Enter Book Price ->");
			int price = sc.nextInt();

			bookRepository.update(bookName, authName, publisherName, description, noOfCopiesSold, price, id1);
		}

	}

	public void addToFav(int id1, int id2) {
		bookRepository.addToFav(id1,id2);
		
	}

	public void addToCompleted(int id4, int id5) {
		bookRepository.addToCompleted(id4,id5);
		
	}

}
