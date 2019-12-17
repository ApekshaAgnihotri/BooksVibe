package com.booksVibe.service.valueObjects;

import org.junit.Test;

import com.booksVibe.service.valueObject.BooksVO;
import com.booksVibe.service.valueObject.UserValueObject;

import static org.junit.Assert.*;

public class BooksVOTest {

    BooksVO booksVO=new BooksVO();
    UserValueObject userValueObject=new UserValueObject();
    
    @Test
    public void testBooksVO(){
      
       
       booksVO.setAuthor(null);
       booksVO.setAvailability(null);
       booksVO.setBookId(0);
       booksVO.setBookTitle(null);
       booksVO.setCategory(null);
       booksVO.setCopies(0);
       booksVO.setImageFileName(null);
       booksVO.setLanguage(null);
       booksVO.setNewcopies(0);
       booksVO.setPublisher(null);
       booksVO.setOperator(userValueObject);
       
       assertEquals(null,booksVO.getAuthor());
       assertEquals(null,booksVO.getAvailability());
       assertEquals(0, booksVO.getBookId());
       assertEquals(null,booksVO.getBookTitle());
       assertEquals(null,booksVO.getBookTitle());
       assertEquals(null,booksVO.getCategory());
       assertEquals(0, booksVO.getCopies());
       assertEquals(0, booksVO.getNewcopies());
       assertEquals(null, booksVO.getImageFileName());
       assertEquals(null,booksVO.getLanguage());
       assertEquals(null, booksVO.getPublisher());
       assertEquals(userValueObject, booksVO.getOperator());
    }
}
