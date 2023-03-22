package com.store.page;

import java.util.List;
import java.util.Scanner;

import com.store.exception.WrongInputException;
import com.store.service.BookService;
import com.store.to.BookTO;

public class BookPage {

	BookService bookService = new BookService();
	Scanner sc = new Scanner(System.in);

	void userBookCommands()  {

		int option = 0;

		do {
			System.out.println(" <---- User Books Portal ---->");

			System.out.println("1. List All Books");
			System.out.println("2. Search Books by Author Name");
			System.out.println("3. Search Books by Title Name");
			System.out.println("4. Search Books by Publisher Name");
			System.out.println("5. Search Books by Id");
			System.out.println("6. Add book to Favourites List");
			System.out.println("7. Add book to Completed List");
			System.out.println("8. back");

			System.out.println("Enter Option Number -> ");
			option = sc.nextInt();
			switch (option) {
			case 1:
				List<BookTO> books = bookService.getAllBooks();

				for (BookTO to : books) {

					System.out.println("- - - Book Id "+to.getBookid() +" - - -");
					System.out.println("Book Name: "+to.getBookName());
					System.out.println("Book Author: "+to.getAuthorName());
					System.out.println("Book Publisher: "+to.getPublisherName());
					System.out.println("Book Price: "+to.getPrice());
				}
				break;
			case 2:
				System.out.println("Enter Author Name -> ");
				sc.nextLine();
				String str1 = sc.nextLine();
				// System.out.println("str1 -> "+str1);
				List<BookTO> book1 = bookService.getByAuthName(str1);
				for (BookTO to : book1) {

					System.out.println("- - - Book Id "+to.getBookid() +" - - -");
					System.out.println("Book Name: "+to.getBookName());
					System.out.println("Book Author: "+to.getAuthorName());
					System.out.println("Book Publisher: "+to.getPublisherName());
					System.out.println("Book Price: "+to.getPrice());

				}
				break;

			case 3:
				System.out.println("Enter Title Name -> ");
				sc.nextLine();
				String str2 = sc.nextLine();
				List<BookTO> book2 = bookService.getByTitleName(str2);
				for (BookTO to : book2) {

					System.out.println("- - - Book Id "+to.getBookid() +" - - -");
					System.out.println("Book Name: "+to.getBookName());
					System.out.println("Book Author: "+to.getAuthorName());
					System.out.println("Book Publisher: "+to.getPublisherName());
					System.out.println("Book Price: "+to.getPrice());

				}

				break;
			case 4:
				System.out.println("Enter Publisher Name -> ");
				sc.nextLine();
				String str3 = sc.nextLine();
				List<BookTO> book3 = bookService.getByPublisherName(str3);
				for (BookTO to : book3) {

					System.out.println("- - - Book Id "+to.getBookid() +" - - -");
					System.out.println("Book Name: "+to.getBookName());
					System.out.println("Book Author: "+to.getAuthorName());
					System.out.println("Book Publisher: "+to.getPublisherName());
					System.out.println("Book Price: "+to.getPrice());

				}
				break;
			case 5:
				System.out.println("Enter Id -> ");
				sc.nextLine();
				int id1 = sc.nextInt();
				BookTO book4 = bookService.getById(id1);

				System.out.println("- - - Book Id "+book4.getBookid() +" - - -");
				System.out.println("Book Name: "+book4.getBookName());
				System.out.println("Book Author: "+book4.getAuthorName());
				System.out.println("Book Publisher: "+book4.getPublisherName());
				System.out.println("Book Price: "+book4.getPrice());
				break;
			case 6:
				
				System.out.println("Enter User Id -> ");
				sc.nextLine();
				int id2 = sc.nextInt();
				System.out.println("Enter Book Id -> ");
				sc.nextLine();
				int id3 = sc.nextInt();
				bookService.addToFav(id2,id3);
				break;
			case 7:

				System.out.println("Enter User Id -> ");
				sc.nextLine();
				int id4 = sc.nextInt();
				System.out.println("Enter Book Id -> ");
				sc.nextLine();
				int id5 = sc.nextInt();
				bookService.addToCompleted(id4,id5);
				
				break;
			
			case 8:
				System.out.println(" - - - Logged Out - - - ");
				break;
			default:
				if (option > 8) {
					try {
						throw new WrongInputException("- - - Wrong Option! Try Again :) - - -");
					}catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			}
		} while (option !=8);

	}

	void adminBookCommands() {
		int option = 0;

		do {
			System.out.println(" <---- Admin Books Portal ---->");

			System.out.println("1. List All Books");
			System.out.println("2. Insert New Book");
			System.out.println("3. Remove a Book");
			System.out.println("4. Update a book");
			System.out.println("5. Search Books by Id");
			System.out.println("6. Search Books by Author Name");
			System.out.println("7. Count of All Books");
			System.out.println("8. Arrange Order - Price: low to high");
			System.out.println("9. Arrange Order - Price: high to low");
			System.out.println("10. Arrange Order - Best Selling");
			System.out.println("11. Logout");

			System.out.println("Enter Option Number -> ");
			option = sc.nextInt();
			switch (option) {
			case 1:
				List<BookTO> books = bookService.getAllBooks();

				for (BookTO to : books) {

					System.out.println("- - - Book Id "+to.getBookid() +" - - -");
					System.out.println("Book Name: "+to.getBookName());
					System.out.println("Book Author: "+to.getAuthorName());
					System.out.println("Book Publisher: "+to.getPublisherName());
					System.out.println("Book Price: "+to.getPrice());
				}
				break;
			case 2:
				bookService.insertBook();

				break;
			case 3:
				bookService.removeBook();
				break;
			case 4:
				bookService.updateBook();
				break;
			case 5:
				System.out.println("Enter Id -> ");
				sc.nextLine();
				int id1 = sc.nextInt();
				BookTO book4 = bookService.getById(id1);

				System.out.println("- - - Book Id "+book4.getBookid() +" - - -");
				System.out.println("Book Name: "+book4.getBookName());
				System.out.println("Book Author: "+book4.getAuthorName());
				System.out.println("Book Publisher: "+book4.getPublisherName());
				System.out.println("Book Price: "+book4.getPrice());
				
				break;
			case 6:
				System.out.println("Enter Author Name -> ");
				sc.nextLine();
				String str1 = sc.nextLine();
				// System.out.println("str1 -> "+str1);
				List<BookTO> book1 = bookService.getByAuthName(str1);
				for (BookTO to : book1) {

					System.out.println("- - - Book Id "+to.getBookid() +" - - -");
					System.out.println("Book Name: "+to.getBookName());
					System.out.println("Book Author: "+to.getAuthorName());
					System.out.println("Book Publisher: "+to.getPublisherName());
					System.out.println("Book Price: "+to.getPrice());

				}
				break;
			case 7:
				System.out.println("Total Number of Books is -> " +bookService.count());
				
				break;
			case 8:
				List<BookTO> books2 = bookService.orderByPriceLowToHigh();

				for (BookTO to : books2) {

					System.out.println("- - - Book Id "+to.getBookid() +" - - -");
					System.out.println("Book Name: "+to.getBookName());
					System.out.println("Book Author: "+to.getAuthorName());
					System.out.println("Book Publisher: "+to.getPublisherName());
					System.out.println("Book Price: "+to.getPrice());
				}
				
				break;
			case 9:
				List<BookTO> books3 = bookService.orderByPriceHighToLow();

				for (BookTO to : books3) {

					System.out.println("- - - Book Id "+to.getBookid() +" - - -");
					System.out.println("Book Name: "+to.getBookName());
					System.out.println("Book Author: "+to.getAuthorName());
					System.out.println("Book Publisher: "+to.getPublisherName());
					System.out.println("Book Price: "+to.getPrice());
				}
				
				break;
			case 10:
				List<BookTO> books4 = bookService.BestSelling();

				for (BookTO to : books4) {

					System.out.println("- - - Book Id "+to.getBookid() +" - - -");
					System.out.println("Book Name: "+to.getBookName());
					System.out.println("Book Author: "+to.getAuthorName());
					System.out.println("Book Publisher: "+to.getPublisherName());
					System.out.println("Book Price: "+to.getPrice());
				}
				
				break;
			case 11:
				System.out.println(" - - - Logged Out - - - ");
				break;
			default:
				if (option > 11) {
					
					try {
						throw new WrongInputException("- - - Wrong Option! Try Again :) - - -");
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

		} while (option != 11);
		

	}

}
