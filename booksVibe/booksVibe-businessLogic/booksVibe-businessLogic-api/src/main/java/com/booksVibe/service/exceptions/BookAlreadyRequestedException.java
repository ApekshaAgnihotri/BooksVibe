package com.booksVibe.service.exceptions;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class BookAlreadyRequestedException.
 */
public class BookAlreadyRequestedException extends Exception {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(BookAlreadyRequestedException.class);

    /**
     * Instantiates a new book already requested exception.
     */
    public BookAlreadyRequestedException() {
        LOGGER.info("BOOK ALREADY REQUESTED BY THE USER");
    }

}
