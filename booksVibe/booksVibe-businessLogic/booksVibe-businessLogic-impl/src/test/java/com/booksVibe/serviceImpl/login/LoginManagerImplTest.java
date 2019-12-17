package com.booksVibe.serviceImpl.login;

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
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.DTO.UserSubsDTO;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.exceptions.InvalidUserException;
import com.booksVibe.dao.exceptions.SubscriptionPlanExpiredException;

import com.booksVibe.dao.login.LoginManagerDao;
import com.booksVibe.service.exceptions.InvalidUserServiceExcpetion;
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.valueObject.UserSubsVO;
import com.booksVibe.service.valueObject.UserValueObject;

@RunWith(MockitoJUnitRunner.class)
public class LoginManagerImplTest {
	
	@InjectMocks
	private LoginManagerImpl loginManagerImpl;

	@InjectMocks
	private UserValueObject userValueObject;
	
	@Mock
	private LoginManagerDao loginManagerDaoImpl;
	
	@Mock
	private UserDTO userDTO; 
	
	private UserDTO userDTO1;
	
	
	
	
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	    userDTO1=new UserDTO();
	    userDTO1.setEmaild("aman@gmail.com");
	    userDTO1.setPassword("6d4d4120b2b51a8b83e229640780d19d");
	     
	}
	
	@Test
	public void testLoginVerify()throws ServiceException, InvalidUserServiceExcpetion, DaoException, InvalidUserException, SubscriptionPlanExpiredException{
		userValueObject.setEmaild("aman@gmail.com");
		userValueObject.setPassword("6d4d4120b2b51a8b83e229640780d19d");
		userValueObject.setRole("user");
		when(loginManagerDaoImpl.loginVerify(userDTO)).thenReturn(userDTO1);
		userValueObject=loginManagerImpl.loginVerify(userValueObject);
		assertEquals("aman@gmail.com",userValueObject.getEmaild());
	}
	@Test(expected=InvalidUserServiceExcpetion.class)
	public void testLoginVerifyInvalidUserServiceException() throws DaoException, InvalidUserException, ServiceException, InvalidUserServiceExcpetion, SubscriptionPlanExpiredException{
		
		userValueObject.setEmaild("abcd");
		userValueObject.setPassword("abcd");
		userValueObject.setRole("user");
		doThrow(InvalidUserException.class).when(loginManagerDaoImpl).loginVerify(userDTO);
		userValueObject=loginManagerImpl.loginVerify(userValueObject);
		
	}
	@Test(expected=ServiceException.class)
	public void testLoginVerifyServiceException() throws DaoException, ServiceException, InvalidUserServiceExcpetion, InvalidUserException, SubscriptionPlanExpiredException{
	    userValueObject.setEmaild("abcd");
        userValueObject.setPassword("abcd");
        userValueObject.setRole("user");
		doThrow(DaoException.class).when(loginManagerDaoImpl).loginVerify(userDTO);
		loginManagerImpl.loginVerify(userValueObject);
		
	}
	
	@Test
	public void testUpdateUserDetails() throws DaoException, ServiceException{
		UserValueObject userValueObject=new UserValueObject();
		userValueObject.setEmaild("aman@gmail.com");
		userValueObject.setFirstname("Aman");
		doNothing().when(loginManagerDaoImpl).updateUserDetails(userDTO);
		loginManagerImpl.updateUserDetails(userValueObject);
		
	}
	
	@Test(expected=ServiceException.class)
	public void testUpdateUserDetailsServiceException() throws DaoException, ServiceException{
		doThrow(DaoException.class).when(loginManagerDaoImpl).updateUserDetails(userDTO);
		loginManagerImpl.updateUserDetails(userValueObject);
	}
	
	@Test
	public void testUpgradePlan() throws DaoException, ServiceException{
		userValueObject.setEmaild("aman@gmail.com");
		doNothing().when(loginManagerDaoImpl).upgradePlan(userDTO,3);
		loginManagerImpl.upgradePlan(userValueObject, 3);
	}
	
	@Test(expected=ServiceException.class)
	public void testUpgradePlanServiceException() throws DaoException, ServiceException{
		doThrow(DaoException.class).when(loginManagerDaoImpl).upgradePlan(userDTO, 3);
		loginManagerImpl.upgradePlan(userValueObject, 3);
		
	}
	
	@Test
	public void testViewSubscriptionHistory() throws DaoException, ServiceException{
	    List<UserSubsDTO> list=new ArrayList<UserSubsDTO>();
		when(loginManagerDaoImpl.viewSubscriptionHistory(userDTO)).thenReturn(list);
		List<UserSubsVO> listVO=loginManagerImpl.viewSubscriptionHistory(userValueObject);
		assertEquals(listVO.size(), list.size());
		
	}
	
	@Test(expected=ServiceException.class)
	public void testViewSubscriptionHistoryServiceException() throws DaoException, ServiceException{
		doThrow(DaoException.class).when(loginManagerDaoImpl).viewSubscriptionHistory(userDTO);
		loginManagerImpl.viewSubscriptionHistory(userValueObject);
	}
}

