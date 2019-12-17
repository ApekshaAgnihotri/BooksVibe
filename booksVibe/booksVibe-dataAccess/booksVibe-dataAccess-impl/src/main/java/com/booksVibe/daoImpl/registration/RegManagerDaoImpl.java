package com.booksVibe.daoImpl.registration;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import com.booksVibe.dao.DTO.SubsDetailsDTO;
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.DTO.UserSubsDTO;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.registration.RegManagerDao;
import com.booksVibe.daoImpl.daoConstants.DaoConstants;
import com.booksVibe.daoImpl.helper.DaoHelper;
import com.booksVibe.daoImpl.util.Utility;

// TODO: Auto-generated Javadoc
/**
 * The Class RegManagerDaoImpl. This class register a new user
 */
public class RegManagerDaoImpl implements RegManagerDao {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(RegManagerDaoImpl.class);

    /** The calendar. */
    private Calendar calendar = Calendar.getInstance();

    /**
     * (non-Javadoc).
     *
     * @param userDTO the user dto
     * @return true, if successful
     * @throws DaoException the dao exception
     * @see com.booksVibe.dao.registration.RegManagerDao#registerUser(com.booksVibe
     * .dao.DTO.UserDTO)
     */
    public boolean registerUser(UserDTO userDTO) throws DaoException {
        SessionFactory sessionFactory = Utility.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {

            Criteria criteria = session.createCriteria(UserDTO.class);
            criteria.add(Restrictions.eq("emaild", userDTO.getEmaild()));

            @SuppressWarnings("unchecked")
            List<UserDTO> userList = criteria.list();

            if (userList.size() == 0) {
                LOGGER.info("SAVING NEW USER");

                userDTO.setRole("user");
                session.save(userDTO);

                LOGGER.info("DATA IN USER TABLE SAVED");

                Criteria cr = session.createCriteria(SubsDetailsDTO.class);

                SubsDetailsDTO subsDetailsDTO = new SubsDetailsDTO();
                subsDetailsDTO.setSubsid(userDTO.getSubsid());

                cr.add(Restrictions.eq("subsid", subsDetailsDTO.getSubsid()));
                List<SubsDetailsDTO> subsList = cr.list();
                subsDetailsDTO = subsList.get(0);

                UserSubsDTO userSubsDTO = new UserSubsDTO();
                userSubsDTO = DaoHelper.userSubsDetailsTransfer(userSubsDTO,
                        subsDetailsDTO);

                int increment = subsDetailsDTO.getTimePeriod();

                calendar.setTime(new Date());
                calendar.add(Calendar.MONTH, increment);
                userSubsDTO.setSubStart(new Date());
                userSubsDTO.setSubEnd(calendar.getTime());
                userSubsDTO.setEmaild(userDTO.getEmaild());
                userSubsDTO.setStatus(DaoConstants.ACTIVE);

                session.save(userSubsDTO);
                session.getTransaction().commit();
                LOGGER.info("USER REGISTERED");

                return true;
            } else {
                LOGGER.info("EMAIL ID ALREADY EXIST");
                return false;
            }

        } catch (HibernateException e) {
            LOGGER.error("EXCEPTION IN DAO WHILE REGISTERING" + e);
            throw new DaoException(e);
        }

    }

    /**
     * (non-Javadoc).
     *
     * @return the list
     * @throws DaoException the dao exception
     * @see com.booksVibe.dao.registration.RegManagerDao#loadSubscription()
     */
    public List<SubsDetailsDTO> loadSubscription() throws DaoException {
        try {
            SessionFactory sessionFactory = Utility.getSessionFactory();
            Session session = sessionFactory.openSession();

            Criteria criteria = session.createCriteria(SubsDetailsDTO.class);
            criteria.add(Restrictions.eq("status",DaoConstants.ACTIVE));

            List<SubsDetailsDTO> subsList = criteria.list();

            return subsList;
        } catch (HibernateException e) {
            LOGGER.error("exception in loadsubscription dao" + e);
            throw new DaoException(e);

        }

    }

    /**
     * (non-Javadoc).
     *
     * @param emaild the emaild
     * @return true, if successful
     * @throws DaoException the dao exception
     * @see com.booksVibe.dao.registration.RegManagerDao#checkStatus(java.lang.String
     * )
     */
    public boolean checkStatus(String emaild) throws DaoException {
        Session session = Utility.getSessionFactory().openSession();
        boolean s = false;
        try {
            LOGGER.info("CHECKING STATUS IN DAO" + emaild);
            Criteria criteria = session.createCriteria(UserSubsDTO.class);
            Criterion user = Restrictions.eq("emaild", emaild);
            Criterion status = Restrictions.eq("status", DaoConstants.ACTIVE);
            criteria.add(Restrictions.and(user,status));
            List<UserSubsDTO> list = criteria.list();
            LOGGER.info("LIST SIZE:"+list.size());
            if (list.size() > 0) {
                s=true;
                return s;
            } else {
                return s;
            }
        } catch (HibernateException e) {
            LOGGER.error("EXCEPTION IN CHECKING STATUS" + e);
            throw new DaoException(e);
        }

    }
    
    

    /** (non-Javadoc)
     * @see com.booksVibe.dao.registration.RegManagerDao#registerOperator(com.booksVibe.dao.DTO.UserDTO)
     */
    public boolean registerOperator(UserDTO userDTO) throws DaoException {
        // TODO Auto-generated method stub
        Session session = Utility.getSessionFactory().openSession();
        try {
            Criteria criteria = session.createCriteria(UserDTO.class);
            criteria.add(Restrictions.eq("emaild", userDTO.getEmaild()));
            List<UserDTO> list = criteria.list();
            if (list.size() == 0) {
                session.beginTransaction();
                userDTO.setRole("admin");
                session.save(userDTO);
                session.getTransaction().commit();
                return true;
            } else {
                return false;
            }
        } catch (HibernateException e) {
            LOGGER.error("EXCEPTION IN REGISTERING OPERATOR" + e);
            throw new DaoException(e);
        }
    }
}
