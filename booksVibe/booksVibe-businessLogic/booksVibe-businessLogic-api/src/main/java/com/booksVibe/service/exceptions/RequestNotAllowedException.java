package com.booksVibe.service.exceptions;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class RequestNotAllowedException.
 */
public class RequestNotAllowedException extends Exception {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(RequestNotAllowedException.class);

    /**
     * Instantiates a new request not allowed exception.
     */
    public RequestNotAllowedException() {
        LOGGER.info("YOU HAVE ALREADY REACHED MAX BOOK COUNT IN YOUR SUBSCRIPTION PLAN");
    }

}
