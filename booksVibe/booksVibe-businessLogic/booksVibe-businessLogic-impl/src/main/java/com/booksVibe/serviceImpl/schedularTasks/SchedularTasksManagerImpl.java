package com.booksVibe.serviceImpl.schedularTasks;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.booksVibe.dao.schedularTasks.SchedularTasksDao;
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.schedularTasks.SchedularTasksManager;

// TODO: Auto-generated Javadoc
/**
 * The Class SchedularTasksManagerImpl.
 */
public class SchedularTasksManagerImpl implements SchedularTasksManager {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(SchedularTasksManagerImpl.class);

    /** The schedular dao. */
    @Autowired
    private SchedularTasksDao schedularDao;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.service.schedularTasks.SchedularTasksManager#addBooks()
     */
    public void addBooks() throws ServiceException {
        // TODO Auto-generated method stub
        try {

           
            schedularDao.addBooks();

        } catch (Exception e) {
            throw new ServiceException(e);
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.service.schedularTasks.SchedularTasksManager#deleteBooks()
     */
    public void deleteBooks() throws ServiceException {
        try {
            LOGGER.info("IN SERVICE");
            schedularDao.deleteBooks();
        } catch (Exception e) {
            throw new ServiceException(e);
        }

    }

}
