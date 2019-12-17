package com.booksVibe.dao.schedularTasks;

import java.util.List;

import com.booksVibe.dao.DTO.UserSubsDTO;
import com.booksVibe.dao.exceptions.DaoException;

// TODO: Auto-generated Javadoc
/**
 * The Interface PlanReminderDao.
 */
public interface PlanReminderDao {

    /**
     * Gets the users list by month.
     * 
     * @return the users list by month
     * @throws DaoException
     *             the dao exception
     */
    List<UserSubsDTO> getUsersListByMonth() throws DaoException;

    /**
     * Gets the users list by week.
     * 
     * @return the users list by week
     * @throws DaoException
     *             the dao exception
     */
    List<UserSubsDTO> getUsersListByWeek() throws DaoException;

    /**
     * Gets the users list by day.
     * 
     * @return the users list by day
     * @throws DaoException
     *             the dao exception
     */
    List<UserSubsDTO> getUsersListByDay() throws DaoException;
}
