package com.booksVibe.daoImpl.schedularTasks;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.booksVibe.dao.DTO.UserSubsDTO;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.schedularTasks.PlanReminderDao;
import com.booksVibe.daoImpl.daoConstants.DaoConstants;
import com.booksVibe.daoImpl.util.Utility;

// TODO: Auto-generated Javadoc
/**
 * The Class PlanReminderDaoImpl.
 */
public class PlanReminderDaoImpl implements PlanReminderDao {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(PlanReminderDaoImpl.class);
    private static final int THIRTY = 30, SEVEN = 7;
    /** The calendar. */
    private Calendar calendar = Calendar.getInstance();

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.dao.schedularTasks.PlanReminderDao#getUsersListByMonth()
     */
    public List<UserSubsDTO> getUsersListByMonth() throws DaoException {
        // TODO Auto-generated method stub
        Session session = Utility.getSessionFactory().openSession();
        try {

            LOGGER.info("FETCHING USERS LIST TO GET ALERTED A MONTH BEFORE");

            calendar.setTime(new Date());
            calendar.add(Calendar.DATE, THIRTY);
            Date date = calendar.getTime();

            java.sql.Date newDate = new java.sql.Date(date.getTime());
            LOGGER.info("EXPECTED EXPIRY DATE::::" + newDate);

            String query = "FROM UserSubsDTO WHERE subEnd ='" + newDate
                    + "' AND status=:status";

            Query q = session.createQuery(query);
            q.setParameter("status", DaoConstants.ACTIVE);
            List<UserSubsDTO> userListByMonth = (List<UserSubsDTO>) q.list();

            return userListByMonth;
        } catch (HibernateException e) {
            LOGGER.error("EXCEPTION FETCHING USERS LIST A MONTH BEFORE" + e);
            throw new DaoException(e);
        } finally {
            session.close();

        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.dao.schedularTasks.PlanReminderDao#getUsersListByWeek()
     */
    public List<UserSubsDTO> getUsersListByWeek() throws DaoException {
        // TODO Auto-generated method stub
        Session session = Utility.getSessionFactory().openSession();
        try {
            LOGGER.info("FETCHING LIST IN DAO TO BE ALRETED BEFORE A WEEK");

            calendar.add(Calendar.DATE, SEVEN);
            Date date = calendar.getTime();

            java.sql.Date newDate = new java.sql.Date(date.getTime());

            String query = "FROM UserSubsDTO WHERE subEnd ='" + newDate
                    + "' AND status=:status";

            Query q = session.createQuery(query);
            q.setParameter("status", DaoConstants.ACTIVE);
            List<UserSubsDTO> userListByWeek = (List<UserSubsDTO>) q.list();

            LOGGER.info("lIST SIZE RETRIVED:" + userListByWeek.size());

            return userListByWeek;
        } catch (HibernateException e) {
            LOGGER.info("EXCEPTION FETCIHNG LIST A WEEK BEFORE" + e);
            throw new DaoException(e);
        } finally {
            session.close();

        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.booksVibe.dao.schedularTasks.PlanReminderDao#getUsersListByDay()
     */
    public List<UserSubsDTO> getUsersListByDay() throws DaoException {
        // TODO Auto-generated method stub
        Session session = Utility.getSessionFactory().openSession();
        try {
            LOGGER.info("FETCHING LIST IN DAO TO BE ALERETED A DAY BEFORE");
            calendar.add(Calendar.DATE, 1);
            Date date = calendar.getTime();

            java.sql.Date newDate = new java.sql.Date(date.getTime());

            String query = "FROM UserSubsDTO WHERE subEnd ='" + newDate
                    + "' AND status=:status";

            Query q = session.createQuery(query);
            q.setParameter("status", DaoConstants.ACTIVE);
            List<UserSubsDTO> userListByDay = (List<UserSubsDTO>) q.list();

            LOGGER.info("lIST SIZE RETRIVED:" + userListByDay.size());

            return userListByDay;

        } catch (HibernateException e) {
            throw new DaoException(e);
        } finally {
            session.close();
        }
    }

}
