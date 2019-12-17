package com.booksVibe.daoImpl.requestHandler;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.assertNotNull;

import com.booksVibe.dao.DTO.BooksDTO;
import com.booksVibe.dao.DTO.RequestBookDTO;
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.daoImpl.requestBook.RequestBookDaoImpl;
import com.booksVibe.daoImpl.util.Utility;

@RunWith(MockitoJUnitRunner.class) 
public class RequestHandlerManagerDaoImplTest {

	
	
		
	@InjectMocks
	private RequestHandlerManagerDaoImpl requestHandlerManagerDaoImpl;
	
	@InjectMocks
	private RequestBookDaoImpl requestBookDaoImpl;
	
    
    @InjectMocks
    private BooksDTO booksDTO;
    
    @InjectMocks
    private RequestBookDTO requestBookDTO;
	
	@InjectMocks
	private UserDTO userDTO;
	
	 static SessionFactory sessionFactory;
     
     @BeforeClass
     public static void initFactory()
     {            
         sessionFactory=Utility.getSessionFactory();
     }
	
	@Test(expected=DaoException.class)
	public void testViewRequestedBooksDaoException()throws DaoException{
	    
          assertNotNull(requestHandlerManagerDaoImpl.viewRequestedBooks(userDTO));
	}
	
	@Test(expected=DaoException.class)
	public void testViewBooksToBeReturnedDaoException() throws DaoException{
		assertNotNull(requestHandlerManagerDaoImpl.viewBooksToBeReturned(userDTO));
	}
	
	@Test
	public void testViewUsers()throws DaoException{
		assertNotNull(requestHandlerManagerDaoImpl.viewUsers());
	}
	@Test
    public void testViewRequestedBooks()throws DaoException{
	    userDTO.setEmaild("apeksha.agnihotri@impetus.co.in");
          assertNotNull(requestHandlerManagerDaoImpl.viewRequestedBooks(userDTO));
    }
    
    @Test
    public void testViewBooksToBeReturned() throws DaoException{
        userDTO.setEmaild("apeksha.agnihotri@impetus.co.in");
        assertNotNull(requestHandlerManagerDaoImpl.viewBooksToBeReturned(userDTO));
    }
    
	
	
	@Test
	public void testApproveDeleiveryRequest()throws DaoException{
	    userDTO.setEmaild("aman@gmail.com");
        booksDTO.setBookId(31);
        requestBookDTO.setBooksDTO(booksDTO);
        requestBookDTO.setUserDTO(userDTO);
        requestBookDaoImpl.requestBook(requestBookDTO);
	    requestHandlerManagerDaoImpl.approveDeleiveryRequest(requestBookDTO.getRequestId());
	    
	    Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(requestBookDTO);
        session.getTransaction().commit();
        session.close();
	}
	
	

	@Test
    public void testCloseReturnRequest()throws DaoException{
        userDTO.setEmaild("aman@gmail.com");
        booksDTO.setBookId(31);
        requestBookDTO.setBooksDTO(booksDTO);
        requestBookDTO.setUserDTO(userDTO);
        requestBookDaoImpl.requestBook(requestBookDTO);
        requestBookDTO.setRequestStatus("approved");
        requestBookDaoImpl.bookReturnRequest(requestBookDTO);
        requestHandlerManagerDaoImpl.closeReturnRequest(requestBookDTO.getRequestId());
        
         Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(requestBookDTO);
            session.getTransaction().commit();
            session.close();
    }
}
