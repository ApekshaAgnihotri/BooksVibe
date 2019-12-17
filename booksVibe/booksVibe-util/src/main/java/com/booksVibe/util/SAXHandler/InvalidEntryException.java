package com.booksVibe.util.SAXHandler;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class InvalidEntryException.
 */
public class InvalidEntryException extends Exception {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(InvalidEntryException.class);

    /**
     * Instantiates a new invalid entry exception.
     */
    public InvalidEntryException() {
        LOGGER.error("INVALID ENTRY IN XML FILE");
    }
}
