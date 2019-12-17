package com.booksVibe.serviceImpl.pdf;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.booksVibe.dao.DTO.PdfDataCarrier;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.pdf.PdfManagerDao;
import com.booksVibe.service.exceptions.ServiceException;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class PdfManagerImplTest {

    @InjectMocks
    private PdfManagerImpl pdfManagerImpl;
    
    @InjectMocks
    private PdfDataCarrier pdfDataCarrier;
    
    @Mock
    private PdfManagerDao pdfManagerDao;
    
    @Mock
    private List<String> listString=new ArrayList<String>();
    
    @Mock
    private List<PdfDataCarrier> listPdf=new ArrayList<PdfDataCarrier>();
    
    @Test
    public void testManagePdf() throws DaoException, ServiceException{
        
        when(pdfManagerDao.managePdf()).thenReturn(listString);
        assertNotNull(pdfManagerImpl.managePdf());
        
    }
    
    @Test(expected=ServiceException.class)
    public void testManagePdfServiceException() throws DaoException, ServiceException{
        doThrow(DaoException.class).when(pdfManagerDao).managePdf();
        pdfManagerImpl.managePdf();
    }
    
    @Test
    public void testBooksByFilter() throws DaoException, ServiceException{
        when(pdfManagerDao.getBooksByFilter(null, null, null, null)).thenReturn(listPdf);
        assertNotNull(pdfManagerImpl.getBooksByFilter(null, null, null, null));
    }
    
    @Test(expected=ServiceException.class)
    public void testBooksByFilterServiceException() throws DaoException, ServiceException{
        doThrow(DaoException.class).when(pdfManagerDao).getBooksByFilter(null, null, null, null);
        pdfManagerImpl.getBooksByFilter(null, null, null, null);
    }
}
