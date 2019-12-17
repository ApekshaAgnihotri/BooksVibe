package com.booksVibe.serviceImpl.schedularTasks;


import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.schedularTasks.SchedularTasksDao;
import com.booksVibe.service.exceptions.ServiceException;


@RunWith(MockitoJUnitRunner.class)
public class SchedularTasksManagerImplTest {

    @InjectMocks
    private SchedularTasksManagerImpl schedularTasksManagerImpl;
    
    @Mock
    private SchedularTasksDao schedularTasksDao;
    
    @Test
    public void testAddBooks() throws DaoException, ServiceException{
        doNothing().when(schedularTasksDao).addBooks();
        schedularTasksManagerImpl.addBooks();
    }
    
    @Test(expected=ServiceException.class)
    public void testAddBooksServiceException() throws DaoException, ServiceException{
        doThrow(DaoException.class).when(schedularTasksDao).addBooks();
        schedularTasksManagerImpl.addBooks();
    }
    
    @Test
    public void testDeleteBooks() throws DaoException, ServiceException{
        doNothing().when(schedularTasksDao).deleteBooks();
        schedularTasksManagerImpl.deleteBooks();
    }
    
    @Test(expected=ServiceException.class)
    public void testDeleteBooksServiceException() throws DaoException, ServiceException{
        doThrow(DaoException.class).when(schedularTasksDao).deleteBooks();
        schedularTasksManagerImpl.deleteBooks();
    }
    
}
