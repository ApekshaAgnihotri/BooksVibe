package com.booksVibe.dao.DTO;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class) 
public class BooksDTOTest {

	BooksDTO booksDTO=new BooksDTO();
	UserDTO userDTO=new UserDTO();
	 
	 @Test
	 public void testBooksDTO(){
		 booksDTO.setAuthor("author");
		 booksDTO.setAvailability("available");
		 booksDTO.setBookId(1);
		 booksDTO.setBookTitle("bookTitle");
		 booksDTO.setCategory("category");
		 booksDTO.setCopies(2);
		 booksDTO.setImageFileName("1.jpg");
		 booksDTO.setLanguage("English");
		 booksDTO.setPublisher("publisher");
		 booksDTO.setOperator(userDTO);
		 assertEquals("author",booksDTO.getAuthor());
		 assertEquals("available",booksDTO.getAvailability());
		 assertEquals(1,booksDTO.getBookId());
		 assertEquals("bookTitle",booksDTO.getBookTitle());
		 assertEquals("category",booksDTO.getCategory());
		 assertEquals(2,booksDTO.getCopies());
		 assertEquals("1.jpg",booksDTO.getImageFileName());
		 assertEquals("English",booksDTO.getLanguage());
		 assertEquals("publisher",booksDTO.getPublisher());
		 assertEquals(userDTO,booksDTO.getOperator());
	 }
}
