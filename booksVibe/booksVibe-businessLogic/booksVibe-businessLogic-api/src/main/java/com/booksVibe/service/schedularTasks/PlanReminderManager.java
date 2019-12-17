package com.booksVibe.service.schedularTasks;

import java.util.List;

import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.valueObject.UserSubsVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface PlanReminderManager.
 */
public interface PlanReminderManager {

    /**
     * Gets the users list by month.
     * 
     * @return the users list by month
     * @throws ServiceException
     *             the service exception
     */
    List<UserSubsVO> getUsersListByMonth() throws ServiceException;

    /**
     * Gets the users list by week.
     * 
     * @return the users list by week
     * @throws ServiceException
     *             the service exception
     */
    List<UserSubsVO> getUsersListByWeek() throws ServiceException;

    /**
     * Gets the users list by day.
     * 
     * @return the users list by day
     * @throws ServiceException
     *             the service exception
     */
    List<UserSubsVO> getUsersListByDay() throws ServiceException;
}
