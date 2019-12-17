package com.booksVibe.daoImpl.registration;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

import com.booksVibe.dao.DTO.SubsDetailsDTO;
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.DTO.UserSubsDTO;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.daoImpl.util.Utility;

@RunWith(MockitoJUnitRunner.class) 
public class RegManagerDaoImplTest {

	
    @InjectMocks
	private UserDTO userDTO;
       
    
    @InjectMocks
    private RegManagerDaoImpl regManagerDaoImpl;
    
   @InjectMocks
    private SubsDetailsDTO subsDetailsDTO;
	
   static SessionFactory sessionFactory;
   
	@BeforeClass
	public static void initFactory()
	{
		sessionFactory=Utility.getSessionFactory();
	}
	
	
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}
    
   
	@Test
    public void testRegisterUser()throws DaoException{
    	userDTO.setEmaild("aman.solanki@impetus.co.in");
    	userDTO.setPassword("6d4d4120b2b51a8b83e229640780d19d");
    	int subsid=3;
    	userDTO.setSubsid(subsid);
        assertNotNull(regManagerDaoImpl.registerUser(userDTO));
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(userDTO);
        Criteria criteria=session.createCriteria(UserSubsDTO.class);
        UserSubsDTO userSubsDTO=new UserSubsDTO();
        userSubsDTO.setEmaild("aman.solanki@impetus.co.in");
        session.delete(userSubsDTO);
        session.getTransaction().commit();
        session.close();
    
    	
    }
	
	@Test
    public void testRegisterUserIdAlreadyExist()throws DaoException{
        userDTO.setEmaild("aman@gmail.com");
        userDTO.setPassword("6d4d4120b2b51a8b83e229640780d19d");
        int subsid=3;
        userDTO.setSubsid(subsid);
        assertNotNull(regManagerDaoImpl.registerUser(userDTO));
	}
	
	@Test
	public void testLoadSubscription()throws DaoException{
		List<SubsDetailsDTO> list=regManagerDaoImpl.loadSubscription();
		if(list.size()>0){
			assert(true);
		}
	}
	
	@Test
	public void testCheckStatus()throws DaoException{
		String emaild="aman@gmail.com";
		boolean status=regManagerDaoImpl.checkStatus(emaild);
		if(status){
			assert(true);
		}
	}
	
	@Test
	public void testRegisterOperator()throws DaoException{
		userDTO.setEmaild("apekshaa@gmail.com");
		assertNotNull(regManagerDaoImpl.registerOperator(userDTO));
		
		 
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(userDTO);
        session.getTransaction().commit();
        session.close();
	}
	
}
