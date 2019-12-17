package com.booksVibe.serviceImpl.schedularTasks;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.booksVibe.dao.DTO.UserSubsDTO;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.schedularTasks.AlterPlanStatusDao;
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.serviceImpl.schedularTasks.AlterPlanStatusManagerImpl;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class AlterPlanStatusManagerImplTest {

    
    @InjectMocks
    private AlterPlanStatusManagerImpl alterPlanStatusManagerImpl;
    
    @Mock
    private AlterPlanStatusDao alterPlanStatusDao;
     
    
    @Test
    public void testAlterPlanStatus() throws DaoException, ServiceException{
        
        List<UserSubsDTO> expiredUserList=new ArrayList<UserSubsDTO>();
       when(alterPlanStatusDao.getUsersList()).thenReturn(expiredUserList);
       doNothing().when(alterPlanStatusDao).alterPlanStatus(expiredUserList);
       alterPlanStatusManagerImpl.alterPlanStatus();
    }
    
    @Test(expected=ServiceException.class)
    public void testAlterPlanStatusServiceException() throws DaoException, ServiceException{
             
        List<UserSubsDTO> expiredUserList=new ArrayList<UserSubsDTO>();
        when(alterPlanStatusDao.getUsersList()).thenReturn(expiredUserList);
        doThrow(DaoException.class).when(alterPlanStatusDao).alterPlanStatus(expiredUserList);
        alterPlanStatusManagerImpl.alterPlanStatus();
    }
}
