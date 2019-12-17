package com.booksVibe.dao.DTO;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class) 
public class RequestBookDTOTest {

     RequestBookDTO requestBookDTO=new RequestBookDTO();
     BooksDTO booksDTO=new BooksDTO();
     UserDTO userDTO=new UserDTO();
	
	@Test
	public void testRequestBookDTO(){
		requestBookDTO.setRequestDate(null);
		requestBookDTO.setAddress("address");
		requestBookDTO.setBooksDTO(booksDTO);
		requestBookDTO.setCancellationDate(null);
		requestBookDTO.setRequestId(0);
		requestBookDTO.setRequestStatus("requestStatus");
		requestBookDTO.setReturnDate(null);
		requestBookDTO.setUserDTO(userDTO);
		requestBookDTO.setOperator(userDTO);
		
		assertEquals(null, requestBookDTO.getRequestDate());
		assertEquals(null,requestBookDTO.getCancellationDate());
		assertEquals(null, requestBookDTO.getReturnDate());
		assertEquals("address",requestBookDTO.getAddress());
		assertEquals("requestStatus",requestBookDTO.getRequestStatus());
		assertEquals(0,requestBookDTO.getRequestId());
		assertSame(userDTO, requestBookDTO.getUserDTO());
		assertSame(userDTO, requestBookDTO.getOperator());
		assertSame(booksDTO,requestBookDTO.getBooksDTO());
	}
}
