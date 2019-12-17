package com.booksVibe.serviceImpl.schedularTasks;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.booksVibe.dao.DTO.UserSubsDTO;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.schedularTasks.PlanReminderDao;
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.serviceImpl.schedularTasks.PlanReminderManagerImpl;

@RunWith(MockitoJUnitRunner.class)
public class PlanReminderManagerImplTest {

    @InjectMocks
    private PlanReminderManagerImpl planReminderManagerImpl;
    
    @Mock
    private PlanReminderDao planReminderDao;
    
    @Test
    public void testGetUserListByMonth() throws ServiceException, DaoException{
        List<UserSubsDTO> userList=new ArrayList<UserSubsDTO>();
        when(planReminderDao.getUsersListByMonth()).thenReturn(userList);
        planReminderManagerImpl.getUsersListByMonth();
    }
    
    @Test(expected=ServiceException.class)
    public void testGetUserListByMonthServiceException() throws DaoException, ServiceException{
        doThrow(DaoException.class).when(planReminderDao).getUsersListByMonth();
        planReminderManagerImpl.getUsersListByMonth();
    }
    
    @Test
    public void testGetUserListByDay() throws ServiceException, DaoException{
        List<UserSubsDTO> userList=new ArrayList<UserSubsDTO>();
        when(planReminderDao.getUsersListByDay()).thenReturn(userList);
        planReminderManagerImpl.getUsersListByDay();
    }
    
    @Test(expected=ServiceException.class)
    public void testGetUserListByDayServiceException() throws DaoException, ServiceException{
        doThrow(DaoException.class).when(planReminderDao).getUsersListByDay();
        planReminderManagerImpl.getUsersListByDay();
    }
    
    @Test
    public void testGetUserListByWeek() throws ServiceException, DaoException{
        List<UserSubsDTO> userList=new ArrayList<UserSubsDTO>();
        when(planReminderDao.getUsersListByWeek()).thenReturn(userList);
        planReminderManagerImpl.getUsersListByWeek();
    }
    
    @Test(expected=ServiceException.class)
    public void testGetUserListByWeekServiceException() throws DaoException, ServiceException{
        doThrow(DaoException.class).when(planReminderDao).getUsersListByWeek();
        planReminderManagerImpl.getUsersListByWeek();
    }
}
