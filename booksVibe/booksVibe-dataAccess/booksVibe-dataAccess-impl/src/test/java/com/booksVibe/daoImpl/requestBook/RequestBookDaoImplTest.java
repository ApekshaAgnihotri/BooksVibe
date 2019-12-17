package com.booksVibe.daoImpl.requestBook;

import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.*;
import com.booksVibe.dao.DTO.BooksDTO;
import com.booksVibe.dao.DTO.RequestBookDTO;
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.daoImpl.util.Utility;

@RunWith(MockitoJUnitRunner.class) 
public class RequestBookDaoImplTest {

	@InjectMocks
	private RequestBookDaoImpl requestBookDaoImpl;
	
	@InjectMocks
	private UserDTO userDTO;
	
	@InjectMocks
	private BooksDTO booksDTO;
	
	@InjectMocks
	private RequestBookDTO requestBookDTO;
	

	 static SessionFactory sessionFactory;
	    
     @BeforeClass
     public static void initFactory()
     {            
         sessionFactory=Utility.getSessionFactory();
     }
	
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}
		
	@Test
	public void testCountRequestedBooks()throws DaoException{
		userDTO.setEmaild("aman@gmail.com");
		requestBookDTO.setUserDTO(userDTO);
		assertNotNull(requestBookDaoImpl.countRequestedBooks(requestBookDTO));
		
	}
	
	@Test
	public void testCountHoldingBooks()throws DaoException{
		userDTO.setEmaild("aman@gmail.com");
		requestBookDTO.setUserDTO(userDTO);
		assertNotNull(requestBookDaoImpl.countHoldingBooks(requestBookDTO));
		
	}
	
	@Test
	public void testGetSubscriptionPlan()throws DaoException{
		userDTO.setEmaild("aman@gmail.com");
		requestBookDTO.setUserDTO(userDTO);
		assertNotNull(requestBookDaoImpl.getSubscribedPlan(requestBookDTO));
	}
	
	@Test
	public void testCheckIfPlanIsActive() throws DaoException{
	    userDTO.setEmaild("aman@gmail.com");
	    requestBookDTO.setUserDTO(userDTO);
	    assertNotNull(requestBookDaoImpl.checkIfPlanIsActive(requestBookDTO));
	}
	
	@Test
	public void testRequestBook()throws DaoException{
		userDTO.setEmaild("aman@gmail.com");
		booksDTO.setBookId(31);
		requestBookDTO.setBooksDTO(booksDTO);
		requestBookDTO.setUserDTO(userDTO);
		assertEquals(false,requestBookDaoImpl.ifAlreadyRequested(requestBookDTO));
		requestBookDaoImpl.requestBook(requestBookDTO);
		assertEquals(true,requestBookDaoImpl.ifAlreadyRequested(requestBookDTO));
		requestBookDaoImpl.cancelDeleiveryRequest(requestBookDTO);
		
		 
        Session session = sessionFactory.openSession();
         session.beginTransaction();
         session.delete(requestBookDTO);
         session.getTransaction().commit();
         session.close();
	}
	
	@Test
	public void testUpdateBookCopies()throws DaoException{
	    UserDTO operator=new UserDTO();
        operator.setEmaild("apeksha@gmail.com");
        booksDTO.setAuthor("David G Pugh & Terry R Bacon");
        booksDTO.setAvailability("available");
        booksDTO.setBookTitle("Society in India");
        booksDTO.setCategory("Novels");
        booksDTO.setCopies(10);
        booksDTO.setImageFileName("society in india.jpg");
        booksDTO.setLanguage("English");
        booksDTO.setOperator(operator);
        booksDTO.setPublisher("Popular Prakashan");
        booksDTO.setBookId(31);	
		requestBookDaoImpl.updateBookCopies(booksDTO);
	}
	
	@Test
	public void testViewRequestedBooks()throws DaoException{
		userDTO.setEmaild("aman@gmail.com");
		requestBookDTO.setUserDTO(userDTO);
		assertNotNull(requestBookDaoImpl.viewRequestedBooks(requestBookDTO));
	}
	
	@Test
	public void testViewIssuedBooks()throws DaoException{
		userDTO.setEmaild("aman@gmail.com");
		requestBookDTO.setUserDTO(userDTO);
		assertNotNull(requestBookDaoImpl.viewIssuedBooks(requestBookDTO));
	}
	
	@Test
	public void testGetBooksDetailsByBookId()throws DaoException{
		assertNotNull(requestBookDaoImpl.getBookDetailsById(31));

	}
	

	@Test
	public void testBookReturnRequest()throws DaoException{
		userDTO.setEmaild("aman@gmail.com");
		booksDTO.setBookId(31);
		requestBookDTO.setBooksDTO(booksDTO);
		requestBookDTO.setUserDTO(userDTO);
		requestBookDaoImpl.requestBook(requestBookDTO);
		requestBookDTO.setRequestStatus("approved");
		requestBookDaoImpl.bookReturnRequest(requestBookDTO);
		requestBookDaoImpl.cancelReturnRequest(requestBookDTO);
		 Session session = sessionFactory.openSession();
         session.beginTransaction();
         session.delete(requestBookDTO);
         session.getTransaction().commit();
         session.close();
	}
	
	@Test
	public void testViewToBeReturnedBooks()throws DaoException{
		userDTO.setEmaild("aman@gmail.com");
		assertNotNull(requestBookDaoImpl.viewToBeReturnedBooks(requestBookDTO));
	}
	

	
	@Test
	public void testViewMyHistory()throws DaoException{
		userDTO.setEmaild("aman@gmail.com");
		assertNotNull(requestBookDaoImpl.viewMyHistory(requestBookDTO));
	}
}
