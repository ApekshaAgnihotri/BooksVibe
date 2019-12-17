package com.booksVibe.daoImpl.requestBook;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;

import com.booksVibe.dao.DTO.BooksDTO;
import com.booksVibe.dao.DTO.RequestBookDTO;
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.DTO.UserSubsDTO;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.requestBook.RequestBookManagerDao;
import com.booksVibe.daoImpl.daoConstants.DaoConstants;
import com.booksVibe.daoImpl.util.Utility;

// TODO: Auto-generated Javadoc
/**
 * The Class RequestBookDaoImpl.
 */
public class RequestBookDaoImpl implements RequestBookManagerDao {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger.getLogger(RequestBookDaoImpl.class);

    /** The Constant MAX. */
    private static final int MAX = 1;
    
    /** The Constant USERDTO. */
    private static final String USERDTO = "userDTO";
    
    /** The Constant BOOKSDTO. */
    private static final String BOOKSDTO = "booksDTO";
    
    /** The Constant REQUEST_STATUS. */
    private static final String REQUEST_STATUS = "requestStatus";

    /**
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.dao.requestBook.RequestBookManagerDao#countRequestedBooks
     * (com.booksVibe.dao.DTO.RequestBookDTO)
     */
    public Integer countRequestedBooks(RequestBookDTO requestDTO)
            throws DaoException {

        LOGGER.info("COUNT REQUESTED BOOKS");
        Session session = Utility.getSessionFactory().openSession();
        try {

            Criteria criteria = session.createCriteria(RequestBookDTO.class);

            Criterion userRestriction = Restrictions.eq(USERDTO,requestDTO.getUserDTO());
            Criterion statusRestriction = Restrictions.eq(REQUEST_STATUS,DaoConstants.PENDING);

            criteria.add(Restrictions.and(userRestriction, statusRestriction));

            int requestedBooks = criteria.list().size();

            return requestedBooks;

        } catch (HibernateException e) {
            LOGGER.error("EXCEPTION WHILE COUNTING REQUESTS HAVING PENDING STATUS "+ e);
            throw new DaoException(e);
        } finally {
            session.close();

        }

    }

    /**
     * *(non-Javadoc)
     * 
     * @see
     * com.booksVibe.dao.requestBook.RequestBookManagerDao#countHoldingBooks
     * (com.booksVibe.dao.DTO.RequestBookDTO)
     */
    public Integer countHoldingBooks(RequestBookDTO requestDTO)
            throws DaoException {

        LOGGER.info("COUNT HOLDED BOOKS");
        Session session = Utility.getSessionFactory().openSession();
        try {

                Criteria criteria = session.createCriteria(RequestBookDTO.class);

                Criterion userRestriction = Restrictions.eq(USERDTO,requestDTO.getUserDTO());
                Criterion holdingBookRestriction =Restrictions.disjunction()
                        .add(Restrictions.eq(REQUEST_STATUS,DaoConstants.APPROVED))
                        .add(Restrictions.eq(REQUEST_STATUS, DaoConstants.RETURN_REQUEST));
               
                criteria.add(Restrictions.and(userRestriction,holdingBookRestriction));

                int holdingBooks = criteria.list().size();
                
            LOGGER.info("HOLDING BOOKS COUNT:" + holdingBooks);
            return holdingBooks;

        }
        catch (HibernateException e)
        {
            LOGGER.error("EXCEPTION WHILE COUNTING BOOKS ALREADY HELD BY USER"+ e);
            throw new DaoException(e);
        } finally {
            session.close();

        }

    }

    // is active and max books
    /**
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.dao.requestBook.RequestBookManagerDao#getSubscribedPlan
     * (com.booksVibe.dao.DTO.RequestBookDTO)
     */
    public UserSubsDTO getSubscribedPlan(RequestBookDTO requestDTO)
            throws DaoException {

        LOGGER.info("GET SUBSCRIPTION PLAN" + requestDTO.getUserDTO());
        Session session = Utility.getSessionFactory().openSession();
        try {
            Criteria criteria = session.createCriteria(UserSubsDTO.class);
            criteria.add(Restrictions.eq("emaild", requestDTO.getUserDTO()
                    .getEmaild()));
            criteria.addOrder(Order.desc("subEnd"));
            criteria.setMaxResults(MAX);
           
            return (UserSubsDTO) criteria.uniqueResult();

        } catch (HibernateException e) {
            LOGGER.error("EXCEPTION WHILE FETCHING SUBSCRIBED PLAN OF USER" + e);
            throw new DaoException(e);
        } finally {
            session.close();

        }

    }

    /** (non-Javadoc)
     * @see com.booksVibe.dao.requestBook.RequestBookManagerDao#checkIfPlanIsActive(com.booksVibe.dao.DTO.RequestBookDTO)
     */
    public boolean checkIfPlanIsActive(RequestBookDTO requestDTO)throws DaoException
    {
        LOGGER.info("GET SUBSCRIPTION PLAN");
        Session session = Utility.getSessionFactory().openSession();
        boolean status = false;
        try {
            Criteria criteria = session.createCriteria(UserSubsDTO.class);
            criteria.add(Restrictions.conjunction()
                    .add(Restrictions.eq("emaild", requestDTO.getUserDTO().getEmaild()))
                    .add(Restrictions.eq("status", DaoConstants.ACTIVE)));
            UserSubsDTO userSubsDTO = (UserSubsDTO) criteria.uniqueResult();
            if (userSubsDTO != null) {
                status = true;
            }
            return status;
        } catch (HibernateException e) {
            throw new DaoException(e);
        } finally {
            session.close();
        }
    }

    /**
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.dao.requestBook.RequestBookManagerDao#ifAlreadyRequested
     * (com.booksVibe.dao.DTO.RequestBookDTO)
     */
    public Boolean ifAlreadyRequested(RequestBookDTO requestDTO)
            throws DaoException {

        Boolean status = false;
        LOGGER.info("CHECK IF ALREADY REQUESTED");
        Session session = Utility.getSessionFactory().openSession();
        try {

            Criteria criteria = session.createCriteria(RequestBookDTO.class);

            Criterion userRestriction = Restrictions.eq(USERDTO,
                    requestDTO.getUserDTO());
            Criterion bookRestriction = Restrictions.eq(BOOKSDTO,
                    requestDTO.getBooksDTO());

            Criterion pendingStatusRestriction = Restrictions.eq(REQUEST_STATUS, DaoConstants.PENDING);
            Criterion approvedStatusRestriction = Restrictions.eq(REQUEST_STATUS, DaoConstants.APPROVED);
            Criterion returnStatusRestriction = Restrictions.eq(REQUEST_STATUS,DaoConstants.RETURN_REQUEST);

            Criterion statusRestriction = Restrictions.or(pendingStatusRestriction, approvedStatusRestriction,returnStatusRestriction);

            criteria.add(Restrictions.and(userRestriction, bookRestriction,
                    statusRestriction));

            RequestBookDTO requestsDTO = (RequestBookDTO) criteria
                    .uniqueResult();
            if (requestsDTO != null) {
                status = true;
                return status;
            } else {
                return status;
            }

        } catch (HibernateException e) {
            LOGGER.error("EXCEPTION WHILE CHECKING IF BOOK IS ALREADY REQUESTED"
                    + e);
            throw new DaoException(e);
        } finally {
            session.close();

        }
    }

    // reduce no of copies when requested
    /**
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.dao.requestBook.RequestBookManagerDao#requestBook(com.booksVibe
     * .dao.DTO.RequestBookDTO)
     */
    public void requestBook(RequestBookDTO requestDTO) throws DaoException {
        // TODO Auto-generated method stub
        LOGGER.info("*REQUEST BOOK FINALLY IN DAO");
        Session session = Utility.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            
            requestDTO.setOperator(assignOperator());
            LOGGER.info("OPERATOR IS:"+requestDTO.getOperator());
            
            requestDTO.setRequestStatus(DaoConstants.PENDING);
            requestDTO.setRequestDate(new Date());
            
            session.save(requestDTO);
            LOGGER.info("REQUEST SENT");

            session.getTransaction().commit();
        }
        catch (HibernateException e) {
            LOGGER.error("EXCEPTION WHILE REQUESTING BOOK" + e);
            throw new DaoException(e);
        }
        finally {
            session.close();

        }
    }

    /**
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.dao.requestBook.RequestBookManagerDao#updateBookCopies(
     * com.booksVibe.dao.DTO.BooksDTO)
     */
    public void updateBookCopies(BooksDTO booksDTO) throws DaoException {
        Session session = Utility.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(booksDTO);
            LOGGER.info("NO OF COPIES UPDATED" + booksDTO.getCopies());
            session.getTransaction().commit();

        } catch (HibernateException e) {
            LOGGER.error("EXCEPTION WHILE UPDATING NO OF COPIES" + e);
            throw new DaoException(e);
        } finally {
            session.close();

        }
    }

    /**
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.dao.requestBook.RequestBookManagerDao#viewRequestedBooks
     * (com.booksVibe.dao.DTO.RequestBookDTO)
     */
    public List<RequestBookDTO> viewRequestedBooks(RequestBookDTO requestDTO)
            throws DaoException {
        // TODO Auto-generated method stub
        LOGGER.info("REQUESTING LIST IN DAO");
        Session session = Utility.getSessionFactory().openSession();
        try {

            Criteria criteria = session.createCriteria(RequestBookDTO.class);

            Criterion userRestriction = (Restrictions.eq(USERDTO,
                    requestDTO.getUserDTO()));
            Criterion statusRestriction = (Restrictions.eq(REQUEST_STATUS,
                    DaoConstants.PENDING));
            criteria.add(Restrictions.and(userRestriction, statusRestriction));
            List<RequestBookDTO> requestedBooksList = (List<RequestBookDTO>) criteria.list();

            LOGGER.info("LIST RETRIEVED FROM DATABASE"
                    + requestedBooksList.size());
            return requestedBooksList;

        } catch (HibernateException e) {
            LOGGER.error("EXCEPTION WHILE FETCHING PENDING REQUESTS FROM DATABASE"
                    + e);
            throw new DaoException(e);
        } finally {
            session.close();

        }

    }

    /**
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.dao.requestBook.RequestBookManagerDao#viewIssuedBooks(com
     * .booksVibe.dao.DTO.RequestBookDTO)
     */
    public List<RequestBookDTO> viewIssuedBooks(RequestBookDTO requestDTO)
            throws DaoException {
        // TODO Auto-generated method stub
        LOGGER.info("REQUESTING LIST IN DAO");
        Session session = Utility.getSessionFactory().openSession();
        try {

            Criteria criteria = session.createCriteria(RequestBookDTO.class);

            Criterion userRestriction = (Restrictions.eq(USERDTO,
                    requestDTO.getUserDTO()));
            Criterion statusRestriction = (Restrictions.eq(REQUEST_STATUS,
                    DaoConstants.APPROVED));
            criteria.add(Restrictions.and(userRestriction, statusRestriction));
            List<RequestBookDTO> issuedBooksList = (List<RequestBookDTO>) criteria.list();

            LOGGER.info("LIST RETRIEVED FROM DATABASE" + issuedBooksList.size());
            return issuedBooksList;

        } catch (HibernateException e) {
            LOGGER.error("EXCETPION WHILE FETCHING ISSUED BOOKS FROM DATABASE"
                    + e);
            throw new DaoException(e);
        } finally {
            session.close();

        }

    }

    /**
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.dao.requestBook.RequestBookManagerDao#getBookDetailsById
     * (int)
     */
    public BooksDTO getBookDetailsById(int bookId) throws DaoException {
        LOGGER.info("GETTING BOOK DETAILS FROM DATABASE");
        Session session = Utility.getSessionFactory().openSession();
        try {
            Criteria criteria = session.createCriteria(BooksDTO.class);
            criteria.add(Restrictions.eq("bookId", bookId));

            return (BooksDTO) criteria.uniqueResult();

        } catch (HibernateException e) {
            LOGGER.error("EXCEPTION WHILE FETCHING BOOKS DETAILS FROM DATABASE"
                    + e);
            throw new DaoException(e);
        } finally {
            session.close();

        }
    }

    /**
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.dao.requestBook.RequestBookManagerDao#cancelDeleiveryRequest
     * (com.booksVibe.dao.DTO.RequestBookDTO)
     */
    public void cancelDeleiveryRequest(RequestBookDTO requestDTO)
            throws DaoException {
        // TODO Auto-generated method stub
        LOGGER.info("CANCELLING DELEIVERY REQUEST  IN DAO");
        Session session = Utility.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(RequestBookDTO.class);

            Criterion userRestriction = Restrictions.eq(USERDTO,
                    requestDTO.getUserDTO());
            Criterion bookRestriction = Restrictions.eq(BOOKSDTO,
                    requestDTO.getBooksDTO());
            Criterion statusRestriction = Restrictions.eq(REQUEST_STATUS,
                    DaoConstants.PENDING);
            criteria.add(Restrictions.and(userRestriction, bookRestriction,
                    statusRestriction));
            RequestBookDTO requestsDTO = (RequestBookDTO) criteria
                    .uniqueResult();

            requestsDTO.setRequestStatus(DaoConstants.CANCELLED);
            requestsDTO.setCancellationDate(new Date());

            session.update(requestsDTO);

            session.getTransaction().commit();
            LOGGER.info("REQUEST CANCELLED");
        } catch (HibernateException e) {
            LOGGER.error("EXCEPTION WHILE CANCELLING DELEIVERY REQUEST" + e);
            throw new DaoException(e);
        } finally {
            session.close();

        }

    }

    /**
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.dao.requestBook.RequestBookManagerDao#bookReturnRequest
     * (com.booksVibe.dao.DTO.RequestBookDTO)
     */
    public void bookReturnRequest(RequestBookDTO requestDTO)
            throws DaoException {
        Session session = Utility.getSessionFactory().openSession();
        try {
            LOGGER.info("RETURN REQUEST IN DAO");
            session.beginTransaction();
            Criteria criteria = session.createCriteria(RequestBookDTO.class);

            Criterion userRestriction = Restrictions.eq(USERDTO,
                    requestDTO.getUserDTO());
            Criterion bookRestriction = Restrictions.eq(BOOKSDTO,
                    requestDTO.getBooksDTO());

            criteria.add(Restrictions.and(userRestriction, bookRestriction));
            RequestBookDTO requestsDTO = (RequestBookDTO) criteria
                    .uniqueResult();

            requestsDTO.setRequestStatus(DaoConstants.RETURN_REQUEST);
            requestsDTO.setReturnDate(new Date());

            session.update(requestsDTO);

            session.getTransaction().commit();
            LOGGER.info("RETURN REQUEST SUCCESSFULLY DONE");
        } catch (HibernateException e) {
            LOGGER.info("EXCEPTION WHILE PLACING RETURN REQUEST." + e);
            throw new DaoException(e);
        } finally {
            session.close();

        }
    }

    /**
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.dao.requestBook.RequestBookManagerDao#viewToBeReturnedBooks
     * (com.booksVibe.dao.DTO.RequestBookDTO)
     */
    public List<RequestBookDTO> viewToBeReturnedBooks(RequestBookDTO requestDTO)throws DaoException {
        LOGGER.info("REQUESTING LIST IN DAO");
        Session session = Utility.getSessionFactory().openSession();
        try
        {

            Criteria criteria = session.createCriteria(RequestBookDTO.class);

            Criterion userRestriction = (Restrictions.eq(USERDTO,requestDTO.getUserDTO()));
            Criterion statusRestriction = (Restrictions.eq(REQUEST_STATUS,DaoConstants.RETURN_REQUEST));
            criteria.add(Restrictions.and(userRestriction, statusRestriction));
            List<RequestBookDTO> toBeReturnedBooksList = (List<RequestBookDTO>) criteria.list();

            LOGGER.info("LIST RETRIEVED FROM DATABASE"+ toBeReturnedBooksList.size());
            return toBeReturnedBooksList;

        }
        catch (HibernateException e)
        {
            LOGGER.error("EXCEPTION WHILE RETRIEVING RETURN REQUESTS." + e);
            throw new DaoException(e);
        }
        finally
        {
            session.close();

        }
    }

    /**
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.dao.requestBook.RequestBookManagerDao#cancelReturnRequest
     * (com.booksVibe.dao.DTO.RequestBookDTO)
     */
    public void cancelReturnRequest(RequestBookDTO requestDTO)
            throws DaoException {
        Session session = Utility.getSessionFactory().openSession();
        try {
            LOGGER.info("RETURN REQUEST IN DAO");
            session.beginTransaction();
            Criteria criteria = session.createCriteria(RequestBookDTO.class);

            Criterion userRestriction = Restrictions.eq(USERDTO,
                    requestDTO.getUserDTO());
            Criterion bookRestriction = Restrictions.eq(BOOKSDTO,
                    requestDTO.getBooksDTO());
            Criterion statusRestriction = Restrictions.eq(REQUEST_STATUS,
                    DaoConstants.RETURN_REQUEST);
            criteria.add(Restrictions.and(userRestriction, bookRestriction,
                    statusRestriction));
            RequestBookDTO requestsDTO = (RequestBookDTO) criteria
                    .uniqueResult();

            requestsDTO.setRequestStatus(DaoConstants.APPROVED);

            session.update(requestsDTO);

            session.getTransaction().commit();
            LOGGER.info("RETURN REQUEST SUCCESSFULLY CANCELLED");
        } catch (HibernateException e) {
            LOGGER.error("EXCEPTION WHILE CANCELLING RETURN REQUEST" + e);
            throw new DaoException(e);
        } finally {
            session.close();

        }
    }

    /**
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.dao.requestBook.RequestBookManagerDao#viewMyHistory(com
     * .booksVibe.dao.DTO.RequestBookDTO)
     */
    public List<RequestBookDTO> viewMyHistory(RequestBookDTO requestDTO)
            throws DaoException {
        Session session = Utility.getSessionFactory().openSession();
        try {
            LOGGER.info("REQUESTING MY HISTORY IN DAO");
            Criteria criteria = session.createCriteria(RequestBookDTO.class);

            Criterion userRestriction = Restrictions.eq(USERDTO,
                    requestDTO.getUserDTO());
            Criterion statusRestriction = Restrictions.eq(REQUEST_STATUS,
                    DaoConstants.CLOSE);
            Criterion cancelStatusRestriction = Restrictions.eq(
                    "requestStatus", DaoConstants.CANCELLED);

            criteria.add(Restrictions.and(userRestriction,
                    Restrictions.or(statusRestriction, cancelStatusRestriction)));

            List<RequestBookDTO> myHistoryList = (List<RequestBookDTO>) criteria.list();
            LOGGER.info("LIST RETRIEVED FROM DATABASE." + myHistoryList.size());

            return myHistoryList;

        } catch (HibernateException e) {
            LOGGER.error("EXCEPTION WHILE RETRIEVING HISTORY FROM DATABASE");
            throw new DaoException(e);
        } finally {
            session.close();

        }
    }

    
    /**
     * Assign operator.
     *
     * @return the user dto
     * @throws DaoException the dao exception
     */
    public UserDTO assignOperator() throws DaoException {
        Session session = Utility.getSessionFactory().openSession();
        try {
            LOGGER.info("ASSIGNING OPERATOR");
            UserDTO operator = new UserDTO();
            
            Criteria criteria = session.createCriteria(UserDTO.class);
            criteria.add(Restrictions.disjunction()
                    .add(Restrictions.eq("role", DaoConstants.ADMIN))
                    .add(Restrictions.eq("role", DaoConstants.MASTER)));
            List<UserDTO> operatorList = criteria.list();
                       
            for (int i = 0;i <operatorList.size();i++) {
                 operator = operatorList.get(i);
               
                Criteria operatorAlreadyAssigned = session.createCriteria(RequestBookDTO.class);
                operatorAlreadyAssigned.add(Restrictions.eq("operator",operator));
                List<RequestBookDTO> operatorAlreadyAssignedList = operatorAlreadyAssigned.list();
                
               
                   if (operatorAlreadyAssignedList.size()<=0) {
                       LOGGER.info("OPERATOR SELECTED:"+operator.getFirstname());
                       return operator;
                   } 
                
           }
           
                String query = "SELECT email_id AS emaild,PASSWORD,first_name AS firstname,last_name AS lastname,u.address,contact_no AS contactno,LANGUAGE,subsid,role,SUM(CASE WHEN br.request_status='pending' THEN 1 ELSE 0 END)requests FROM book_request br,USER u WHERE br.operator_id=u.email_id GROUP BY br.operator_id ORDER BY requests ASC LIMIT 1";
                SQLQuery q = session.createSQLQuery(query);
                         q.addScalar("emaild")
                          .addScalar("password")
                          .addScalar("firstname")
                          .addScalar("lastname")
                          .addScalar("address")
                          .addScalar("contactno")
                          .addScalar("language")
                          .addScalar("role")
                          .addScalar("requests", IntegerType.INSTANCE)
                          .setResultTransformer(Transformers.aliasToBean(UserDTO.class));

              
              return (UserDTO) q.uniqueResult();
              
        } catch (HibernateException e) {
             throw new DaoException(e); 
        }

    }

}
