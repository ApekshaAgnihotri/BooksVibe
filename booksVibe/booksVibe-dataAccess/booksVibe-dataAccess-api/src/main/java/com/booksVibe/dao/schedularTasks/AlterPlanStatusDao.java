package com.booksVibe.dao.schedularTasks;

import java.util.List;

import com.booksVibe.dao.DTO.UserSubsDTO;
import com.booksVibe.dao.exceptions.DaoException;

// TODO: Auto-generated Javadoc
/**
 * The Interface AlterPlanStatusDao.
 */
public interface AlterPlanStatusDao {

    /**
     * Alter plan status.
     * 
     * @param expiredUserList
     *            the expired user list
     * @throws DaoException
     *             the dao exception
     */
    void alterPlanStatus(List<UserSubsDTO> expiredUserList) throws DaoException;

    /**
     * Gets the users list.
     * 
     * @return the users list
     * @throws DaoException
     *             the dao exception
     */
    List<UserSubsDTO> getUsersList() throws DaoException;
}
