package com.booksVibe.dao.DTO;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserCartDTOTest {
  UserBookShelfDTO userCartDTO=new UserBookShelfDTO();
  
  @Test
  public void testUserCartDTO(){
      BooksDTO booksDTO=new BooksDTO();
      UserDTO userDTO=new UserDTO();
      
      userCartDTO.setBooksDTO(booksDTO);
      userCartDTO.setCartId(0);
      userCartDTO.setUserDTO(userDTO);
      
      assertEquals(booksDTO,userCartDTO.getBooksDTO());
      assertEquals(0, userCartDTO.getCartId());
      assertEquals(userDTO,userCartDTO.getUserDTO());
      
  }
}
