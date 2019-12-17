package com.booksVibe.dao.DTO;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubsDetailsDTOTest {

    SubsDetailsDTO subsDetailsDTO=new SubsDetailsDTO();
    
    @Test
    public void testSubsDetailsDTO(){
        subsDetailsDTO.setAmount(0);
        subsDetailsDTO.setMaxBooks(0);
        subsDetailsDTO.setStatus(null);
        subsDetailsDTO.setSubsid(0);
        subsDetailsDTO.setSubsName(null);
        subsDetailsDTO.setTimePeriod(0);
       
        assertEquals(0, subsDetailsDTO.getMaxBooks());
        assertEquals(null,subsDetailsDTO.getStatus());
        assertEquals(0, subsDetailsDTO.getSubsid());
        assertEquals(null,subsDetailsDTO.getSubsName());
        assertEquals(0, subsDetailsDTO.getTimePeriod());
       
        
    }
}
