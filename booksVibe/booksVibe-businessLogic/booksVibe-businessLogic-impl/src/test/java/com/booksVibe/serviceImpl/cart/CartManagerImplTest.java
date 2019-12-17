package com.booksVibe.serviceImpl.cart;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import com.booksVibe.dao.DTO.BooksDTO;
import com.booksVibe.dao.DTO.UserBookShelfDTO;
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.exceptions.AlreadyInShelfException;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.userBookShelf.UserBookShelfManagerDao;
import com.booksVibe.service.exceptions.AlreadyInShelfServiceException;
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.valueObject.BooksVO;
import com.booksVibe.service.valueObject.UserBookShelfVO;
import com.booksVibe.service.valueObject.UserValueObject;
import com.booksVibe.serviceImpl.userBookShelf.UserBookShelfManagerImpl;

@RunWith(MockitoJUnitRunner.class)
public class CartManagerImplTest {

    @InjectMocks
    UserBookShelfManagerImpl cartManagerImpl;
    
    @InjectMocks
    UserBookShelfVO userCartVO;
    
    @InjectMocks
    UserValueObject userValueObject;
    
    @InjectMocks
    BooksVO booksVO;
    
    @Mock
    UserBookShelfManagerDao cartManagerDao;
    
    @Mock
    UserBookShelfDTO userCartDTO;
    
    @Mock
    UserDTO userDTO;
    
    @Mock
    BooksDTO booksDTO;
    
    
    
  @Test
  public void testAddToCart() throws DaoException, AlreadyInShelfException, ServiceException, AlreadyInShelfServiceException{
      userValueObject.setEmaild("aman@gmail.com");
      booksVO.setBookId(0);
      userCartVO.setUserVO(userValueObject);
      userCartVO.setBooksVO(booksVO);
      doNothing().when(cartManagerDao).addToShelf(userCartDTO);
      cartManagerImpl.addToShelf(userCartVO);
  }
  
  @Test(expected=AlreadyInShelfServiceException.class)
  public void testAddToCartALreadyInCartException() throws DaoException, AlreadyInShelfException, ServiceException, AlreadyInShelfServiceException{
      userValueObject.setEmaild("aman@gmail.com");
      booksVO.setBookId(0);
      userCartVO.setUserVO(userValueObject);
      userCartVO.setBooksVO(booksVO);
      doThrow(AlreadyInShelfException.class).when(cartManagerDao).addToShelf(userCartDTO);
      cartManagerImpl.addToShelf(userCartVO);
  }
  
  @Test(expected=ServiceException.class)
  public void testAddToCartServiceException() throws DaoException, AlreadyInShelfException, ServiceException, AlreadyInShelfServiceException{
      userValueObject.setEmaild("aman@gmail.com");
      booksVO.setBookId(0);
      userCartVO.setUserVO(userValueObject);
      userCartVO.setBooksVO(booksVO);
      doThrow(DaoException.class).when(cartManagerDao).addToShelf(userCartDTO);
      cartManagerImpl.addToShelf(userCartVO);    
  }
  
  @Test
  public void testDeleteFromCart() throws DaoException, ServiceException{
      userValueObject.setEmaild("aman@gmail.com");
      booksVO.setBookId(0);
      userCartVO.setUserVO(userValueObject);
      userCartVO.setBooksVO(booksVO);
      doNothing().when(cartManagerDao).deleteFromShelf(userCartDTO);
      cartManagerImpl.deleteFromShelf(userCartVO);
  }
  
  @Test(expected=ServiceException.class)
  public void testDeleteFromCartServiceException() throws DaoException, ServiceException{
      userValueObject.setEmaild("aman@gmail.com");
      booksVO.setBookId(0);
      userCartVO.setUserVO(userValueObject);
      userCartVO.setBooksVO(booksVO);
      doThrow(DaoException.class).when(cartManagerDao).deleteFromShelf(userCartDTO);
      cartManagerImpl.deleteFromShelf(userCartVO);
  }
  
  @Test
  public void testViewMyCart() throws DaoException, ServiceException{
      userValueObject.setEmaild("aman@gmail.com");
      booksVO.setBookId(0);
      userCartVO.setUserVO(userValueObject);
      userCartVO.setBooksVO(booksVO);
      List<UserBookShelfDTO> list=new ArrayList();
      when(cartManagerDao.viewMyShelf(userCartDTO)).thenReturn(list);
      List<UserBookShelfVO> cartVO=cartManagerImpl.viewMyShelf(userCartVO);
      
  }
  
  @Test(expected=ServiceException.class)
  public void testViewMyCartServiceException() throws DaoException, ServiceException{
      userValueObject.setEmaild("aman@gmail.com");
      booksVO.setBookId(0);
      userCartVO.setUserVO(userValueObject);
      userCartVO.setBooksVO(booksVO);
      List<UserBookShelfDTO> list=new ArrayList();
      doThrow(DaoException.class).when(cartManagerDao).viewMyShelf(userCartDTO);
      cartManagerImpl.viewMyShelf(userCartVO);
  }
}
