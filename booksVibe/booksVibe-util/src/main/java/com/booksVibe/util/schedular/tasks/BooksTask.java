package com.booksVibe.util.schedular.tasks;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.booksVibe.service.schedularTasks.SchedularTasksManager;

// TODO: Auto-generated Javadoc
/**
 * The Class BooksTask.
 */
public class BooksTask {

    /** The schedular tasks. */
    @Autowired
    private SchedularTasksManager schedularTasks;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger.getLogger(BooksTask.class);

    /**
     * Addbooks.
     */
    public void addbooks() {
        LOGGER.info("IN ADD BOOK TASK");

        try {
            schedularTasks.addBooks();
        } catch (Exception e) {
            LOGGER.error("EXCETPION IN ADD BOOKS TASK" + e);
        }

    }

    /**
     * Delete books.
     */
    public void deleteBooks() {
        try {
            LOGGER.info("ENTERED THE DELETEBOOKS METHOD IN THE SCHEDULAR..");
            schedularTasks.deleteBooks();
        } catch (Exception e) {
            LOGGER.error("EXCEPTION IN DELETE BOOKS TASK");
        }
    }
}
