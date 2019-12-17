package com.booksVibe.util.exception;

import org.apache.log4j.Logger;


// TODO: Auto-generated Javadoc
/**
 * The Class UtilException.
 */
public class UtilException extends Exception {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger.getLogger(UtilException.class);

    /**
     * Instantiates a new util exception.
     *
     * @param e the e
     */
    public UtilException(Exception e) {
        LOGGER.info("EXCEPTION IN UTILITY" + e);
    }
}
