package com.booksVibe.serviceImpl.books;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import com.booksVibe.dao.DTO.BooksDTO;
import com.booksVibe.dao.DTO.ListCarrier;
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.books.BooksManagerDao;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.exceptions.NoDeleteException;

import com.booksVibe.service.exceptions.NoDeleteServiceException;
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.valueObject.BooksVO;
import com.booksVibe.service.valueObject.ListCarrierVO;
import com.booksVibe.service.valueObject.UserValueObject;

@RunWith(MockitoJUnitRunner.class)
public class BooksManagerImplTest {
  
  @Mock
  private BooksManagerDao booksManagerDao;
  
  @InjectMocks
  private BooksManagerImpl booksManagerImpl;
  
  @InjectMocks
  private BooksVO booksVO;
  
  @InjectMocks
  private UserValueObject userValueObject;
  
  @Mock
  private BooksDTO booksDTO;
  
  @Mock 
  private UserDTO userDTO;
  
  
	
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
		
	}
	
	@Test
	public void testAddBooksTrue() throws DaoException, ServiceException{
	    booksVO.setBookId(0);
		when(booksManagerDao.addBooks(booksDTO,userDTO)).thenReturn(true);
		assertEquals(true,booksManagerImpl.addBooks(booksVO,userValueObject));
		
		
	}
	
	@Test
	public void testAddBooksFalse() throws DaoException, ServiceException{
	    booksVO.setBookId(0);
		when(booksManagerDao.addBooks(booksDTO,userDTO)).thenReturn(false);
		assertEquals(false,booksManagerImpl.addBooks(booksVO,userValueObject));
		
	}
	
	@Test(expected=ServiceException.class)
	public void testAddBooksServiceException() throws DaoException, ServiceException{
	    booksVO.setBookId(0);
		doThrow(DaoException.class).when(booksManagerDao).addBooks(booksDTO,userDTO);
		booksManagerImpl.addBooks(booksVO,userValueObject);
	}
	
	@Test
	public void testBooksById() throws DaoException, ServiceException{
		BooksDTO booksDTO=new BooksDTO();
		when(booksManagerDao.booksById(3)).thenReturn(booksDTO);
		booksVO=booksManagerImpl.booksById(3);
	}
	
	@Test(expected=ServiceException.class)
	public void testBooksByIdServiceException() throws DaoException, ServiceException{
		doThrow(DaoException.class).when(booksManagerDao).booksById(3);
		booksManagerImpl.booksById(3);
	}
	
	
	@Test
	public void testLoadBooksDetails() throws DaoException, ServiceException{
	    List<BooksDTO> list=new ArrayList<BooksDTO>();
        ListCarrier listCarrier=new ListCarrier();
        listCarrier.setBooksListDTO(list);
		when(booksManagerDao.loadBooksDetails(1,userDTO)).thenReturn(listCarrier);
		ListCarrierVO listVO=booksManagerImpl.loadBooksDetails(1,userValueObject);
		
	}
	
	@Test(expected=ServiceException.class)
	public void testLoadBooksDetailsServiceException() throws DaoException, ServiceException{
	    List<BooksDTO> list=new ArrayList<BooksDTO>();
        ListCarrier listCarrier=new ListCarrier();
        listCarrier.setBooksListDTO(list);
        doThrow(DaoException.class).when(booksManagerDao).loadBooksDetails(1,userDTO);
       booksManagerImpl.loadBooksDetails(1,userValueObject);
	}
	
	@Test
	public void testUpdateBook() throws DaoException, ServiceException{
	   doNothing().when(booksManagerDao).updateBooks(booksDTO);
	   booksManagerImpl.updateBooks(booksVO);
	}

	@Test(expected=ServiceException.class)
	public void testUpdateBookServiceException() throws DaoException, ServiceException{
	    doThrow(DaoException.class).when(booksManagerDao).updateBooks(booksDTO);
	    booksManagerImpl.updateBooks(booksVO);
	}
	
	@Test
	public void testDeleteBooks() throws DaoException, NoDeleteException, ServiceException, NoDeleteServiceException{
	    doNothing().when(booksManagerDao).deleteBooks(0);
	    booksManagerImpl.deleteBooks(0);
	}
	
//	@Test(expected=NoDeleteServiceException.class)
//	public void testDeleteBooksNoDeleteException() throws DaoException, NoDeleteException, ServiceException, NoDeleteServiceException{
//	    doThrow(NoDeleteException.class).when(booksManagerDao).deleteBooks(0);
//	    booksManagerImpl.deleteBooks(0);
//	}
//	
	@Test(expected=ServiceException.class)
	public void testDeleteBooksServiceException() throws DaoException, NoDeleteException, ServiceException, NoDeleteServiceException{
	    doThrow(DaoException.class).when(booksManagerDao).deleteBooks(0);
	    booksManagerImpl.deleteBooks(0);
	}
	
	@Test
	public void testSearchBooks() throws DaoException, ServiceException{
	    List<BooksDTO> list=new ArrayList<BooksDTO>();
	    ListCarrier listCarrier=new ListCarrier();
	    listCarrier.setBooksListDTO(list);
	    String emailId="aditya.solge@impetus.co.in";
	    when(booksManagerDao.searchBooks(booksDTO, 0, emailId)).thenReturn(listCarrier);
	    booksManagerImpl.searchBooks(booksVO, 0, emailId);
	}
	
	@Test(expected=ServiceException.class)
	public void testSearchBooksServiceException() throws DaoException, ServiceException{
	    String emailId="aditya.solge@impetus.co.in";
	    doThrow(DaoException.class).when(booksManagerDao).searchBooks(booksDTO,0,emailId);
	    booksManagerImpl.searchBooks(booksVO, 0, emailId);
	}
	
	@Test
	public void testNewArrivals() throws DaoException, ServiceException{
	    String emailId="aditya.solge@impetus.co.in";
	    List<BooksDTO> list=new ArrayList<BooksDTO>();
	    when(booksManagerDao.newArrivals(emailId)).thenReturn(list);
	    List<BooksVO> booksList=booksManagerImpl.newArrivals(emailId);
	}
	
	@Test(expected=ServiceException.class) 
	public void testNewArrivalsServiceException() throws DaoException, ServiceException{
	    String emailId="aditya.solge@impetus.co.in";
	    doThrow(DaoException.class).when(booksManagerDao).newArrivals(emailId);
	    booksManagerImpl.newArrivals(emailId);
	}
}
