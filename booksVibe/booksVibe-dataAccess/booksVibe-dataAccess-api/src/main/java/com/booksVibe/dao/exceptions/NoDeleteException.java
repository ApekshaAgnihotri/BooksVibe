package com.booksVibe.dao.exceptions;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class NoDeleteException.
 */
public class NoDeleteException extends Exception {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(NoDeleteException.class);

    /**
     * Instantiates a new no delete exception.
     */
    public NoDeleteException() {
        LOGGER.error("BOOKS CAN NOT BE DELETED");
    }
}
