package com.booksVibe.daoImpl.schedularTasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.booksVibe.dao.exceptions.DaoException;


@RunWith(MockitoJUnitRunner.class) 
public class PlanReminderDaoImplTest {

    
    @InjectMocks
    private PlanReminderDaoImpl planReminderDaoImpl;
    
    @Test
    public void testGetUsersByDay() throws DaoException{
        planReminderDaoImpl.getUsersListByDay();
    }
    
    @Test
    public void testGetUsersByMonth() throws DaoException{
        planReminderDaoImpl.getUsersListByMonth();
    }
    
    @Test
    public void testGetUsersByWeek() throws DaoException{
        planReminderDaoImpl.getUsersListByWeek();
    }
    
}
