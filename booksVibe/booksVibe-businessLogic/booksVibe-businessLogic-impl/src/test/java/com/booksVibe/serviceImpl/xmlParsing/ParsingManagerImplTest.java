package com.booksVibe.serviceImpl.xmlParsing;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.booksVibe.dao.DTO.SubsDetailsDTO;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.xmlParsing.ParsingManagerDao;
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.valueObject.SubsDetailsVO;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ParsingManagerImplTest {
    
    
    @InjectMocks
   private ParsingManagerImpl parsingManagerImpl;
 
    @Mock
    private ParsingManagerDao parsingManagerDao;
    
    @Test
    public void testAddUpdatePlan() throws DaoException, ServiceException{
        List<SubsDetailsVO> list=new ArrayList<SubsDetailsVO>();
        List<SubsDetailsDTO> listDTO=new ArrayList<SubsDetailsDTO>();
        doNothing().when(parsingManagerDao).addUpdateRecords(listDTO);
        parsingManagerImpl.addUpdateRecords(list);
        
    }
    
    @Test(expected=ServiceException.class)
    public void testAddUpdatePlanServiceException() throws DaoException, ServiceException{
        List<SubsDetailsVO> list=new ArrayList<SubsDetailsVO>();
        List<SubsDetailsDTO> listDTO=new ArrayList<SubsDetailsDTO>();
        doThrow(DaoException.class).when(parsingManagerDao).addUpdateRecords(listDTO);
        parsingManagerImpl.addUpdateRecords(list); 
    }
    
    @Test
    public void testDeleteRecords() throws DaoException, ServiceException{
        List<SubsDetailsVO> list=new ArrayList<SubsDetailsVO>();
        List<SubsDetailsDTO> listDTO=new ArrayList<SubsDetailsDTO>();
        doNothing().when(parsingManagerDao).deleteRecords(listDTO);
        parsingManagerImpl.deleteRecords(list);
    }
    
    @Test(expected=ServiceException.class)
    public void testDeleteRecordsSeviceException() throws DaoException, ServiceException{
        List<SubsDetailsVO> list=new ArrayList<SubsDetailsVO>();
        List<SubsDetailsDTO> listDTO=new ArrayList<SubsDetailsDTO>();
        doThrow(DaoException.class).when(parsingManagerDao).deleteRecords(listDTO);
        parsingManagerImpl.deleteRecords(list);  
    }
}
