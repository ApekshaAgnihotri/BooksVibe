package com.booksVibe.serviceImpl.requestBook;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.booksVibe.dao.DTO.BooksDTO;
import com.booksVibe.dao.DTO.RequestBookDTO;
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.DTO.UserSubsDTO;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.requestBook.RequestBookManagerDao;
import com.booksVibe.service.exceptions.BookAlreadyRequestedException;
import com.booksVibe.service.exceptions.RequestNotAllowedException;
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.exceptions.SubscriptionPlanExpiredServiceException;
import com.booksVibe.service.valueObject.BooksVO;
import com.booksVibe.service.valueObject.RequestBookVO;
import com.booksVibe.service.valueObject.UserValueObject;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class RequestBookManagerImplTest {

    
    @InjectMocks 
    private RequestBookManagerImpl requestBookManagerImpl;
    
    @InjectMocks
    private RequestBookVO requestBookVO;
    
    @InjectMocks
    private BooksVO booksVO;
    
    @InjectMocks
    private UserValueObject userValueObject;
    
    @Mock
    private RequestBookManagerDao requestBookManagerDao;
    
   @Spy
    private RequestBookDTO requestBookDTO=new RequestBookDTO();
    
    @Mock
    private BooksDTO booksDTO;
    
    @Mock
    private UserDTO userDTO;
    
    @Spy
    private UserSubsDTO userSubsDTO;
    
    
    @Test
    public void testViewRequestedBooks() throws DaoException, ServiceException{
        userValueObject.setEmaild("aman@gmail.com");
        booksVO.setBookId(0);
        requestBookVO.setUserVO(userValueObject);
        requestBookVO.setBooksVO(booksVO);
        List<RequestBookDTO> list=new ArrayList<RequestBookDTO>();
        when(requestBookManagerDao.viewRequestedBooks(requestBookDTO)).thenReturn(list);
        requestBookManagerImpl.viewRequestedBooks(requestBookVO);
    }
    @Test(expected=ServiceException.class)
    public void testViewRequestedBooksServiceException() throws DaoException, ServiceException{
        userValueObject.setEmaild("aman@gmail.com");
        booksVO.setBookId(0);
        requestBookVO.setUserVO(userValueObject);
        requestBookVO.setBooksVO(booksVO);
        List<RequestBookDTO> list=new ArrayList<RequestBookDTO>();
        doThrow(DaoException.class).when(requestBookManagerDao).viewRequestedBooks(requestBookDTO);
        requestBookManagerImpl.viewRequestedBooks(requestBookVO);
    }
    @Test
    public void testViewIssuedBooks() throws DaoException, ServiceException{
        userValueObject.setEmaild("aman@gmail.com");
        booksVO.setBookId(0);
        requestBookVO.setUserVO(userValueObject);
        requestBookVO.setBooksVO(booksVO);
        List<RequestBookDTO> list=new ArrayList<RequestBookDTO>();
        when(requestBookManagerDao.viewIssuedBooks(requestBookDTO)).thenReturn(list);
        requestBookManagerImpl.viewIssuedBooks(requestBookVO);
    }
    @Test(expected=ServiceException.class)
    public void testViewIssuedBooksServiceException() throws DaoException, ServiceException{
        userValueObject.setEmaild("aman@gmail.com");
        booksVO.setBookId(0);
        requestBookVO.setUserVO(userValueObject);
        requestBookVO.setBooksVO(booksVO);
        List<RequestBookDTO> list=new ArrayList<RequestBookDTO>();
        doThrow(DaoException.class).when(requestBookManagerDao).viewIssuedBooks(requestBookDTO);
        requestBookManagerImpl.viewIssuedBooks(requestBookVO);
    }
    
    @Test
    public void testViewToBeReturnedBooks() throws DaoException, ServiceException{
        userValueObject.setEmaild("aman@gmail.com");
        booksVO.setBookId(0);
        requestBookVO.setUserVO(userValueObject);
        requestBookVO.setBooksVO(booksVO);
        List<RequestBookDTO> list=new ArrayList<RequestBookDTO>();
        when(requestBookManagerDao.viewToBeReturnedBooks(requestBookDTO)).thenReturn(list);
        requestBookManagerImpl.viewToBeReturnedBooks(requestBookVO);
    }
    @Test(expected=ServiceException.class)
    public void testViewToBeReturnedBooksServiceException() throws DaoException, ServiceException{
        userValueObject.setEmaild("aman@gmail.com");
        booksVO.setBookId(0);
        requestBookVO.setUserVO(userValueObject);
        requestBookVO.setBooksVO(booksVO);
        List<RequestBookDTO> list=new ArrayList<RequestBookDTO>();
        doThrow(DaoException.class).when(requestBookManagerDao).viewToBeReturnedBooks(requestBookDTO);
        requestBookManagerImpl.viewToBeReturnedBooks(requestBookVO);
    }
    
    @Test
    public void testViewMyHistory() throws DaoException, ServiceException{
        userValueObject.setEmaild("aman@gmail.com");
        booksVO.setBookId(0);
        requestBookVO.setUserVO(userValueObject);
        requestBookVO.setBooksVO(booksVO);
        List<RequestBookDTO> list=new ArrayList<RequestBookDTO>();
        when(requestBookManagerDao.viewMyHistory(requestBookDTO)).thenReturn(list);
        requestBookManagerImpl.viewMyHistory(requestBookVO);
    }
    @Test(expected=ServiceException.class)
    public void testViewMyHistoryServiceException() throws DaoException, ServiceException{
        userValueObject.setEmaild("aman@gmail.com");
        booksVO.setBookId(0);
        requestBookVO.setUserVO(userValueObject);
        requestBookVO.setBooksVO(booksVO);
        List<RequestBookDTO> list=new ArrayList<RequestBookDTO>();
        doThrow(DaoException.class).when(requestBookManagerDao).viewMyHistory(requestBookDTO);
        requestBookManagerImpl.viewMyHistory(requestBookVO);
    }
    @Test
    public void testViewMyPlan() throws DaoException, ServiceException{
        userValueObject.setEmaild("aman@gmail.com");
        booksVO.setBookId(0);
        requestBookVO.setUserVO(userValueObject);
        requestBookVO.setBooksVO(booksVO);
        List<RequestBookDTO> list=new ArrayList<RequestBookDTO>();
        when(requestBookManagerDao.getSubscribedPlan(requestBookDTO)).thenReturn(userSubsDTO);
        requestBookManagerImpl.viewMyPlan(userValueObject);
    }
    @Test(expected=ServiceException.class)
    public void testViewMyPlanServiceException() throws DaoException, ServiceException{
        userValueObject.setEmaild("aman@gmail.com");
        booksVO.setBookId(0);
        requestBookVO.setUserVO(userValueObject);
        requestBookVO.setBooksVO(booksVO);
        List<RequestBookDTO> list=new ArrayList<RequestBookDTO>();
        doThrow(DaoException.class).when(requestBookManagerDao).getSubscribedPlan(requestBookDTO);
        requestBookManagerImpl.viewMyPlan(userValueObject);
    }
    
    @Test
    public void testCancelDeliveryRequest() throws DaoException, ServiceException{
        userValueObject.setEmaild("aman@gmail.com");
        booksVO.setBookId(0);
        requestBookVO.setUserVO(userValueObject);
        requestBookVO.setBooksVO(booksVO);
        BooksDTO bDto=new BooksDTO();
        doNothing().when(requestBookManagerDao).cancelDeleiveryRequest(requestBookDTO);
        when(requestBookManagerDao.getBookDetailsById(0)).thenReturn(bDto);
        doNothing().when(requestBookManagerDao).updateBookCopies(booksDTO);
        requestBookManagerImpl.cancelDeleiveryRequest(requestBookVO);
    }
    @Test(expected=ServiceException.class)
    public void testCancelDeliveryRequestServiceException() throws DaoException, ServiceException{
        userValueObject.setEmaild("aman@gmail.com");
        booksVO.setBookId(0);
        requestBookVO.setUserVO(userValueObject);
        requestBookVO.setBooksVO(booksVO);
        BooksDTO bDto=new BooksDTO();
        doThrow(DaoException.class).when(requestBookManagerDao).cancelDeleiveryRequest(requestBookDTO);
        when(requestBookManagerDao.getBookDetailsById(0)).thenReturn(bDto);
        doNothing().when(requestBookManagerDao).updateBookCopies(booksDTO);
        requestBookManagerImpl.cancelDeleiveryRequest(requestBookVO);
    }
    
    @Test
    public void testRequestBook() throws DaoException, ServiceException, BookAlreadyRequestedException, RequestNotAllowedException, SubscriptionPlanExpiredServiceException{
        userValueObject.setEmaild("aman@gmail.com");
        booksVO.setBookId(0);
        requestBookVO.setUserVO(userValueObject);
        requestBookVO.setBooksVO(booksVO);
        BooksDTO bDto=new BooksDTO();
        userSubsDTO.setMaxBooks(3);
        when(requestBookManagerDao.countHoldingBooks(requestBookDTO)).thenReturn(0);
        when(requestBookManagerDao.countRequestedBooks(requestBookDTO)).thenReturn(0);
        when(requestBookManagerDao.ifAlreadyRequested(requestBookDTO)).thenReturn(false);
        when(requestBookManagerDao.checkIfPlanIsActive(requestBookDTO)).thenReturn(true);
        when(requestBookManagerDao.getSubscribedPlan(requestBookDTO)).thenReturn(userSubsDTO);
        doNothing().when(requestBookManagerDao).requestBook(requestBookDTO);
        when(requestBookManagerDao.getBookDetailsById(0)).thenReturn(bDto);
        doNothing().when(requestBookManagerDao).updateBookCopies(bDto);
        requestBookManagerImpl.requestBook(requestBookVO);
    }
    
    @Test(expected=SubscriptionPlanExpiredServiceException.class)
    public void testRequestBookSubscriptionPlanExpriedException() throws DaoException, ServiceException, BookAlreadyRequestedException, RequestNotAllowedException, SubscriptionPlanExpiredServiceException{
        userValueObject.setEmaild("aman@gmail.com");
        booksVO.setBookId(0);
        requestBookVO.setUserVO(userValueObject);
        requestBookVO.setBooksVO(booksVO);
        BooksDTO bDto=new BooksDTO();
        when(requestBookManagerDao.countHoldingBooks(requestBookDTO)).thenReturn(0);
        when(requestBookManagerDao.countRequestedBooks(requestBookDTO)).thenReturn(0);
        when(requestBookManagerDao.ifAlreadyRequested(requestBookDTO)).thenReturn(false);
        when(requestBookManagerDao.checkIfPlanIsActive(requestBookDTO)).thenReturn(false);
        when(requestBookManagerDao.getSubscribedPlan(requestBookDTO)).thenReturn(userSubsDTO);
        doNothing().when(requestBookManagerDao).requestBook(requestBookDTO);
        when(requestBookManagerDao.getBookDetailsById(0)).thenReturn(bDto);
        doNothing().when(requestBookManagerDao).updateBookCopies(bDto);
        requestBookManagerImpl.requestBook(requestBookVO);
    }
    
    @Test(expected=BookAlreadyRequestedException.class)
    public void testRequestBookBookAlreadyRequestedException() throws DaoException, ServiceException, BookAlreadyRequestedException, RequestNotAllowedException, SubscriptionPlanExpiredServiceException{
        userValueObject.setEmaild("aman@gmail.com");
        booksVO.setBookId(0);
        requestBookVO.setUserVO(userValueObject);
        requestBookVO.setBooksVO(booksVO);
        BooksDTO bDto=new BooksDTO();
        userSubsDTO.setMaxBooks(2);
        when(requestBookManagerDao.countHoldingBooks(requestBookDTO)).thenReturn(0);
        when(requestBookManagerDao.countRequestedBooks(requestBookDTO)).thenReturn(0);
        when(requestBookManagerDao.ifAlreadyRequested(requestBookDTO)).thenReturn(true);
        when(requestBookManagerDao.checkIfPlanIsActive(requestBookDTO)).thenReturn(true);
        when(requestBookManagerDao.getSubscribedPlan(requestBookDTO)).thenReturn(userSubsDTO);
        doNothing().when(requestBookManagerDao).requestBook(requestBookDTO);
        when(requestBookManagerDao.getBookDetailsById(0)).thenReturn(bDto);
        doNothing().when(requestBookManagerDao).updateBookCopies(bDto);
        requestBookManagerImpl.requestBook(requestBookVO);
    }
    
    @Test(expected=RequestNotAllowedException.class)
    public void testRequestBookRequestNotAllowedException() throws DaoException, ServiceException, BookAlreadyRequestedException, RequestNotAllowedException, SubscriptionPlanExpiredServiceException{
        userValueObject.setEmaild("aman@gmail.com");
        booksVO.setBookId(0);
        requestBookVO.setUserVO(userValueObject);
        requestBookVO.setBooksVO(booksVO);
        BooksDTO bDto=new BooksDTO();
        when(requestBookManagerDao.countHoldingBooks(requestBookDTO)).thenReturn(3);
        when(requestBookManagerDao.countRequestedBooks(requestBookDTO)).thenReturn(4);
        when(requestBookManagerDao.ifAlreadyRequested(requestBookDTO)).thenReturn(false);
        when(requestBookManagerDao.checkIfPlanIsActive(requestBookDTO)).thenReturn(true);
        when(requestBookManagerDao.getSubscribedPlan(requestBookDTO)).thenReturn(userSubsDTO);
        doNothing().when(requestBookManagerDao).requestBook(requestBookDTO);
        when(requestBookManagerDao.getBookDetailsById(0)).thenReturn(bDto);
        doNothing().when(requestBookManagerDao).updateBookCopies(bDto);
        requestBookManagerImpl.requestBook(requestBookVO);
    }
    
    @Test(expected=ServiceException.class)
    public void testRequestBookServiceException() throws DaoException, ServiceException, BookAlreadyRequestedException, RequestNotAllowedException, SubscriptionPlanExpiredServiceException{
        userValueObject.setEmaild("aman@gmail.com");
        booksVO.setBookId(0);
        requestBookVO.setUserVO(userValueObject);
        requestBookVO.setBooksVO(booksVO);
        BooksDTO bDto=new BooksDTO();
        userSubsDTO.setMaxBooks(2);
        when(requestBookManagerDao.countHoldingBooks(requestBookDTO)).thenReturn(0);
        when(requestBookManagerDao.countRequestedBooks(requestBookDTO)).thenReturn(0);
        when(requestBookManagerDao.ifAlreadyRequested(requestBookDTO)).thenReturn(false);
        when(requestBookManagerDao.checkIfPlanIsActive(requestBookDTO)).thenReturn(true);
        when(requestBookManagerDao.getSubscribedPlan(requestBookDTO)).thenReturn(userSubsDTO);
        doThrow(DaoException.class).when(requestBookManagerDao).requestBook(requestBookDTO);
        when(requestBookManagerDao.getBookDetailsById(0)).thenReturn(bDto);
        doNothing().when(requestBookManagerDao).updateBookCopies(bDto);
        requestBookManagerImpl.requestBook(requestBookVO);
    }
    
    
    @Test
    public void testReturnRequest() throws DaoException, ServiceException{
        userValueObject.setEmaild("aman@gmail.com");
        booksVO.setBookId(0);
        requestBookVO.setUserVO(userValueObject);
        requestBookVO.setBooksVO(booksVO);
        BooksDTO bDto=new BooksDTO();
        doNothing().when(requestBookManagerDao).bookReturnRequest(requestBookDTO);
        requestBookManagerImpl.bookReturnRequest(requestBookVO);
    }
    @Test(expected=ServiceException.class)
    public void testReturnRequestServiceException() throws DaoException, ServiceException{
        userValueObject.setEmaild("aman@gmail.com");
        booksVO.setBookId(0);
        requestBookVO.setUserVO(userValueObject);
        requestBookVO.setBooksVO(booksVO);
        BooksDTO bDto=new BooksDTO();
        doThrow(DaoException.class).when(requestBookManagerDao).bookReturnRequest(requestBookDTO);
        requestBookManagerImpl.bookReturnRequest(requestBookVO);
    }
    
    @Test
    public void testCancelReturnRequest() throws DaoException, ServiceException{
        userValueObject.setEmaild("aman@gmail.com");
        booksVO.setBookId(0);
        requestBookVO.setUserVO(userValueObject);
        requestBookVO.setBooksVO(booksVO);
        BooksDTO bDto=new BooksDTO();
        doNothing().when(requestBookManagerDao).cancelReturnRequest(requestBookDTO);
        requestBookManagerImpl.cancelReturnRequest(requestBookVO);
    }
    @Test(expected=ServiceException.class)
    public void testCancelReturnRequestServiceException() throws DaoException, ServiceException{
        userValueObject.setEmaild("aman@gmail.com");
        booksVO.setBookId(0);
        requestBookVO.setUserVO(userValueObject);
        requestBookVO.setBooksVO(booksVO);
        BooksDTO bDto=new BooksDTO();
        doThrow(DaoException.class).when(requestBookManagerDao).cancelReturnRequest(requestBookDTO);
        requestBookManagerImpl.cancelReturnRequest(requestBookVO);
    }
    
}
