# BooksVibe

BooksVibe is a portal for ordering/returning rental books. This provides ease of renting books just by clicking on a button. The book will get delivered at your doorstep. 

BooksVibe provides systematic management of the orders. There are following roles incorporated in the system:
1.	User
2.	Master Administrator
3.	Administrators

The user have to select a subscription plan while registering.  He/ She can then place a request for renting a book. The request is send to one of the administrators, who then approves the request. By doing this, the status of the book request changes from “Pending” to “Approved”. After reading the book, the user places a return request. The administrator then close the request and the book is considered returned.

The Master Administrator is a system created Administrator who can create other administrators.

###### Key Features
1.The end user can
-	Browse online catalogues of books.
-	Select book and request for books.
-	Generate return request.
-	Cancel delivery/return requests.

2.The Master Admin of the portal can  add/update/delete 
-	Books. 
-	Books via scheduler( CSV file feeding).
-	Plans (XML file)  and 
-	Generate PDF report.

3.The Admin can
-	View the requested books.
-	Handles delivery and return requests.

4.Other Features
-	BooksVibe is a very user-friendly interface for book renting.
-	Users get book recommendations and new arrivals that helps them better selection of books.
-	The administrators can generate PDFs to maintain records of books.
-	Scheduler takes care of many tasks like adding books in the database, sending mail regarding ending of subscription plan etc. that minimizes administrator’s to do tasks.

###### BooksVibe Schedular

The Scheduler performs following tasks:
- Add/Update books in the system. It also delete books from the system. This task is done via CSV file. The administrator need to place this csv file in the D:\ drive of the computer system named books.csv. This file should also contains master’s credentials.
This task runs automatically every Monday at 9.00 am automatically
-	Builds recommendations for users. This tasks runs automatically every day at 12:00 pm .
-	Sends mail to the users whose subscription plan is about to end. This tasks runs every day at 11 am.
-	Change the user subscription plan status if it is expired. This task runs every day at 12:00 am 

## Technology stack
- MVC Framework : Struts2
- Object Container : Spring IOC
- Back-End ORM Technology : Hibernate 4.3.6
- Database : My SQL 5.5 
- Build Tool : Apache Maven 3.0.5
- Scheduler : Quartz 
- Java Mail API
- Unit Testing : JUnit 4.7
- Logging Framework : Log4j 
- UI Technologies : JSP , Java Script , Bootstrap and jQuery


