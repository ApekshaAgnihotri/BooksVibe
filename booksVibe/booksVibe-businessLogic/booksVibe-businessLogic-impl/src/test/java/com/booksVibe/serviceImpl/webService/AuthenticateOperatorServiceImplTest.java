package com.booksVibe.serviceImpl.webService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.exceptions.InvalidUserException;
import com.booksVibe.dao.login.LoginManagerDao;
import com.booksVibe.dao.registration.RegManagerDao;
import com.booksVibe.daoImpl.registration.RegManagerDaoImpl;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticateOperatorServiceImplTest {

    
    @Mock
    private RegManagerDao regManagerDao;
    
    @Mock
    private LoginManagerDao loginManagerDao;
    
   
    
    @Mock
    private UserDTO userDTO;
    
    @InjectMocks
    private AuthenticateOperatorServiceImpl authenticateOperatorServiceImpl;
    
    @Test
    public void testRegisterOperator() throws DaoException, InvalidUserException{
        String emaild="emaild",password="password",firstName="firstName",lastName="lastName";
        String operatorEmaild="emaild",operatorPassword="password";
        when(loginManagerDao.loginVerify(userDTO)).thenReturn(userDTO);
       when(regManagerDao.registerOperator(userDTO)).thenReturn(true);
       authenticateOperatorServiceImpl.registerOperator(emaild,password,firstName,lastName,operatorEmaild,operatorPassword);
    }
    
    @Test
    public void testRegisterOperatorFalse() throws DaoException{
        String emaild="emaild",password="password",firstName="firstName",lastName="lastName";
        String operatorEmaild="emaild",operatorPassword="password";
        when(regManagerDao.registerOperator(userDTO)).thenReturn(false);
        authenticateOperatorServiceImpl.registerOperator(emaild,password,firstName,lastName,operatorEmaild,operatorPassword);
    }
    
    @Test
    public void testRegisterOperatorServiceException() throws DaoException{
        String emaild="emaild",password="password",firstName="firstName",lastName="lastName";
        String operatorEmaild="emaild",operatorPassword="password";
         doThrow(DaoException.class).when(regManagerDao).registerOperator(userDTO);
         authenticateOperatorServiceImpl.registerOperator(emaild,password,firstName,lastName,operatorEmaild,operatorPassword);
}
}
