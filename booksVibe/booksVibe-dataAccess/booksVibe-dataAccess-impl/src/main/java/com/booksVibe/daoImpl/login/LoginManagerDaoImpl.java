package com.booksVibe.daoImpl.login;

import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.booksVibe.dao.DTO.SubsDetailsDTO;
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.DTO.UserSubsDTO;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.exceptions.InvalidUserException;
import com.booksVibe.dao.login.LoginManagerDao;
import com.booksVibe.daoImpl.daoConstants.DaoConstants;
import com.booksVibe.daoImpl.helper.DaoHelper;
import com.booksVibe.daoImpl.util.Utility;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginManagerDaoImpl.
 */
public class LoginManagerDaoImpl implements LoginManagerDao {

    /** The Constant logger. */
    private static final Logger LOGGER = Logger
            .getLogger(LoginManagerDaoImpl.class);

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.dao.login.LoginManagerDao#loginVerify(com.booksVibe.dao
     * .DTO.UserDTO)
     */

    @Autowired
    private UserSubsDTO userSubsDTO;

    private Calendar calendar = Calendar.getInstance();

    public UserDTO loginVerify(UserDTO userDTO) throws DaoException,
            InvalidUserException {

        UserDTO loginDTO = null;
        SessionFactory sessionFactory = Utility.getSessionFactory();
        Session session = sessionFactory.openSession();

       

        try {
            Criteria criteria = session.createCriteria(UserDTO.class);

            Criterion rest1 = Restrictions.eq("emaild", userDTO.getEmaild());
            Criterion rest2 = Restrictions.eq("password", userDTO.getPassword());
            Criterion rest3=Restrictions.eq("role",userDTO.getRole());
            criteria.add(Restrictions.and(rest1, rest2,rest3));

            List<UserDTO> userList = criteria.list();

            if (userList.size() > 0) {
                LOGGER.info("USER CREDENTIALS VERIFIED");
                loginDTO = userList.get(0);
                return loginDTO;

            } else {
                throw new InvalidUserException();
            }

        } catch (HibernateException e) {
            LOGGER.error("EXCEPTION IN DAO" + e);
            throw new DaoException(e);
        } finally {
            session.close();

        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.dao.login.LoginManagerDao#updateUserDetails(com.booksVibe
     * .dao.DTO.UserDTO)
     */
    public void updateUserDetails(UserDTO userDTO) throws DaoException {
        SessionFactory sessionFactory = Utility.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(userDTO);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            LOGGER.error("update userdetails dao exception" + e);
            throw new DaoException(e);
        } finally {
            session.close();
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.dao.login.LoginManagerDao#upgradePlan(com.booksVibe.dao
     * .DTO.UserDTO)
     */
    public void upgradePlan(UserDTO userDTO, int subsId) throws DaoException {
        Session session = Utility.getSessionFactory().openSession();
        try {

            session.beginTransaction();
           
            Criteria criteria = session.createCriteria(SubsDetailsDTO.class);
            criteria.add(Restrictions.eq("subsid", subsId));
            SubsDetailsDTO subsDetailsDTO = (SubsDetailsDTO) criteria.uniqueResult();

            userSubsDTO = DaoHelper.userSubsDetailsTransfer(userSubsDTO,subsDetailsDTO);
            int increment = subsDetailsDTO.getTimePeriod();

            calendar.setTime(new Date());
            calendar.add(Calendar.MONTH, increment);
            userSubsDTO.setSubStart(new Date());
            userSubsDTO.setSubEnd(calendar.getTime());
            userSubsDTO.setEmaild(userDTO.getEmaild());
            userSubsDTO.setStatus(DaoConstants.ACTIVE);

            session.save(userSubsDTO);

            session.getTransaction().commit();

            LOGGER.info("NEW PLAN SUBSCRIBED");

        } catch (HibernateException e) {
            LOGGER.info("EXCEPTION WHILE UPDATING PLAN" + e);
            throw new DaoException(e);
        }
    }

    public List<UserSubsDTO> viewSubscriptionHistory(UserDTO userDTO)
            throws DaoException {
        Session session = Utility.getSessionFactory().openSession();
        try {
            LOGGER.info("FETCHING HISTORY IN DAO");

            Criteria criteria = session.createCriteria(UserSubsDTO.class);
            criteria.add(Restrictions.conjunction()
                    .add(Restrictions.eq("emaild", userDTO.getEmaild()))
                    .add(Restrictions.eq("status", DaoConstants.INACTIVE)));

            List<UserSubsDTO> planListDTO = (List<UserSubsDTO>) criteria.list();

            LOGGER.info("LIST SIZE:" + planListDTO.size());
            return planListDTO;
        } catch (HibernateException e) {
            LOGGER.error("EXCEPTION IN FETCHING SUBSCRITION HISTORY" + e);
            throw new DaoException(e);
        }

    }
}