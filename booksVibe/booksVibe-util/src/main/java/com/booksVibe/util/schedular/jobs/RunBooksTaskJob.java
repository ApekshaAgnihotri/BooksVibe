package com.booksVibe.util.schedular.jobs;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.booksVibe.util.schedular.tasks.BooksTask;
import com.booksVibe.util.schedular.tasks.RecommendBooksTask;

// TODO: Auto-generated Javadoc
/**
 * The Class RunBooksTaskJob.
 */
public class RunBooksTaskJob extends QuartzJobBean {

    /** The books task. */
    private BooksTask booksTask;

    /**
     * Sets the books task.
     * 
     * @param booksTask
     *            the new books task
     */
    public void setBooksTask(BooksTask booksTask) {
        this.booksTask = booksTask;
    }

    /** The recommend books task. */
    private RecommendBooksTask recommendBooksTask;

    /**
     * Gets the recommend books task.
     * 
     * @return the recommend books task
     */
    public RecommendBooksTask getRecommendBooksTask() {
        return recommendBooksTask;
    }

    /**
     * Sets the recommend books task.
     * 
     * @param recommendBooksTask
     *            the new recommend books task
     */
    public void setRecommendBooksTask(RecommendBooksTask recommendBooksTask) {
        this.recommendBooksTask = recommendBooksTask;
    }

    /**
     * Gets the books task.
     * 
     * @return the books task
     */
    public BooksTask getBooksTask() {
        return booksTask;
    }

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(RunBooksTaskJob.class);

    /**
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.scheduling.quartz.QuartzJobBean#executeInternal(org
     * .quartz.JobExecutionContext)
     */
    @Override
    protected void executeInternal(JobExecutionContext arg0)
            throws JobExecutionException {
        try {

             booksTask.addbooks();
             booksTask.deleteBooks();
             recommendBooksTask.recommendBooks();

        } catch (Exception e) {
            LOGGER.error("EXCEPTION IN RUN BOOKS TASK JOB" + e);
        }
    }

}
