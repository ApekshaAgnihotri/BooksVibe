package com.booksVibe.daoImpl.userBookShelf;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.booksVibe.dao.DTO.BooksDTO;
import com.booksVibe.dao.DTO.UserBookShelfDTO;
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.exceptions.AlreadyInShelfException;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.daoImpl.userBookShelf.UserBookShelfManagerDaoImpl;
import com.booksVibe.daoImpl.util.Utility;

import static org.junit.Assert.assertNotNull;


@RunWith(MockitoJUnitRunner.class)
public class UserBookShelfManagerDaoImplTest {

	@InjectMocks
	private UserDTO userDTO;
	
	@InjectMocks
	private BooksDTO booksDTO;
	
	
	@InjectMocks
	private UserBookShelfManagerDaoImpl shelfManagerDaoImpl;
	
	@InjectMocks
	private UserBookShelfDTO userShelfDTO;

	   static SessionFactory sessionFactory;
	    
	        @BeforeClass
	        public static void initFactory()
	        {            
	            sessionFactory=Utility.getSessionFactory();
	        }
	
	@Test
	public void testAddToShelf()throws DaoException,AlreadyInShelfException{
	
		userDTO.setEmaild("aman@gmail.com");
		booksDTO.setBookId(31);
		userShelfDTO.setBooksDTO(booksDTO);
		userShelfDTO.setUserDTO(userDTO);
		
		shelfManagerDaoImpl.addToShelf(userShelfDTO);
		
		
		
		Session session = sessionFactory.openSession();
        session.beginTransaction();
        shelfManagerDaoImpl.deleteFromShelf(userShelfDTO);
        session.getTransaction().commit();
        session.close();
		
		
	}
	
	@Test(expected=AlreadyInShelfException.class)
	public void testAddToShelfAlreadyInShelfException()throws DaoException,AlreadyInShelfException{
		
			userDTO.setEmaild("aman@gmail.com");
			booksDTO.setBookId(32);
			userShelfDTO.setBooksDTO(booksDTO);
			userShelfDTO.setUserDTO(userDTO);
			
			shelfManagerDaoImpl.addToShelf(userShelfDTO);
			shelfManagerDaoImpl.addToShelf(userShelfDTO);
			Session session = sessionFactory.openSession();
	        session.beginTransaction();
	        shelfManagerDaoImpl.deleteFromShelf(userShelfDTO);
	        session.getTransaction().commit();
	        session.close();
			
	}
	
	@Test
	public void testViewMyShelf()throws DaoException{
		userDTO.setEmaild("aman@gmail.com");
		userShelfDTO.setUserDTO(userDTO);
		assertNotNull(shelfManagerDaoImpl.viewMyShelf(userShelfDTO));
	}
	
	
}
