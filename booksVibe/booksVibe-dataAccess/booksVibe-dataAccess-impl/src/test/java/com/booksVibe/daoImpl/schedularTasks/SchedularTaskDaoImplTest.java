package com.booksVibe.daoImpl.schedularTasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.booksVibe.dao.exceptions.DaoException;



@RunWith(MockitoJUnitRunner.class) 
public class SchedularTaskDaoImplTest {

    
    @InjectMocks
    private SchedularTasksDaoImpl schedularTasksDaoImpl;
    
    @Test
    public void testAddBooks() throws DaoException{
        schedularTasksDaoImpl.addBooks();
        schedularTasksDaoImpl.deleteBooks();
    }
}
