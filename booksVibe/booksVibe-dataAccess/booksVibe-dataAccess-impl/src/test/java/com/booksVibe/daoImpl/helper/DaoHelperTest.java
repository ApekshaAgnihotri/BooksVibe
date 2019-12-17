package com.booksVibe.daoImpl.helper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.*;
import com.booksVibe.dao.DTO.SubsDetailsDTO;
import com.booksVibe.dao.DTO.UserSubsDTO;

@RunWith(MockitoJUnitRunner.class)
public class DaoHelperTest {

	@InjectMocks
	private SubsDetailsDTO subsDetailsDTO;
	
	@InjectMocks
	private UserSubsDTO userSubsDTO;
	
	
	
	@Test
	public void testUserSubscriptionDetailsTransfer(){
		subsDetailsDTO.setAmount(250);
		subsDetailsDTO.setMaxBooks(4);
		subsDetailsDTO.setStatus("active");
		subsDetailsDTO.setSubsid(3);
		subsDetailsDTO.setSubsName("avid_reader");
		subsDetailsDTO.setTimePeriod(3);
		DaoHelper.userSubsDetailsTransfer(userSubsDTO, subsDetailsDTO);
		assertEquals("avid_reader", userSubsDTO.getSubsName());
		
	}
}
