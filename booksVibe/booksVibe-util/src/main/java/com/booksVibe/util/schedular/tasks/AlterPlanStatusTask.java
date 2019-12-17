package com.booksVibe.util.schedular.tasks;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.booksVibe.service.schedularTasks.AlterPlanStatusManager;

// TODO: Auto-generated Javadoc
/**
 * The Class AlterPlanStatusTask.
 */
public class AlterPlanStatusTask {

    /** The alter plan status manager. */
    @Autowired
    private AlterPlanStatusManager alterPlanStatusManager;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(AlterPlanStatusTask.class);

    /**
     * Alter plan status.
     */
    public void alterPlanStatus() {
        try {
            LOGGER.info("INITIATING ALTER PLAN STATUS TASK");
            alterPlanStatusManager.alterPlanStatus();
            LOGGER.info("ALTER STATUS TASK COMPLETED");
        } catch (Exception e) {
            LOGGER.error("EXCEPTION IN ALTER PLAN STATUS" + e);
        }
    }
}
