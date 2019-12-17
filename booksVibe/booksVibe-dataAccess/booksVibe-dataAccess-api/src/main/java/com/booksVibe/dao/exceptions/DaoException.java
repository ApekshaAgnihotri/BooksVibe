package com.booksVibe.dao.exceptions;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class DaoException.
 */
public class DaoException extends Exception {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger.getLogger(DaoException.class);

    /**
     * Instantiates a new dao exception.
     * 
     * @param e
     *            the e
     */
    public DaoException(Exception e) {
        LOGGER.error("Exception in Database" + e);
    }

}
