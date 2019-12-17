package com.booksVibe.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;



public class UserCartBeanTest {
UserBookShelfBean userCartVO=new UserBookShelfBean();
    
    @Test
    public void testUserCartVO(){
      UserBean userValueObject=new UserBean();
      BooksBean booksVO=new BooksBean();
      
      userCartVO.setBooksBean(booksVO);
      userCartVO.setUserBean(userValueObject);
      userCartVO.setCartId(0);
      
      assertEquals(booksVO,userCartVO.getBooksBean());
      assertEquals(0, userCartVO.getCartId());
      assertEquals(userValueObject,userCartVO.getUserBean());
      
    }  
}
