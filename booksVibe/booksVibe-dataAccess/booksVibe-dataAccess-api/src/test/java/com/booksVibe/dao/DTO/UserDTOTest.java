package com.booksVibe.dao.DTO;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class) 
public class UserDTOTest {
 
UserDTO userDTO=new UserDTO();
	
	@Test
	public void testUserDTO(){
		userDTO.setAddress("Bhopal");
		userDTO.setContactno("9407460008");
		userDTO.setEmaild("aman@gmail.com");
		userDTO.setFirstname("Aman");
		userDTO.setLanguage("English");
		userDTO.setLastname("Solanki");
		userDTO.setPassword("password");
		userDTO.setRole("user");
		userDTO.setSubsid(3);
		userDTO.setRequests(0);
		assertEquals("Bhopal",userDTO.getAddress());
		assertEquals("9407460008",userDTO.getContactno());
		assertEquals("aman@gmail.com", userDTO.getEmaild());
		assertEquals("Aman",userDTO.getFirstname());
		assertEquals("English", userDTO.getLanguage());
		assertEquals("Solanki",userDTO.getLastname());
		assertEquals("password",userDTO.getPassword());
		assertEquals("user",userDTO.getRole());
		assertEquals(3, userDTO.getSubsid());
		assertEquals(0, userDTO.getRequests());
	}
}
