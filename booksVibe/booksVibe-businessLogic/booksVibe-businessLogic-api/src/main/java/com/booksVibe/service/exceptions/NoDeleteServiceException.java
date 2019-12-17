package com.booksVibe.service.exceptions;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class NoDeleteServiceException.
 */
public class NoDeleteServiceException extends Exception {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(NoDeleteServiceException.class);

    /**
     * Instantiates a new no delete service exception.
     * 
     * @param e
     *            the e
     */
    public NoDeleteServiceException(Exception e) {
        LOGGER.error("Exception in service layer" + e);
    }
}
