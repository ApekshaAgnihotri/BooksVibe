package com.booksVibe.daoImpl.schedularTasks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.booksVibe.dao.DTO.UserSubsDTO;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.daoImpl.util.Utility;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class) 
public class AlterPlanStatusDaoImplTest {

	@InjectMocks
	private AlterPlanStatusDaoImpl alterPlanStatusDaoImpl;
	
	 static SessionFactory sessionFactory;
	 @BeforeClass
     public static void initFactory()
     {            
         sessionFactory=Utility.getSessionFactory();
     }

	
	@Test
	public void testGetUserList()throws DaoException{
		assertNotNull(alterPlanStatusDaoImpl.getUsersList());
		
	}
	
	@Test
	public void testAlterPlanStatus() throws DaoException{
	    List<UserSubsDTO> list=new ArrayList<UserSubsDTO>();
	    UserSubsDTO userSubsDTO=new UserSubsDTO();
	    
	    userSubsDTO.setEmaild("aman@gmail.com");
	    userSubsDTO.setAmmount(250);
	    userSubsDTO.setMaxBooks(4);
	    userSubsDTO.setStatus("active");
	    userSubsDTO.setSubEnd(new Date());
	    userSubsDTO.setSubStart(new Date());
	    userSubsDTO.setSubsid(3);
	    userSubsDTO.setSubsName("Avid Reader");
	    userSubsDTO.setTimePeriod(3);
	   
	   
	    list.add(userSubsDTO);
	    alterPlanStatusDaoImpl.alterPlanStatus(list);
	}
	
}
