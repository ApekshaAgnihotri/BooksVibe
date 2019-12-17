package com.booksVibe.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;



public class UserBeanTest {
  UserBean userValueObject=new UserBean();
    
    @Test
    public void testUserValueObject(){
        
        userValueObject.setAddress(null);
        userValueObject.setContactno(null);
        userValueObject.setEmaild(null);
        userValueObject.setFirstname(null);
        userValueObject.setLastname(null);
        userValueObject.setLanguage(null);
        userValueObject.setPassword(null);
        userValueObject.setRole(null);
        userValueObject.setSubsid(0);
        userValueObject.setConfrimPassword(null);
        
        assertNull(userValueObject.getAddress());
        assertNull(userValueObject.getContactno());
        assertNull(userValueObject.getEmaild());
        assertNull(userValueObject.getFirstname());
        assertNull(userValueObject.getLanguage());
        assertNull(userValueObject.getLastname());
        assertNull(userValueObject.getPassword());
        assertNull(userValueObject.getRole());
        assertNull(userValueObject.getConfrimPassword());
        assertEquals(0, userValueObject.getSubsid());
       
    }
}
