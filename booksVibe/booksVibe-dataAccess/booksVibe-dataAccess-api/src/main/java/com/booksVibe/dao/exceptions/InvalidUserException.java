package com.booksVibe.dao.exceptions;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class InvalidUserException.
 */
public class InvalidUserException extends Exception {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(InvalidUserException.class);

    /**
     * Instantiates a new invalid user exception.
     */
    public InvalidUserException() {
        LOGGER.info("Invalid User");
    }

}
