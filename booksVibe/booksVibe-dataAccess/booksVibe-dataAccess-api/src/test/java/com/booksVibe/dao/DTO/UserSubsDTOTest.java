package com.booksVibe.dao.DTO;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserSubsDTOTest {

    UserSubsDTO userSubsDTO=new UserSubsDTO();
    
    @Test
    public void testUserSubsDTO(){
        userSubsDTO.setAmmount(0);
        userSubsDTO.setEmaild("aman@gmail.com");
        userSubsDTO.setMaxBooks(0);
        userSubsDTO.setStatus("active");
        userSubsDTO.setSubEnd(null);
        userSubsDTO.setSubsid(0);
        userSubsDTO.setSubsName(null);
        userSubsDTO.setSubStart(null);
        userSubsDTO.setTimePeriod(0);
        
        
        assertEquals("aman@gmail.com",userSubsDTO.getEmaild());
        assertEquals(0, userSubsDTO.getMaxBooks());
        assertEquals("active",userSubsDTO.getStatus());
        assertEquals(0, userSubsDTO.getMaxBooks());
        assertEquals(null, userSubsDTO.getSubEnd());
        assertEquals(0, userSubsDTO.getSubsid());
        assertEquals(null,userSubsDTO.getSubsName() );
        assertEquals(null,userSubsDTO.getSubStart());
        assertEquals(0, userSubsDTO.getTimePeriod());
    }
    
}
