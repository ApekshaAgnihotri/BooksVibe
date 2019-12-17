package com.booksVibe.service.valueObjects;

import static org.junit.Assert.*;

import org.junit.Test;

import com.booksVibe.service.valueObject.BooksVO;
import com.booksVibe.service.valueObject.UserBookShelfVO;
import com.booksVibe.service.valueObject.UserValueObject;

public class UserCartVOTest {

    UserBookShelfVO userCartVO=new UserBookShelfVO();
    
    @Test
    public void testUserCartVO(){
      UserValueObject userValueObject=new UserValueObject();
      BooksVO booksVO=new BooksVO();
      
      userCartVO.setBooksVO(booksVO);
      userCartVO.setUserVO(userValueObject);
      userCartVO.setCartId(0);
      
      assertEquals(booksVO,userCartVO.getBooksVO());
      assertEquals(0, userCartVO.getCartId());
      assertEquals(userValueObject,userCartVO.getUserVO());
      
    }  
    
}
