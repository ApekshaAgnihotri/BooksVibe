package com.booksVibe.service.exceptions;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class InvalidUserServiceExcpetion.
 */
public class InvalidUserServiceExcpetion extends Exception {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(InvalidUserServiceExcpetion.class);

    /**
     * Instantiates a new invalid user service excpetion.
     */
    public InvalidUserServiceExcpetion() {
        LOGGER.error("INVALID USER NAME AND PASSWORD EXCEPTION");
    }

    public InvalidUserServiceExcpetion(String e) {
        LOGGER.error("INVALID USER NAME AND PASSWORD EXCEPTION" + e);
    }
}
