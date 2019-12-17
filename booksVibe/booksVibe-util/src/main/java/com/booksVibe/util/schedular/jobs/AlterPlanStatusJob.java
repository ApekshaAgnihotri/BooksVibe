package com.booksVibe.util.schedular.jobs;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.booksVibe.util.schedular.tasks.AlterPlanStatusTask;

// TODO: Auto-generated Javadoc
/**
 * The Class AlterPlanStatusJob.
 */
public class AlterPlanStatusJob extends QuartzJobBean {

    /** The alter plan status task. */
    private AlterPlanStatusTask alterPlanStatusTask;

    /**
     * Gets the alter plan status task.
     * 
     * @return the alter plan status task
     */
    public AlterPlanStatusTask getAlterPlanStatusTask() {
        return alterPlanStatusTask;
    }

    /**
     * Sets the alter plan status task.
     * 
     * @param alterPlanStatusTask
     *            the new alter plan status task
     */
    public void setAlterPlanStatusTask(AlterPlanStatusTask alterPlanStatusTask) {
        this.alterPlanStatusTask = alterPlanStatusTask;
    }

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(AlterPlanStatusJob.class);

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
        // TODO Auto-generated method stub
        try {
            alterPlanStatusTask.alterPlanStatus();
        } catch (Exception e) {
            LOGGER.error("EXCEPTION IN ALTER PLAN STATUS JOB" + e);
        }
    }

}
