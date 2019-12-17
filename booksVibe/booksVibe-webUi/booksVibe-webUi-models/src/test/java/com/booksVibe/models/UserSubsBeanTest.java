package com.booksVibe.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;



public class UserSubsBeanTest {

    UserSubsBean userSubsVO=new UserSubsBean();
    @Test
    public void testUserSubsVO(){
        userSubsVO.setEmaild(null);
        userSubsVO.setMaxBooks(0);
        userSubsVO.setStatus(null);
        userSubsVO.setSubEnd(null);
        userSubsVO.setSubsid(0);
        userSubsVO.setSubsName(null);
        userSubsVO.setSubStart(null);
        userSubsVO.setTimePeriod(0);
        userSubsVO.setAmount(0.0F);
        assertNull(userSubsVO.getEmaild());
        assertNull(userSubsVO.getStatus());
        assertNull(userSubsVO.getSubEnd());
        assertNull(userSubsVO.getSubsName());
        assertNull(userSubsVO.getSubStart());
        assertEquals(0, userSubsVO.getMaxBooks());
        assertEquals(0, userSubsVO.getSubsid());
        assertEquals(0, userSubsVO.getTimePeriod());
    }
}
