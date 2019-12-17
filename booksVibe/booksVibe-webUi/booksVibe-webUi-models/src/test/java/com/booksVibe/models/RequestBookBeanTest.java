package com.booksVibe.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;



public class RequestBookBeanTest {
 RequestBookBean requestBookVO=new RequestBookBean();
    
    @Test
    public void testRequestBookVO(){
        
        BooksBean booksVO=new BooksBean();
        UserBean userValueObject=new UserBean();
        
        requestBookVO.setAddress(null);
        requestBookVO.setBookId(0);
        requestBookVO.setBooksBean(booksVO);
        requestBookVO.setBookTitle(null);
        requestBookVO.setCancellationDate(null);
        requestBookVO.setEmaild(null);
        requestBookVO.setRequestDate(null);
        requestBookVO.setRequestId(0);
        requestBookVO.setRequestStatus(null);
        requestBookVO.setReturnDate(null);
        requestBookVO.setUserBean(userValueObject);
        requestBookVO.setOperatorBean(userValueObject);
        requestBookVO.setAuthor(null);
        
        assertNull(requestBookVO.getAddress());
        assertEquals(0, requestBookVO.getBookId());
        assertEquals(booksVO,requestBookVO.getBooksBean());
        assertNull(requestBookVO.getBookTitle());
        assertNull(requestBookVO.getCancellationDate());
        assertNull(requestBookVO.getEmaild());
        assertNull(requestBookVO.getRequestDate());
        assertNull(requestBookVO.getRequestStatus());
        assertNull(requestBookVO.getReturnDate());
        assertNull(requestBookVO.getAuthor());
        assertEquals(0, requestBookVO.getRequestId());
        assertEquals(userValueObject, requestBookVO.getUserBean());
        assertEquals(userValueObject, requestBookVO.getOperatorBean());
    }
}
