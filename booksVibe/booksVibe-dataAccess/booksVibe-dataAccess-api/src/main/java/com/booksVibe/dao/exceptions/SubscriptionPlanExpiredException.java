package com.booksVibe.dao.exceptions;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class SubscriptionPlanExpiredException.
 */
public class SubscriptionPlanExpiredException extends Exception {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(SubscriptionPlanExpiredException.class);

    /**
     * Instantiates a new subscription plan expired exception.
     */
    public SubscriptionPlanExpiredException() {
        LOGGER.error("SUBSCRIPTION PLAN EXPIRED");
    }
}
