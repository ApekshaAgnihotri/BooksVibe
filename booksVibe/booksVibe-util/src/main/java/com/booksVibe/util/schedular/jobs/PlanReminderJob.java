package com.booksVibe.util.schedular.jobs;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.booksVibe.util.schedular.tasks.PlanReminderTask;

// TODO: Auto-generated Javadoc
/**
 * The Class PlanReminderJob.
 */
public class PlanReminderJob extends QuartzJobBean {

    /** The plan reminder task. */
    private PlanReminderTask planReminderTask;

    /**
     * Sets the plan reminder task.
     * 
     * @param planReminderTask
     *            the new plan reminder task
     */
    public void setPlanReminderTask(PlanReminderTask planReminderTask) {
        this.planReminderTask = planReminderTask;
    }

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(PlanReminderJob.class);

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
            planReminderTask.getUsersList();

        } catch (Exception e) {
            LOGGER.error("EXCEPTION IN PLAN REMIBDER JOB");
        }
    }

}
