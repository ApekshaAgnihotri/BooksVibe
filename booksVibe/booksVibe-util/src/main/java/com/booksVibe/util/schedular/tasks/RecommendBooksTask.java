package com.booksVibe.util.schedular.tasks;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.booksVibe.service.recommendation.RecommendBooksManager;

// TODO: Auto-generated Javadoc
/**
 * The Class RecommendBooksTask.
 */
public class RecommendBooksTask {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(RecommendBooksTask.class);

    /** The recommend books manager. */
    @Autowired
    private RecommendBooksManager recommendBooksManager;

    /**
     * Recommend books.
     */
    public void recommendBooks() {
        try {
            LOGGER.info("INTIATING RECOMMEND BOOKS TASK");
            recommendBooksManager.recommendBooks();
        } catch (Exception e) {
            LOGGER.error("EXCEPTION IN RECOMMEND BOOK TASK" + e);
        }
    }
}
