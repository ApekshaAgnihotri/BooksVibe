package com.booksVibe.dao.exceptions;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class AlreadyInShelfException.
 */
public class AlreadyInShelfException extends Exception {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(AlreadyInShelfException.class);

    /**
     * Instantiates a new already in shelf exception.
     */
    public AlreadyInShelfException() {
        LOGGER.info("BOOK ALREADY PRESENT IN THE USER'S SHELF");
    }
}
