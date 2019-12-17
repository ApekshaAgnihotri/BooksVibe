package com.booksVibe.service.valueObjects;

import org.junit.Test;

import com.booksVibe.service.valueObject.SubsDetailsVO;

import static org.junit.Assert.*;

public class SubsDetailsVOTest {
 
    SubsDetailsVO subsDetailsVO=new SubsDetailsVO();
    
    @Test
    public void testSubsDetailsVO(){
        subsDetailsVO.setMaxBooks(0);
        subsDetailsVO.setStatus(null);
        subsDetailsVO.setSubsid(0);
        subsDetailsVO.setSubsName(null);
        subsDetailsVO.setTimePeriod(0);
        subsDetailsVO.setAmount(0.0F);
        
        assertEquals(0,subsDetailsVO.getMaxBooks());
        assertEquals(null,subsDetailsVO.getStatus());
        assertEquals(0, subsDetailsVO.getSubsid());
        assertNull(subsDetailsVO.getSubsName());
        assertNull(subsDetailsVO.getStatus());
       
        assertEquals(0, subsDetailsVO.getTimePeriod());
       
    }
}
