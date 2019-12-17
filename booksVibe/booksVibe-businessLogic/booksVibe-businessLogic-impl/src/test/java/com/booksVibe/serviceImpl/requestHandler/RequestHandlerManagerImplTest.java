package com.booksVibe.serviceImpl.requestHandler;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Incubating;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.booksVibe.dao.DTO.RequestBookDTO;
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.DTO.UserSubsDTO;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.requestHandler.RequestHandlerManagerDao;
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.valueObject.BooksVO;
import com.booksVibe.service.valueObject.RequestBookVO;
import com.booksVibe.service.valueObject.UserSubsVO;
import com.booksVibe.service.valueObject.UserValueObject;

@RunWith(MockitoJUnitRunner.class)
public class RequestHandlerManagerImplTest {

    @InjectMocks
    private RequestHandlerMangerImpl requestHandlerMangerImpl;
    
    @InjectMocks
    private RequestBookVO requestBookVO;
    
    @InjectMocks
    private UserValueObject userValueObject;
    
    @InjectMocks
    private BooksVO booksVO;
    
    @Mock
    private RequestHandlerManagerDao requestHandlerManagerDao;
    
    @Mock
    private RequestBookDTO requestBookDTO;
    
    @Mock
    private UserDTO userDTO;
    
    @Test
    public void testViewRequestedBooks() throws DaoException, ServiceException{
        List<RequestBookVO> list=new ArrayList<RequestBookVO>();
        List<RequestBookDTO> listDTO=new ArrayList<RequestBookDTO>();
        when(requestHandlerManagerDao.viewRequestedBooks(userDTO)).thenReturn(listDTO);
        assertNotNull(requestHandlerMangerImpl.viewRequestedBooks(userValueObject));
    }
    
    @Test(expected=ServiceException.class)
    public void testViewRequestedBooksServiceException() throws DaoException, ServiceException{
        doThrow(DaoException.class).when(requestHandlerManagerDao).viewRequestedBooks(userDTO);
        requestHandlerMangerImpl.viewRequestedBooks(userValueObject);
    }
    
    @Test
    public void testViewToBeReturnedBooks() throws DaoException, ServiceException{
        List<RequestBookVO> list=new ArrayList<RequestBookVO>();
        List<RequestBookDTO> listDTO=new ArrayList<RequestBookDTO>();
        when(requestHandlerManagerDao.viewBooksToBeReturned(userDTO)).thenReturn(listDTO);
        assertNotNull(requestHandlerMangerImpl.viewBooksToBeReturned(userValueObject));
    }
    
    @Test(expected=ServiceException.class)
    public void testViewToBeReturnedBooksServiceException() throws DaoException, ServiceException{
        doThrow(DaoException.class).when(requestHandlerManagerDao).viewBooksToBeReturned(userDTO);
        requestHandlerMangerImpl.viewBooksToBeReturned(userValueObject);
    }
    
    @Test
    public void testApproveDeliveryRequest() throws DaoException, ServiceException{
        doNothing().when(requestHandlerManagerDao).approveDeleiveryRequest(0);
        requestHandlerMangerImpl.approveDeleiveryRequest(0);
    }
    
    @Test(expected=ServiceException.class)
    public void testApproveDeliveryRequestServiceException() throws ServiceException, DaoException{
        doThrow(DaoException.class).when(requestHandlerManagerDao).approveDeleiveryRequest(0);
        requestHandlerMangerImpl.approveDeleiveryRequest(0);
    }
    
    @Test
    public void testCloseReturnRequest() throws DaoException, ServiceException{
        doNothing().when(requestHandlerManagerDao).closeReturnRequest(0);
        requestHandlerMangerImpl.closeReturnRequest(0);
        
    }
    
    @Test(expected=ServiceException.class)
    public void testCloseReturnRequestServiceException() throws DaoException, ServiceException{
        doThrow(DaoException.class).when(requestHandlerManagerDao).closeReturnRequest(0);
        requestHandlerMangerImpl.closeReturnRequest(0);
        
    }
    
    @Test
    public void testViewUser() throws DaoException, ServiceException{
        
        List<UserSubsDTO> listDTO=new ArrayList<UserSubsDTO>();
        when(requestHandlerManagerDao.viewUsers()).thenReturn(listDTO);
        assertNotNull(requestHandlerMangerImpl.viewUsers());
    }
    
    @Test(expected=ServiceException.class)
    public void testViewUsersServiceException() throws DaoException, ServiceException{
        doThrow(DaoException.class).when(requestHandlerManagerDao).viewUsers();
        requestHandlerMangerImpl.viewUsers();
    }
}
