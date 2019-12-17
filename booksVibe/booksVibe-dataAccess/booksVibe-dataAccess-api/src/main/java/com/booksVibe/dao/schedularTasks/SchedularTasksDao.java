package com.booksVibe.dao.schedularTasks;

import com.booksVibe.dao.exceptions.DaoException;

// TODO: Auto-generated Javadoc
/**
 * The Interface SchedularTasksDao.
 */
public interface SchedularTasksDao {

    /**
     * Adds the books.
     * 
     * @throws DaoException
     *             the dao exception
     */
    void addBooks() throws DaoException;

    /**
     * Delete books.
     * 
     * @throws DaoException
     *             the dao exception
     */
    void deleteBooks() throws DaoException;

}
