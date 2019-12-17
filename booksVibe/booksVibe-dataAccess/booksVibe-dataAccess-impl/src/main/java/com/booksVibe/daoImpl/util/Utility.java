package com.booksVibe.daoImpl.util;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

// TODO: Auto-generated Javadoc
/**
 * The Class Utility.
 */
@SuppressWarnings("deprecation")
public final class Utility {

    /** The Constant SF. */
    public static final SessionFactory SF;

    private Utility() {
    }

    /** The Constant LOGGER. */
    public static final Logger LOGGER = Logger.getLogger(Utility.class);
    static {
        try {
            SF = new AnnotationConfiguration().configure()
                    .buildSessionFactory();
            LOGGER.info("session factory created");
        } catch (Exception ex) {

            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Gets the session factory.
     * 
     * @return the session factory
     */
    public static SessionFactory getSessionFactory() {
        return SF;
    }
}
