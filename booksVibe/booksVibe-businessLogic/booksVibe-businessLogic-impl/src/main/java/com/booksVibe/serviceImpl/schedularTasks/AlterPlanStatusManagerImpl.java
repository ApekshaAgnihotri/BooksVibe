package com.booksVibe.serviceImpl.schedularTasks;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.booksVibe.dao.DTO.UserSubsDTO;
import com.booksVibe.dao.schedularTasks.AlterPlanStatusDao;
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.schedularTasks.AlterPlanStatusManager;

// TODO: Auto-generated Javadoc
/**
 * The Class AlterPlanStatusManagerImpl.
 */
public class AlterPlanStatusManagerImpl implements AlterPlanStatusManager {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(AlterPlanStatusManagerImpl.class);

    /** The alter plan status dao. */
    @Autowired
    private AlterPlanStatusDao alterPlanStatusDao;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.service.schedularTasks.AlterPlanStatusManager#alterPlanStatus
     * ()
     */
    public void alterPlanStatus() throws ServiceException {
        // TODO Auto-generated method stub
        try {
            LOGGER.info("IN SERVICE");
            List<UserSubsDTO> expiredUserList = alterPlanStatusDao
                    .getUsersList();

            alterPlanStatusDao.alterPlanStatus(expiredUserList);
        } catch (Exception e) {
            LOGGER.error("EXCEPTION IN SERVICE WHILE ALTERING PLAN STATUS" + e);
            throw new ServiceException(e);
        }
    }

}
