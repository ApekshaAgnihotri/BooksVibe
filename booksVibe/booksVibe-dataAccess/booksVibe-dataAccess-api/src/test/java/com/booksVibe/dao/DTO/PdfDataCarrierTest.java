package com.booksVibe.dao.DTO;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class) 
public class PdfDataCarrierTest {

	PdfDataCarrier pdfDataCarrier=new PdfDataCarrier();
	
	
	@Test
	public void testPdfDataCarrier(){
		pdfDataCarrier.setAuthor("author");
		pdfDataCarrier.setCancelled(0);
		pdfDataCarrier.setCategory("category");
		pdfDataCarrier.setDelivered(0);
		pdfDataCarrier.setReturned(0);
		pdfDataCarrier.setTitle("title");
		
		assertEquals("author",pdfDataCarrier.getAuthor());
		assertEquals(0,pdfDataCarrier.getCancelled());
		assertEquals("category",pdfDataCarrier.getCategory());
		assertEquals(0,pdfDataCarrier.getDelivered());
		assertEquals(0,pdfDataCarrier.getReturned());
		assertEquals("title",pdfDataCarrier.getTitle());
	}
	
}
