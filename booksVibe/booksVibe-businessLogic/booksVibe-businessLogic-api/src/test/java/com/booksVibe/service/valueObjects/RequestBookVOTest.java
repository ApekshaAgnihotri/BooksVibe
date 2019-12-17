package com.booksVibe.service.valueObjects;
import static org.junit.Assert.*;

import org.junit.Test;

import com.booksVibe.service.valueObject.BooksVO;
import com.booksVibe.service.valueObject.RequestBookVO;
import com.booksVibe.service.valueObject.UserValueObject;

public class RequestBookVOTest {

    RequestBookVO requestBookVO=new RequestBookVO();
    
    @Test
    public void testRequestBookVO(){
        
        BooksVO booksVO=new BooksVO();
        UserValueObject userValueObject=new UserValueObject();
        
        requestBookVO.setAddress(null);
        requestBookVO.setBookId(0);
        requestBookVO.setBooksVO(booksVO);
        requestBookVO.setBookTitle(null);
        requestBookVO.setCancellationDate(null);
        requestBookVO.setEmaild(null);
        requestBookVO.setRequestDate(null);
        requestBookVO.setRequestId(0);
        requestBookVO.setRequestStatus(null);
        requestBookVO.setReturnDate(null);
        requestBookVO.setUserVO(userValueObject);
        requestBookVO.setOperatorVO(userValueObject);
        
        assertNull(requestBookVO.getAddress());
        assertEquals(0, requestBookVO.getBookId());
        assertEquals(booksVO,requestBookVO.getBooksVO());
        assertNull(requestBookVO.getBookTitle());
        assertNull(requestBookVO.getCancellationDate());
        assertNull(requestBookVO.getEmaild());
        assertNull(requestBookVO.getRequestDate());
        assertNull(requestBookVO.getRequestStatus());
        assertNull(requestBookVO.getReturnDate());
        assertEquals(0, requestBookVO.getRequestId());
        assertEquals(userValueObject, requestBookVO.getUserVO());
        assertEquals(userValueObject, requestBookVO.getOperatorVO());
    }
}
