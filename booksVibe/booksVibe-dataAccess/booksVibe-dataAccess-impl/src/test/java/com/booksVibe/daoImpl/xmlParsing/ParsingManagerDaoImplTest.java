package com.booksVibe.daoImpl.xmlParsing;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.booksVibe.dao.DTO.SubsDetailsDTO;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.daoImpl.util.Utility;



@RunWith(MockitoJUnitRunner.class) 
public class ParsingManagerDaoImplTest {

    static SessionFactory sessionFactory;
    @BeforeClass
    public static void initFactory()
    {            
        sessionFactory=Utility.getSessionFactory();
    }

   
    @InjectMocks
    private ParsingManagerDaoImpl parsingManagerDaoImpl;
    
    @InjectMocks
    private SubsDetailsDTO subsDetailsDTO;
    
    @Test
    public void testAddUpdateRecords() throws DaoException{
        subsDetailsDTO.setAmount(232);
        subsDetailsDTO.setMaxBooks(2);
        subsDetailsDTO.setStatus("active");
        subsDetailsDTO.setSubsName("testPlan");
        subsDetailsDTO.setTimePeriod(0);
        List<SubsDetailsDTO> list=new ArrayList<SubsDetailsDTO>();
        list.add(subsDetailsDTO);
        parsingManagerDaoImpl.addUpdateRecords(list);
        subsDetailsDTO.setAmount(232);
        subsDetailsDTO.setMaxBooks(2);
        subsDetailsDTO.setStatus("inactive");
        subsDetailsDTO.setSubsName("testPlan");
        subsDetailsDTO.setTimePeriod(0);
        parsingManagerDaoImpl.addUpdateRecords(list);
        
        parsingManagerDaoImpl.deleteRecords(list);
        

        Session session = sessionFactory.openSession();
         session.beginTransaction();
         session.delete(subsDetailsDTO);
         session.getTransaction().commit();
         session.close();
    }
    
}
