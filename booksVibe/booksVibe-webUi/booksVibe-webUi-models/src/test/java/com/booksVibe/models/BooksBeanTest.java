package com.booksVibe.models;

import org.junit.Test;
import static org.junit.Assert.*;

public class BooksBeanTest {
  

        BooksBean booksVO=new BooksBean();
        UserBean userValueObject=new UserBean();
        
        @Test
        public void testBooksVO(){
          
           
           booksVO.setAuthor(null);
           booksVO.setAvailability(null);
           booksVO.setBookId(0);
           booksVO.setBookTitle(null);
           booksVO.setCategory(null);
           booksVO.setCopies(0);
           booksVO.setKimageFileName(null);
           booksVO.setLanguage(null);
           booksVO.setNewcopies(0);
           booksVO.setPublisher(null);
           booksVO.setOperator(userValueObject);
           booksVO.setKimage(null);
           booksVO.setKimageContentType(null);
           
           assertEquals(null,booksVO.getAuthor());
           assertEquals(null,booksVO.getAvailability());
           assertEquals(0, booksVO.getBookId());
           assertEquals(null,booksVO.getBookTitle());
           assertEquals(null,booksVO.getBookTitle());
           assertEquals(null,booksVO.getCategory());
           assertEquals(0, booksVO.getCopies());
           assertEquals(0, booksVO.getNewcopies());
           assertEquals(null, booksVO.getKimageFileName());
           assertEquals(null,booksVO.getLanguage());
           assertEquals(null, booksVO.getPublisher());
           assertEquals(userValueObject, booksVO.getOperator());
           assertEquals(null,booksVO.getKimage());
           assertEquals(null,booksVO.getKimageContentType());
        }
    }


