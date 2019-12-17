package com.booksVibe.service.exceptions;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceException.
 */
public class ServiceException extends Exception {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(ServiceException.class);

    /**
     * Instantiates a new service exception.
     * 
     * @param e
     *            the e
     */
    public ServiceException(Exception e) {
        LOGGER.error("Exception in service layer" + e);
    }
}
