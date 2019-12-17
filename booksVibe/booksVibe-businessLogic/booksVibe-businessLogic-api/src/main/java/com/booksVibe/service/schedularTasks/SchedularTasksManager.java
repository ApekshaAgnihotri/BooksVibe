package com.booksVibe.service.schedularTasks;

import com.booksVibe.service.exceptions.ServiceException;

// TODO: Auto-generated Javadoc
/**
 * The Interface SchedularTasksManager.
 */
public interface SchedularTasksManager {

    /**
     * Adds the books.
     * 
     * @throws ServiceException
     *             the service exception
     */
    void addBooks() throws ServiceException;

    /**
     * Delete books.
     * 
     * @throws ServiceException
     *             the service exception
     */
    void deleteBooks() throws ServiceException;

}
