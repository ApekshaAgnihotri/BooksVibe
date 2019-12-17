package com.booksVibe.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;



public class SubsDetailsBeanTest {

SubsDetailsBean subsDetailsVO=new SubsDetailsBean();
    
    @Test
    public void testSubsDetailsVO(){
        subsDetailsVO.setMaxBooks(0);
        subsDetailsVO.setStatus(null);
        subsDetailsVO.setSubsid(0);
        subsDetailsVO.setSubsName(null);
        subsDetailsVO.setTimePeriod(0);
        subsDetailsVO.setAmount(0.0F);
        subsDetailsVO.setXmlfile(null);
        subsDetailsVO.setXmlfileContentType(null);
        subsDetailsVO.setXmlfileName(null);
        
        assertEquals(0,subsDetailsVO.getMaxBooks());
        assertEquals(null,subsDetailsVO.getStatus());
        assertEquals(0, subsDetailsVO.getSubsid());
        assertNull(subsDetailsVO.getSubsName());
        assertNull(subsDetailsVO.getStatus());
        assertNull(subsDetailsVO.getXmlfile());
        assertNull(subsDetailsVO.getXmlfileContentType());
        assertNull(subsDetailsVO.getXmlfileName());
        assertEquals(0, subsDetailsVO.getTimePeriod());
       
    }
    
}
