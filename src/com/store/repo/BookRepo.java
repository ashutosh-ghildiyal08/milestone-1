package com.store.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.store.db.DBconnection;
import com.store.to.BookTO;

public class BookRepo {
	Connection connection = DBconnection.getConnection();

	public List<BookTO> findAllBooks() {

		List<BookTO> books = new ArrayList<BookTO>();

		try {

			PreparedStatement statement = connection.prepareStatement("select * from book");

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {

				int id = resultSet.getInt(1);
				String bookName = resultSet.getString(2);
				String authName = resultSet.getString(3);
				String publisherName = resultSet.getString(4);
				String description = resultSet.getString(5);
				int noOfCopiesSold = resultSet.getInt(6);
				int price = resultSet.getInt(7);

				BookTO bookTO = new BookTO(id,  bookName, authName, publisherName, description, noOfCopiesSold,price);
				books.add(bookTO);
			}
			if (books.isEmpty()) {
				System.out.println("--- No Books Found ---");
			}

		} catch (Exception e) {
			System.out.println("inside catch of BooKRepo in findallbook");
			e.printStackTrace();
		}

		return books;

	}

	public List<BookTO> searchByAuthName(String str) {

		List<BookTO> books = new ArrayList<BookTO>();
		try {

			PreparedStatement statement = connection.prepareStatement("select * from book where authorName = ?");
			statement.setString(1, str);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				int id = resultSet.getInt(1);
				String authName = resultSet.getString(2);
				String bookName = resultSet.getString(3);
				String publisherName = resultSet.getString(4);;
				String description = resultSet.getString(5);
				int noOfCopiesSold = resultSet.getInt(6);
				int price = resultSet.getInt(7);

				BookTO bookTO = new BookTO(id,  bookName, authName, publisherName, description, noOfCopiesSold,price);
				books.add(bookTO);
			}
			if (books.isEmpty()) {
				System.out.println("--- No Books Found ---");
			}

		} catch (Exception e) {
			System.out.println("inside catch of BooKRepo in searchByAuthName");
			e.printStackTrace();
		}

		return books;
	}

	public List<BookTO> searchByTitleName(String str) {
		List<BookTO> books = new ArrayList<BookTO>();
		try {

			PreparedStatement statement = connection.prepareStatement("select * from book where bookName = ?");
			statement.setString(1, str);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				int id = resultSet.getInt(1);
				String authName = resultSet.getString(2);
				String bookName = resultSet.getString(3);
				String publisherName = resultSet.getString(4);;
				String description = resultSet.getString(5);
				int noOfCopiesSold = resultSet.getInt(6);
				int price = resultSet.getInt(7);

				BookTO bookTO = new BookTO(id,  bookName, authName, publisherName, description, noOfCopiesSold,price);
				books.add(bookTO);
			}
			if (books.isEmpty()) {
				System.out.println("--- No Books Found ---");
			}

		} catch (Exception e) {
			System.out.println("inside catch of BooKRepo in searchByTitleName");
			e.printStackTrace();
		}

		return books;
	}
	
	public List<BookTO> searchByPublisherName(String str) {

		List<BookTO> books = new ArrayList<BookTO>();
		try {

			PreparedStatement statement = connection.prepareStatement("select * from book where publisherName = ?");
			statement.setString(1, str);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				int id = resultSet.getInt(1);
				String authName = resultSet.getString(2);
				String bookName = resultSet.getString(3);
				String publisherName = resultSet.getString(4);;
				String description = resultSet.getString(5);
				int noOfCopiesSold = resultSet.getInt(6);
				int price = resultSet.getInt(7);

				BookTO bookTO = new BookTO(id,  bookName, authName, publisherName, description, noOfCopiesSold,price);
				books.add(bookTO);
			}
			if (books.isEmpty()) {
				System.out.println("--- No Books Found ---");
			}

		} catch (Exception e) {
			System.out.println("inside catch of BooKRepo in searchByPublisherName");
			e.printStackTrace();
		}

		return books;
	}


	public BookTO searchById(int id1) {
		BookTO book = null;
		try {

			PreparedStatement statement = connection.prepareStatement("select * from book where bookId = ?");
			statement.setInt(1, id1);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				int id = resultSet.getInt(1);
				String authName = resultSet.getString(2);
				String bookName = resultSet.getString(3);
				String publisherName = resultSet.getString(4);;
				String description = resultSet.getString(5);
				int noOfCopiesSold = resultSet.getInt(6);
				int price = resultSet.getInt(7);

				BookTO bookTO = new BookTO(id,  bookName, authName, publisherName, description, noOfCopiesSold,price);
				book = bookTO;
			}
			if(book == null) {
				System.out.println("--- No Books Found ---");
			}

		} catch (Exception e) {
			System.out.println("inside catch of BooKRepo in searchById");
			e.printStackTrace();
		}

		return book;
	}

	public void insert(BookTO book) {

		try {

			PreparedStatement statement = connection.prepareStatement("insert into book values(?, ?, ?, ?, ?, ?, ?)");

			statement.setInt(1, book.getBookid());
			statement.setString(2, book.getBookName());
			statement.setString(3, book.getAuthorName());
			statement.setString(4, book.getPublisherName());
			statement.setString(5, book.getDescription());
			statement.setInt(6, book.getNoOfCopiesSold());
			statement.setInt(7, book.getPrice());

			statement.executeUpdate();
			System.out.println("- - - Book Inserted Successfuly - - -");
		} catch (Exception e) {
			System.out.println("inside catch of insert in BooksRepo");
			e.printStackTrace();
		}
	}

	public void remove(int id) {
		try {
			PreparedStatement statement = connection.prepareStatement("delete from book where bookId = ?");
			statement.setInt(1, id);
			
			statement.executeUpdate();
			System.out.println("- - - Book Removed Successfuly - - -");
		}catch (Exception e) {
			System.out.println("inside catch of remove in BooksRepo");
			e.printStackTrace();
		}
	}

	public void update(String bookName,String  authName, String description, String publisherName , int noOfCopiesSold, int price, int id) {
		try {
			//check error in sql syntax
			PreparedStatement statement = connection.prepareStatement("UPDATE book SET bookName = ?, authorName = ?, publisherName= ?, description = ? , noOfCopiesSold = ? , price = ? WHERE bookId = ?");
			
			statement.setString(1, bookName);
			statement.setString(2, authName);
			statement.setString(3, authName);
			statement.setString(4, description);
			statement.setInt(5, noOfCopiesSold);
			statement.setInt(6, price);
			statement.setInt(7, id);

			statement.executeUpdate();
			System.out.println("- - - Book Updated Successfuly - - -");
		} catch (Exception e) {
			System.out.println("inside catch of update in BooksRepo");
			e.printStackTrace();
		}
		
	}

	public int count() {
		int count =0 ;
		try {
			PreparedStatement statement = connection.prepareStatement("select count(*) from book");
			
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
		      
		} catch(Exception e) {
			System.out.println("inside catch of Count in BooksRepo");
			e.printStackTrace();
		}
		return count;
	}

	public List<BookTO> orderByPriceLowToHigh() {
		List<BookTO> books = new ArrayList<BookTO>();

		try {

			PreparedStatement statement = connection.prepareStatement("select * from book ORDER BY price ASC");

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {

				int id = resultSet.getInt(1);
				String bookName = resultSet.getString(2);
				String authName = resultSet.getString(3);
				String publisherName = resultSet.getString(4);
				String description = resultSet.getString(5);
				int noOfCopiesSold = resultSet.getInt(6);
				int price = resultSet.getInt(7);

				BookTO bookTO = new BookTO(id,  bookName, authName, publisherName, description, noOfCopiesSold,price);
				books.add(bookTO);
			}
			if (books.isEmpty()) {
				System.out.println("--- No Books Found ---");
			}

		} catch (Exception e) {
			System.out.println("inside catch of BooKRepo in findallbook");
			e.printStackTrace();
		}

		return books;
	}

	public List<BookTO> orderByPriceHighToLow() {
		List<BookTO> books = new ArrayList<BookTO>();

		try {

			PreparedStatement statement = connection.prepareStatement("select * from book ORDER BY price DESC");

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {

				int id = resultSet.getInt(1);
				String bookName = resultSet.getString(2);
				String authName = resultSet.getString(3);
				String publisherName = resultSet.getString(4);
				String description = resultSet.getString(5);
				int noOfCopiesSold = resultSet.getInt(6);
				int price = resultSet.getInt(7);

				BookTO bookTO = new BookTO(id,  bookName, authName, publisherName, description, noOfCopiesSold,price);
				books.add(bookTO);
			}
			if (books.isEmpty()) {
				System.out.println("--- No Books Found ---");
			}

		} catch (Exception e) {
			System.out.println("inside catch of BooKRepo in findallbook");
			e.printStackTrace();
		}

		return books;
	}

	public List<BookTO> BestSelling() {
		List<BookTO> books = new ArrayList<BookTO>();

		try {

			PreparedStatement statement = connection.prepareStatement("select * from book ORDER BY noOfCopiesSold DESC");

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {

				int id = resultSet.getInt(1);
				String bookName = resultSet.getString(2);
				String authName = resultSet.getString(3);
				String publisherName = resultSet.getString(4);
				String description = resultSet.getString(5);
				int noOfCopiesSold = resultSet.getInt(6);
				int price = resultSet.getInt(7);

				BookTO bookTO = new BookTO(id,  bookName, authName, publisherName, description, noOfCopiesSold,price);
				books.add(bookTO);
			}
			if (books.isEmpty()) {
				System.out.println("--- No Books Found ---");
			}

		} catch (Exception e) {
			System.out.println("inside catch of BooKRepo in findallbook");
			e.printStackTrace();
		}

		return books;
	}

	public void addToFav(int id1, int id2) {
		
		try {
			PreparedStatement statement = connection.prepareStatement("insert into favBook values(?, ?)");
			statement.setInt(1, id1 );
			statement.setInt(2, id2 );
			
			statement.executeUpdate();
			
			System.out.println("- - - Book Inserted Successfuly - - -");
		} catch (Exception e) {
			System.out.println("inside catch of addToFav in BooksRepo");
			e.printStackTrace();
		}
	}

	public void addToCompleted(int id4, int id5) {
		
		try {
			PreparedStatement statement = connection.prepareStatement("insert into completedBook values(?, ?)");
			statement.setInt(1, id4 );
			statement.setInt(2, id5 );
			
			statement.executeUpdate();
			
			System.out.println("- - - Book Inserted Successfuly - - -");
		} catch (Exception e) {
			System.out.println("inside catch of addToCompleted in BooksRepo");
			e.printStackTrace();
		}
	}

}
