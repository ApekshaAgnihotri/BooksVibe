package com.booksVibe.serviceImpl.registration;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Incubating;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.booksVibe.dao.DTO.SubsDetailsDTO;
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.DTO.UserSubsDTO;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.registration.RegManagerDao;
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.registration.RegistrationManager;
import com.booksVibe.service.valueObject.UserValueObject;
import com.booksVibe.util.encryption.EncryptPassword;
import com.booksVibe.util.exception.UtilException;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationManagerImplTest {

    @InjectMocks
    private RegistrationManagerImpl registrationManagerImpl;
    
    @InjectMocks
    private UserValueObject userValueObject;
    
    @Mock
    private RegManagerDao regManagerDao;
    
    @Mock
    private UserDTO userDTO;
    
    @InjectMocks
    private List<SubsDetailsDTO> list=new ArrayList<SubsDetailsDTO>();
   
        
    
    
    @Test
    public void testRegisterUserTure() throws DaoException, ServiceException{
        userValueObject.setEmaild("aman@gmail.com");
        userValueObject.setPassword("sometimesi");
        when(regManagerDao.registerUser(userDTO)).thenReturn(true);
        assertEquals(true,registrationManagerImpl.registerUser(userValueObject));
    }
    
    @Test
    public void testRegisterUserFalse() throws DaoException, ServiceException{
        userValueObject.setEmaild("aman@gmail.com");
        userValueObject.setPassword("sometimesi");
        when(regManagerDao.registerUser(userDTO)).thenReturn(false);
        assertEquals(false,registrationManagerImpl.registerUser(userValueObject)); 
    }
    
    @Test(expected=ServiceException.class)
    public void testRegisterUserServiceException() throws DaoException, ServiceException{
        userValueObject.setEmaild("aman@gmail.com");
        userValueObject.setPassword("sometimesi");
        doThrow(DaoException.class).when(regManagerDao).registerUser(userDTO);
        registrationManagerImpl.registerUser(userValueObject);
    }
    
//    @Test(expected=UtilException.class)
//    public void testRegisterUserUtilException() throws DaoException, ServiceException, UtilException{
//        userValueObject.setPassword("aaa");
//        doThrow(NoSuchAlgorithmException.class).when(EncryptPassword.md5(userValueObject.getPassword()));
//        doNothing().when(regManagerDao.registerUser(userDTO));
//        registrationManagerImpl.registerUser(userValueObject);
//    }
    @Test
    public void testLoadSubscription() throws DaoException, ServiceException{
        list.add(new SubsDetailsDTO());
        when(regManagerDao.loadSubscription()).thenReturn(list);
        assertNotNull(registrationManagerImpl.loadSubscription());
    }
    
    @Test(expected=ServiceException.class)
    public void testLoadSubscriptionServiceException() throws DaoException, ServiceException{
        doThrow(DaoException.class).when(regManagerDao).loadSubscription();
        registrationManagerImpl.loadSubscription();
    }
    
    @Test
    public void testCheckStatus() throws DaoException, ServiceException{
        String emaild="aman@gmail.com";
        when(regManagerDao.checkStatus(null)).thenReturn(false);
        assertEquals(false,registrationManagerImpl.checkStatus(emaild));
    }
    
    
    @Test(expected=ServiceException.class)
    public void testCheckStatusServiceException() throws DaoException, ServiceException{
        String emaild="aman@gmail.com";
        doThrow(DaoException.class).when(regManagerDao).checkStatus(emaild);
        registrationManagerImpl.checkStatus(emaild);
    }
    
}
