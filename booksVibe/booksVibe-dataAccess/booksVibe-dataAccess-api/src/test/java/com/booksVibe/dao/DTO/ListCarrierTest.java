package com.booksVibe.dao.DTO;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class) 
public class ListCarrierTest {

    ListCarrier listCarrier=new ListCarrier();
	
	 @Test
	 public void testListCarrier(){
	     List<BooksDTO> list=new ArrayList<BooksDTO>();
	     listCarrier.setTotalRecords(0);
	     listCarrier.setBooksListDTO(list);
	     assertEquals(0,listCarrier.getBooksListDTO().size());
	     assertEquals(0,listCarrier.getTotalRecords());
	 }
}
