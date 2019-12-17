package com.booksVibe.daoImpl.schedularTasks;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.booksVibe.dao.DTO.UserSubsDTO;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.schedularTasks.AlterPlanStatusDao;
import com.booksVibe.daoImpl.daoConstants.DaoConstants;
import com.booksVibe.daoImpl.util.Utility;

// TODO: Auto-generated Javadoc
/**
 * The Class AlterPlanStatusDaoImpl.
 */
public class AlterPlanStatusDaoImpl implements AlterPlanStatusDao {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(AlterPlanStatusDaoImpl.class);

    /*
     * (non-Javadoc)
     * 
     * @see com.booksVibe.dao.schedularTasks.AlterPlanStatusDao#getUsersList()
     */
    public List<UserSubsDTO> getUsersList() throws DaoException {
        Session session = Utility.getSessionFactory().openSession();
        try {

            Criteria criteria = session.createCriteria(UserSubsDTO.class);

            Date endDate = new Date();
            DateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd",
                    Locale.ENGLISH);
            outputDateFormat.setTimeZone(TimeZone.getDefault());

            String dateString1 = outputDateFormat.format(endDate);
            Date currentDate = new java.sql.Date(outputDateFormat.parse(
                    dateString1).getTime());

            LOGGER.info("CURRENT DATE:" + currentDate);

            criteria.add(Restrictions.eq("subEnd", currentDate));
            List<UserSubsDTO> expiredUserList = (ArrayList<UserSubsDTO>) criteria.list();
            LOGGER.info("LIST SIZE::" + expiredUserList.size());
            return expiredUserList;

        } catch (HibernateException e) {
            LOGGER.error("EXCEPTION IN DAO FETCHING USERS LIST" + e);
            throw new DaoException(e);
        } 
        catch(ParseException e){
            throw new DaoException(e);
        }
        finally {
            session.close();

        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.dao.schedularTasks.AlterPlanStatusDao#alterPlanStatus(java
     * .util.List)
     */
    public void alterPlanStatus(List<UserSubsDTO> expiredUserList)
            throws DaoException {
        Session session = Utility.getSessionFactory().openSession();
        try {

            session.beginTransaction();

            for (UserSubsDTO user : expiredUserList) {
                LOGGER.info("USER FETCHED" + user.getEmaild());
                user.setStatus(DaoConstants.INACTIVE);
                session.update(user);
                LOGGER.info("STATUS ALTERED");
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            LOGGER.error("EXCEPTION WHILE UPDATING USER'S STATUS" + e);
            throw new DaoException(e);
        } finally {
            session.close();

        }
    }
}
