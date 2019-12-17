package com.booksVibe.daoImpl.login;
import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.booksVibe.dao.DTO.SubsDetailsDTO;
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.DTO.UserSubsDTO;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.exceptions.InvalidUserException;
import com.booksVibe.daoImpl.util.Utility;




@RunWith(MockitoJUnitRunner.class)  
public class LoginManagerDaoImplTest  {
	
    static SessionFactory sessionFactory;
    
    @BeforeClass
    public static void initFactory()
    {            
        sessionFactory=Utility.getSessionFactory();
    }

    
    @InjectMocks
	private LoginManagerDaoImpl loginManagerDaoImpl;
	
    @InjectMocks
	private UserDTO userDTO;
	
  @InjectMocks
    private UserSubsDTO userSubsDTO;
   
   
    
	@Test
	public void testLoginVerify() throws DaoException,InvalidUserException{

		userDTO.setEmaild("apeksha@gmail.com");
		userDTO.setPassword("a03159299e83f4f3d77b6f2400ae4fce");
		userDTO.setRole("admin");
		userDTO=loginManagerDaoImpl.loginVerify(userDTO);
		assertEquals("apeksha",userDTO.getFirstname());
	
	}
	
	@Test(expected=InvalidUserException.class)
	public void testLoginVerifyInvalidUserException()throws DaoException,InvalidUserException{
		userDTO.setEmaild("apeksha.agnihotri@impetus.co.in");
		userDTO.setPassword("wrongPassword");
		userDTO=loginManagerDaoImpl.loginVerify(userDTO);
	}
	
	@Test
	public void testUpdateUserDetails() throws DaoException{
		try{
		userDTO.setEmaild("aman@gmail.com");
		userDTO.setPassword("6d4d4120b2b51a8b83e229640780d19d");
		userDTO.setContactno("9424064354");
		userDTO.setFirstname("Aman");
		userDTO.setAddress("Bhopal");
		userDTO.setLanguage("English");
	    userDTO.setRole("user");
		userDTO.setLastname("Solanki");
		userDTO.setSubsid(3);
		loginManagerDaoImpl.updateUserDetails(userDTO);
		assert(true);
		}
		catch(HibernateException e){
			assert(false);
		}
	}
	
	@Test
	public void testViewSubscriptionHistory() throws DaoException{
		userDTO.setEmaild("aman@gmail.com");
		assertNotNull( loginManagerDaoImpl.viewSubscriptionHistory(userDTO));
	}
	
//	@Test
//	public void testUpgradePlan() throws DaoException{
//	    userDTO.setEmaild("aman@gmail.com");
//	    loginManagerDaoImpl.upgradePlan(userDTO, 1);
//	}
}
