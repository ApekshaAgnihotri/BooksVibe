package com.booksVibe.daoImpl.pdf;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.assertNotNull;
import com.booksVibe.dao.exceptions.DaoException;

@RunWith(MockitoJUnitRunner.class)
public class PdfManagerDaoImplTest {

	@InjectMocks
	private PdfManagerDaoImpl pdfManagerDaoImpl;
	
	@Test
	public void testManagePdf() throws DaoException{
		assertNotNull(pdfManagerDaoImpl.managePdf());
	}
	
	@Test
	public void testGetBooksByFilter() throws DaoException{
	
		Date fromDate=new Date(114,9,1);
		Date toDate=new Date(114,9,10);
		assertNotNull(pdfManagerDaoImpl.getBooksByFilter("Herbert Schildt","Technical",fromDate,toDate));
	}
	
}
