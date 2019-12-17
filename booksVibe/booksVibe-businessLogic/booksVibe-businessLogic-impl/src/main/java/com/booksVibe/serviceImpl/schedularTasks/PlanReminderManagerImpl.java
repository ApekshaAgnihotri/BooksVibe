package com.booksVibe.serviceImpl.schedularTasks;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.booksVibe.dao.DTO.UserSubsDTO;
import com.booksVibe.dao.schedularTasks.PlanReminderDao;
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.schedularTasks.PlanReminderManager;
import com.booksVibe.service.valueObject.UserSubsVO;
import com.booksVibe.serviceImpl.serviceHelper.ServiceHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class PlanReminderManagerImpl.
 */
public class PlanReminderManagerImpl implements PlanReminderManager {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(PlanReminderManagerImpl.class);

    /** The plan reminder dao. */
    @Autowired
    private PlanReminderDao planReminderDao;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.service.schedularTasks.PlanReminderManager#getUsersListByMonth
     * ()
     */
    public List<UserSubsVO> getUsersListByMonth() throws ServiceException {
        // TODO Auto-generated method stub
        try {

            LOGGER.info("IN SERVICE");
            List<UserSubsDTO> usersListByMonthDTO = planReminderDao
                    .getUsersListByMonth();

            List<UserSubsVO> usersListByMonthVO = new ArrayList<UserSubsVO>();

            usersListByMonthVO = ServiceHelper.usersSubsDetailsTransfer(
                    usersListByMonthDTO, usersListByMonthVO);

            return usersListByMonthVO;

        } catch (Exception e) {
            LOGGER.error("EXCEPTION IN SERVICE" + e);
            throw new ServiceException(e);
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.service.schedularTasks.PlanReminderManager#getUsersListByWeek
     * ()
     */
    public List<UserSubsVO> getUsersListByWeek() throws ServiceException {
        // TODO Auto-generated method stub
        try {

            LOGGER.info("IN SERVICE");
            List<UserSubsDTO> usersListByWeekDTO = planReminderDao
                    .getUsersListByWeek();

            List<UserSubsVO> usersListByWeekVO = new ArrayList<UserSubsVO>();
            usersListByWeekVO = ServiceHelper.usersSubsDetailsTransfer(
                    usersListByWeekDTO, usersListByWeekVO);

            LOGGER.info("LIST SIZE:" + usersListByWeekVO.size());
            return usersListByWeekVO;

        } catch (Exception e) {
            LOGGER.error("EXCEPTION IN SERVICE" + e);
            throw new ServiceException(e);
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.service.schedularTasks.PlanReminderManager#getUsersListByDay
     * ()
     */
    public List<UserSubsVO> getUsersListByDay() throws ServiceException {
        // TODO Auto-generated method stub
        try {

            LOGGER.info("IN SERVICE");
            List<UserSubsDTO> usersListByDayDTO = planReminderDao
                    .getUsersListByDay();

            List<UserSubsVO> usersListByDayVO = new ArrayList<UserSubsVO>();
            usersListByDayVO = ServiceHelper.usersSubsDetailsTransfer(
                    usersListByDayDTO, usersListByDayVO);

            LOGGER.info("LIST SIZE:" + usersListByDayVO.size());
            return usersListByDayVO;

        } catch (Exception e) {
            LOGGER.error("EXCEPTION IN SERVICE" + e);
            throw new ServiceException(e);
        }

    }

}
