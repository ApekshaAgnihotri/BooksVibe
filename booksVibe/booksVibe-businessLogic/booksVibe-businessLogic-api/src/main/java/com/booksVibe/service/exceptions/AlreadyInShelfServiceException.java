package com.booksVibe.service.exceptions;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class AlreadyInShelfServiceException.
 */
public class AlreadyInShelfServiceException extends Exception 
{

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger.getLogger(AlreadyInShelfServiceException.class);

    /**
     * Instantiates a new already in shelf service exception.
     * e is an instance of Exception
     * @param e
     *            the e
     */
    public AlreadyInShelfServiceException(Exception e) {
        LOGGER.info("BOOK ALREADY IN SHELF SERVICE EXCEPTION" + e);
    }
}
