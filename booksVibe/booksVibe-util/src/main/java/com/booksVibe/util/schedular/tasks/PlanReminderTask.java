package com.booksVibe.util.schedular.tasks;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.booksVibe.service.schedularTasks.PlanReminderManager;
import com.booksVibe.service.valueObject.UserSubsVO;
import com.booksVibe.util.exception.UtilException;
import com.booksVibe.util.mail.SendEmail;

// TODO: Auto-generated Javadoc
/**
 * The Class PlanReminderTask.
 */
public class PlanReminderTask {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(PlanReminderTask.class);

    /** The plan reminder manager. */
    @Autowired
    private PlanReminderManager planReminderManager;

    /** The send. */
    @Autowired
    private SendEmail send;

    /**
     * Gets the users list.
     * 
     * @return the users list
     */
    public void getUsersList() {
        try {

            LOGGER.info("EXECUTING GET USERS LIST TASK");

            List<UserSubsVO> usersListByMonth = planReminderManager
                    .getUsersListByMonth();
            LOGGER.info("LIST SIZE:" + usersListByMonth.size());

            sendMailAlerts(usersListByMonth);

            List<UserSubsVO> usersListByWeek = planReminderManager
                    .getUsersListByWeek();
            LOGGER.info("LIST SIZE:" + usersListByWeek.size());

            sendMailAlerts(usersListByWeek);

            List<UserSubsVO> usersListByDay = planReminderManager
                    .getUsersListByDay();
            LOGGER.info("LIST SIZE:" + usersListByDay.size());
            sendMailAlerts(usersListByDay);

        } catch (Exception e) {
            LOGGER.error("TASK EXCEPTION" + e);

        }
    }

    /**
     * Send mail alerts.
     * 
     * @param userList
     *            the user list
     * @throws UtilException
     */
    public void sendMailAlerts(List<UserSubsVO> userList) {
      try{
        for (UserSubsVO userSubsVO : userList) {
            send.requestMail(userSubsVO);
        }
      }
      catch(UtilException e){
          LOGGER.error("EXCEPTION IN SENDING REMINDER MAIL"+e);
      }
     }
}