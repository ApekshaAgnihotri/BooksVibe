package com.booksVibe.daoImpl.requestHandler;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.booksVibe.dao.DTO.RequestBookDTO;
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.DTO.UserSubsDTO;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.requestHandler.RequestHandlerManagerDao;
import com.booksVibe.daoImpl.daoConstants.DaoConstants;
import com.booksVibe.daoImpl.util.Utility;

// TODO: Auto-generated Javadoc
/**
 * The Class RequestHandlerManagerDaoImpl.
 */
public class RequestHandlerManagerDaoImpl implements RequestHandlerManagerDao {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(RequestHandlerManagerDaoImpl.class);

    
     
    /** The Constant OPERATOR. */
    private static final String REQUEST_STATUS = "requestStatus",OPERATOR="operator";
    
    
    /**
     * (non-Javadoc).
     *
     * @param operator the operator
     * @return the list
     * @throws DaoException the dao exception
     * @see com.booksVibe.dao.requestHandler.RequestHandlerManagerDao#viewRequestedBooks
     * ()
     */
    public List<RequestBookDTO> viewRequestedBooks(UserDTO operator)
            throws DaoException {
        // TODO Auto-generated method stub
        Session session = Utility.getSessionFactory().openSession();
        try {
            LOGGER.info("VIEW REQUESTED BOOKS IN DAO."+operator.getEmaild());

            Criteria criteria = session.createCriteria(RequestBookDTO.class);
            criteria.add(Restrictions.conjunction()
                    .add(Restrictions.eq(REQUEST_STATUS,DaoConstants.PENDING))
                    .add(Restrictions.eq(OPERATOR,operator)));

            List<RequestBookDTO> requestedBooksList = (List<RequestBookDTO>) criteria.list();

            LOGGER.info("SIZE OF LIST RETREIVED" + requestedBooksList.size());

            return requestedBooksList;

        } catch (HibernateException e) {
            throw new DaoException(e);
        }

    }

    /**
     * (non-Javadoc).
     *
     * @param operator the operator
     * @return the list
     * @throws DaoException the dao exception
     * @see com.booksVibe.dao.requestHandler.RequestHandlerManagerDao#
     * viewBooksToBeReturned()
     */
    public List<RequestBookDTO> viewBooksToBeReturned(UserDTO operator) throws DaoException {
        Session session = Utility.getSessionFactory().openSession();
        try {
            LOGGER.info("VIEW BOOKS TO BE REQUESTED IN DAO.");
            Criteria criteria = session.createCriteria(RequestBookDTO.class);

            criteria.add(Restrictions.conjunction()
                    .add(Restrictions.eq(OPERATOR,operator))
                    .add(Restrictions.eq(REQUEST_STATUS,DaoConstants.RETURN_REQUEST)));

            List<RequestBookDTO> requestedBooksList = (List<RequestBookDTO>) criteria.list();

            LOGGER.info("SIZE OF LIST RETREIVED:   " + requestedBooksList.size());

            return requestedBooksList;
        } catch (HibernateException e) {
            throw new DaoException(e);
        }
    }

    /**
     * (non-Javadoc).
     *
     * @param requestId the request id
     * @throws DaoException the dao exception
     * @see com.booksVibe.dao.requestHandler.RequestHandlerManagerDao#
     * approveDeleiveryRequest(int)
     */
    public void approveDeleiveryRequest(int requestId) throws DaoException
    {
        Session session = Utility.getSessionFactory().openSession();
      try
      {
            LOGGER.info("APPROVING IN DAO.");
            session.beginTransaction();

            Criteria criteria = session.createCriteria(RequestBookDTO.class);
            criteria.add(Restrictions.eq("requestId", requestId));
            RequestBookDTO requestDTO = (RequestBookDTO) criteria.uniqueResult();

            requestDTO = (RequestBookDTO) criteria.uniqueResult();
            requestDTO.setRequestStatus(DaoConstants.APPROVED);
            requestDTO.setRequestDate(new Date());
            session.update(requestDTO);
            session.getTransaction().commit();
            LOGGER.info("STATUS SUCCESSFULLY UPDATED");
        }
        catch (HibernateException e) 
        {
            LOGGER.error("EXCEPTION WHILE APPROVING DELEIVERY REQUEST" + e);
            throw new DaoException(e);
        }
    }

    /**
     * (non-Javadoc).
     *
     * @param requestId the request id
     * @throws DaoException the dao exception
     * @see com.booksVibe.dao.requestHandler.RequestHandlerManagerDao#closeReturnRequest
     * (int)
     */
    public void closeReturnRequest(int requestId) throws DaoException
    {

        Session session = Utility.getSessionFactory().openSession();
        try 
        {
            LOGGER.info("CLOSING IN DAO.");
            session.beginTransaction();

            Criteria criteria = session.createCriteria(RequestBookDTO.class);
            criteria.add(Restrictions.eq("requestId", requestId));
            RequestBookDTO requestDTO = (RequestBookDTO) criteria.uniqueResult();
            requestDTO.setRequestStatus(DaoConstants.CLOSE);
            requestDTO.setReturnDate(new Date());
            session.update(requestDTO);
            session.getTransaction().commit();
            LOGGER.info("STATUS SUCCESSFULLY UPDATED");

        } 
        catch (HibernateException e)
        {
            LOGGER.error("EXCEPTION WHILE CLOSING RETURN REQUEST" + e);
            throw new DaoException(e);
        }
    }

    /**
     * (non-Javadoc).
     *
     * @return the list
     * @throws DaoException the dao exception
     * @see com.booksVibe.dao.requestHandler.RequestHandlerManagerDao#viewUsers()
     */
    public List<UserSubsDTO> viewUsers() throws DaoException {
        // TODO Auto-generated method stub
        Session session = Utility.getSessionFactory().openSession();
        try {
            LOGGER.info("REQUESTING USERS LIST IN DAO");
            Criteria criteria = session.createCriteria(UserSubsDTO.class);

            criteria.add(Restrictions.eq("status", DaoConstants.ACTIVE));
            List<UserSubsDTO> usersList = (List<UserSubsDTO>) criteria.list();
            LOGGER.info("SIZE OF LIST RETRIEVED FROM DATABASE:"
                    + usersList.size());

            return usersList;
        } catch (HibernateException e) {
            LOGGER.equals("EXCEPTION  WHILE RETRIEVING USERS LIST FROM DATABASE");
            throw new DaoException(e);
        }

    }

    
    /**
     *  (non-Javadoc).
     *
     * @param operator the operator
     * @return the list
     * @throws DaoException the dao exception
     * @see com.booksVibe.dao.requestHandler.RequestHandlerManagerDao#viewApprovedRequests(com.booksVibe.dao.DTO.UserDTO)
     */
    public List<RequestBookDTO> viewApprovedRequests(UserDTO operator)throws DaoException {
        Session session = Utility.getSessionFactory().openSession();
        try {
            LOGGER.info("VIEW BOOKS TO BE REQUESTED IN DAO.");
           
            Criteria criteria = session.createCriteria(RequestBookDTO.class);
            java.sql.Date date=new java.sql.Date(Calendar.getInstance().getTimeInMillis());
            criteria.add(Restrictions.conjunction()
                    .add(Restrictions.eq(OPERATOR,operator))
                    .add(Restrictions.eq(REQUEST_STATUS,DaoConstants.APPROVED))
                    .add(Restrictions.eq("requestDate",date)));
                    
            List<RequestBookDTO> requestedBooksList = (List<RequestBookDTO>) criteria.list();

            LOGGER.info("SIZE::" + requestedBooksList.size());

            return requestedBooksList;
        } catch (HibernateException e) {
            throw new DaoException(e);
        }
    }

    /**
     *  
     * (non-Javadoc).
     *
     * @param operator the operator
     * @return the list
     * @throws DaoException the dao exception
     * @see com.booksVibe.dao.requestHandler.RequestHandlerManagerDao#viewClosedRequests(com.booksVibe.dao.DTO.UserDTO)
     */
    public List<RequestBookDTO> viewClosedRequests(UserDTO operator)throws DaoException {
        Session session = Utility.getSessionFactory().openSession();
        try {
            LOGGER.info("VIEW CLOSED REQUESTS IN DAO.");
            
            Criteria criteria = session.createCriteria(RequestBookDTO.class);
            java.sql.Date date=new java.sql.Date(Calendar.getInstance().getTimeInMillis());
            criteria.add(Restrictions.conjunction()
                    .add(Restrictions.eq(OPERATOR,operator))
                    .add(Restrictions.eq(REQUEST_STATUS,DaoConstants.CLOSE))
                    .add(Restrictions.eq("returnDate",date)));

            List<RequestBookDTO> requestedBooksList = (List<RequestBookDTO>) criteria.list();

            LOGGER.info("SIZE OF LIST:" + requestedBooksList.size());

            return requestedBooksList;
        } catch (HibernateException e) {
            throw new DaoException(e);
        }
    }

    
    /** (non-Javadoc)
     * @see com.booksVibe.dao.requestHandler.RequestHandlerManagerDao#viewTodaysRequestedBooks(com.booksVibe.dao.DTO.UserDTO)
     */
    public List<RequestBookDTO> viewTodaysRequestedBooks(UserDTO operator)throws DaoException {
        // TODO Auto-generated method stub
        Session session = Utility.getSessionFactory().openSession();
        try {
            LOGGER.info("VIEW REQUESTED BOOKS IN DAO."+operator.getEmaild());
            java.sql.Date date=new java.sql.Date(Calendar.getInstance().getTimeInMillis());
            Criteria criteria = session.createCriteria(RequestBookDTO.class);
            criteria.add(Restrictions.conjunction()
                    .add(Restrictions.eq(REQUEST_STATUS,DaoConstants.PENDING))
                    .add(Restrictions.eq(OPERATOR,operator))
                    .add(Restrictions.eq("requestDate",date)));

            List<RequestBookDTO> requestedBooksList = (List<RequestBookDTO>) criteria.list();

            LOGGER.info("SIZE OF LIST RETREIVED:" + requestedBooksList.size());

            return requestedBooksList;

        } catch (HibernateException e) {
            throw new DaoException(e);
        }

    }

    /**
     * (non-Javadoc)
     * 
     * @see com.booksVibe.dao.requestHandler.RequestHandlerManagerDao#
     * viewBooksToBeReturned()
     */
    public List<RequestBookDTO> viewTodaysBooksToBeReturned(UserDTO operator) throws DaoException {
        Session session = Utility.getSessionFactory().openSession();
        try {
            LOGGER.info("VIEW BOOKS TO BE REQUESTED IN DAO.");
            Criteria criteria = session.createCriteria(RequestBookDTO.class);
            java.sql.Date date=new java.sql.Date(Calendar.getInstance().getTimeInMillis());
            criteria.add(Restrictions.conjunction()
                    .add(Restrictions.eq(OPERATOR,operator))
                    .add(Restrictions.eq(REQUEST_STATUS,DaoConstants.RETURN_REQUEST))
                    .add(Restrictions.eq("returnDate",date)));

            List<RequestBookDTO> requestedBooksList = (List<RequestBookDTO>) criteria.list();

            LOGGER.info("SIZE OF LIST RETREIVED: " + requestedBooksList.size());

            return requestedBooksList;
        } catch (HibernateException e) {
            throw new DaoException(e);
        }
    }

    
    
    
}