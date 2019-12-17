package com.booksVibe.daoImpl.recommendation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.assertNotNull;

import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.exceptions.DaoException;

@RunWith(MockitoJUnitRunner.class) 
public class RecommendBooksDaoImplTest {

	@InjectMocks
	private RecommendBooksDaoImpl recommendBooksDaoImpl;
	
	@InjectMocks
	private UserDTO userDTO;
	
	@Test
	public void testGetRecommendedBook()throws DaoException{
		userDTO.setEmaild("aman@gmail.com");
		assertNotNull(recommendBooksDaoImpl.getRecommendedBook(userDTO));
	}
	
    @Test
    public void testRecommendBooks()throws DaoException{
      recommendBooksDaoImpl.recommendBooks();
    }
	
}
