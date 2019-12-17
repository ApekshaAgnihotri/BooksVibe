package com.booksVibe.service.valueObjects;

import static org.junit.Assert.*;

import org.junit.Test;

import com.booksVibe.service.valueObject.UserValueObject;

public class UserValueObjectTest {

    UserValueObject userValueObject=new UserValueObject();
    
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
        
        assertNull(userValueObject.getAddress());
        assertNull(userValueObject.getContactno());
        assertNull(userValueObject.getEmaild());
        assertNull(userValueObject.getFirstname());
        assertNull(userValueObject.getLanguage());
        assertNull(userValueObject.getLastname());
        assertNull(userValueObject.getPassword());
        assertNull(userValueObject.getRole());
        assertEquals(0, userValueObject.getSubsid());
       
    }
}
