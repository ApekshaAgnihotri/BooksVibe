package com.booksVibe.dao.DTO;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class RecommendBooksDTOTest {

 RecommendBooksDTO re= new RecommendBooksDTO();

    @Test
    public final void testGetUserDTO() {
        BooksDTO booksDTO=new BooksDTO();
        UserDTO userDTO=new UserDTO();
        re.setBooksDTO(booksDTO);
        re.setId(2);
        re.setUserDTO(userDTO);
        
        assertEquals(booksDTO, re.getBooksDTO());
        assertEquals(userDTO, re.getUserDTO());
        assertEquals(2, re.getId());
    }

   
}
