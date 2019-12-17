package com.booksVibe.serviceImpl.recommendation;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.booksVibe.dao.DTO.BooksDTO;
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.recommendation.RecommendBooksDao;
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.valueObject.BooksVO;
import com.booksVibe.service.valueObject.UserValueObject;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class RecommendBooksManagerImplTest {

   @InjectMocks
   private RecommendBooksManagerImpl recommendBooksManagerImpl;
    
   @InjectMocks
   private UserValueObject userValueObject;
    
   @InjectMocks
   private BooksVO booksVO;
    
   @Mock
   private BooksDTO booksDTO;
    
   @Mock
   private RecommendBooksDao recommendBooksDao;
   
   @InjectMocks
   private List<BooksDTO> list=new ArrayList<BooksDTO>();
   
   @Mock
   private UserDTO userDTO;
   
   
   @Test
   public void testGetRecommendedBooks() throws DaoException, ServiceException{
       list.add(new BooksDTO());
       userValueObject.setEmaild("aman@gmail.com");
       when(recommendBooksDao.getRecommendedBook(userDTO)).thenReturn(list);
       assertNotNull(recommendBooksManagerImpl.getRecommendedBooks(userValueObject));
       
   }
   
   @Test(expected=ServiceException.class)
   public void testGetRecommendedBooksServiceException() throws DaoException, ServiceException{
       list.add(new BooksDTO());
       userValueObject.setEmaild("aman@gmail.com");
       doThrow(DaoException.class).when(recommendBooksDao).getRecommendedBook(userDTO);
       recommendBooksManagerImpl.getRecommendedBooks(userValueObject);
   }
   
   @Test
   public void testRecommendBooks() throws DaoException, ServiceException{
       doNothing().when(recommendBooksDao).recommendBooks();
       recommendBooksManagerImpl.recommendBooks();
   }
   
   @Test(expected=ServiceException.class)
   public void testRecommendBooksServiceException() throws DaoException, ServiceException{
       doThrow(DaoException.class).when(recommendBooksDao).recommendBooks();
       recommendBooksManagerImpl.recommendBooks();
   }
}
