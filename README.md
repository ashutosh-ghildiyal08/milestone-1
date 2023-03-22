# Milestone-1
This Repository Contains Code of Milestone-1.
It includes topics from Core Java including java theory concepts like Exception Handling, Multihtreading, etc as well. It is written using multi-layer architecture. For storing information JDBC concepts are used with MySQL as the database as the choice.

## Multi-Layer Architecture
The code is divided into different layer by the use of packages. and each package contains files according to the different entities which played a role in the working of the project. The packages and the files inside those packages are as follows:

#### Packages:
1. com.store
	1. Main.java
2. com.store.db
	1. DBconnection.java
3. com.store.page
	1. AdminPage.java
	2. UserPage.java
	3. BookPage.java
4. com.store.service
	1. AdminService.java
	2. UserService.java
	3. BookService.java
5. com.store.repo
	1. AdminRepo.java
	2. UserRepo.java
	3. BookRepo.java
6. com.store.to
	1. AdminTO.java
	2. UserTO.java
	3. BookTO.java
7. com.store.exception
	1. LoginInvalidException.java
	2. WrongInputException.java
8. com.store.logicThread
	1. ifAdmin
	2. ifUser

## Flow of Control for a Client
 - The Client first sees the **Homepage** which contains option from which one can choose if they are an **admin** or a **user**, which is present is in the **Main.java**. Then using switch case the client specifies if they are a user or an admin.

 - Whichever case the client selects, that case runs on a **new thread**, which implements the required runnable according to the client selection. This is done to apply **Multithreading**. This is explained in the last point.

 - We also configured our project with MySQL Java driver to enable so that we can create a Database connection inside **DBconnection.java** so that we can connect our project to database to save, retrieve and manipulate data.

 - After that we come to the Login / Register page which is in the **UserPage.java** and the **AdminPage.java**.  We also use the concept of Exception handling where when any client provides with wrong **Credentials**  then an exception **LoginInvalidException** is thrown.

 - After that according to the identity of the client a new page is displayed which displays them **Commands** according to the clients **role (User or Admin)**. This is inside **BookPage.java** . Here they can choose the command they want to run.

 - #### Commands for the User:
	1. User can list all the books.
	2. User can search book by author name(0, 1 or many).
	3. User can search book by title name(0, 1 or many).
	4. User can search book by publication name(0, 1 or many).
	5. User can search book by id.
	6. User can add books in favourite books.
	7. User can add books in completed books.

 - #### Commands for the Admin:
	1. Admin can insert new book.
	2. Admin can remove book.
	3. Admin can update book.
	4. Admin can search new book(by id or author name).
	5. Admin can list all books.
	6. Admin can count the total books.
	7. Admin can arrange the books in the following order:
		 - price low to high
		 - price high to low 
		 - best selling

 - The respective clients have an option where they can go back to their respective page and can Logout.

 - Also, all the switch cases have an exception **WrongInputException** which thows an error when client enters wrong option as an input.

 - The Commands uses Database Queries to save, retrieve and manipulate data. This is done inside **BookRepo.java**. We create a Database Connection and form the query which we want to run on the database. We use **PreparedStatement** to create the query and use **executeUpdate** or **executeQuery** to run the query.

 - The classes inside the **com.store.service** package is used as a middleman between the classes inside the com.store.page package and the com.store.repo package. It retrieves the data from the database by the help of classes in com.store.repo package and sends it to the classes in com.store.page according to needs of the method. where the data is needed.

 - Using the classes in the **com.store.to** package we are able to bind data together and make a **transferable object** which makes our job easier when sending and receiving data in different classes.

 - Multithreading:
1. Using Multithreading we are able to run all User or Admin related **flow** in their own thread. Whenever the new thread is started, the **number of threads** in the **thread pool** is **2**. The Threads are as follows:
	- Main thread
	-  New Thread

2.  As the running time of a Thread is random, hence it **switches** to a different thread on its own, but we want the Thread to run completely, and the main thread should run only after the new thread terminates. Hence, we used **Thread.join()** method to solve this problem.

3. In the com.store.logicThread package we have created **2 runnable classes** and inside their run function we have mentioned the required code. The **isUser** class contains code which starts the user related flow, inside which the run function contains **service.ifuser** command and the **isAdmin** class which starts the admin related flow, inside which the run function contains **service.ifadmin** command.
4. Using **thread object** we run the runnable classes for the different cases inside the switch block.
 
 ## Database Schemas with Attributes

 ### user
 
username, password, firstName, lastName, favouriteBooks (Collection of Book), completedBooks (Collection of Book).
 
### admin
username, password, firstName, lastName.


### book
bookName, bookId, authorName,  publisherName, description, noOfCopiesSold, price

### favBook
userId, bookId

### completedBook
userId, bookId

> To store collection of favBooks and completedBooks, we used a different table for both which is used to store the particular user id and that users favBook or completedBook id.
