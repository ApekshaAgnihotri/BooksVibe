package com.booksVibe.service.exceptions;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class SubscriptionPlanExpiredServiceException.
 */
public class SubscriptionPlanExpiredServiceException extends Exception {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(SubscriptionPlanExpiredServiceException.class);

    /**
     * Instantiates a new subscription plan expired service exception.
     */
    public SubscriptionPlanExpiredServiceException() {
        LOGGER.info("SUBSCRIPTION PLAN EXPIRED SERVICE EXCEPTION");
    }

}
