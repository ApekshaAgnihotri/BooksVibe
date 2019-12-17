package com.booksVibe.daoImpl.recommendation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;

import com.booksVibe.dao.DTO.BooksDTO;
import com.booksVibe.dao.DTO.RecommendBooksDTO;
import com.booksVibe.dao.DTO.RequestBookDTO;
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.recommendation.RecommendBooksDao;
import com.booksVibe.daoImpl.daoConstants.DaoConstants;
import com.booksVibe.daoImpl.util.Utility;

// TODO: Auto-generated Javadoc
/**
 * The Class RecommendBooksDaoImpl.
 */
public class RecommendBooksDaoImpl implements RecommendBooksDao {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(RecommendBooksDaoImpl.class);
    
    /** The Constant MAX. */
    public static final int MAX = 5;
    
    /** The Constant REQUEST_STATUS. */
    private static final String REQUEST_STATUS="requestStatus";

    /**
     * (non-Javadoc).
     *
     * @param userDTO the user dto
     * @return the recommended book
     * @throws DaoException the dao exception
     * @see com.booksVibe.dao.recommendation.RecommendBooksDao#getRecommendedBook
     * (com.booksVibe.dao.DTO.UserDTO)
     */
    public List<BooksDTO> getRecommendedBook(UserDTO userDTO)throws DaoException 
     {
        // TODO Auto-generated method stub
        Session session = Utility.getSessionFactory().openSession();
        try 
        {
            LOGGER.info("FETCHING LIST IN DAO");
            Criteria criteria = session.createCriteria(RecommendBooksDTO.class);
            criteria.add(Restrictions.eq("userDTO", userDTO));
            List<RecommendBooksDTO> recommendedBooksList = (List<RecommendBooksDTO>) criteria.list();
            LOGGER.info("LIST FETCHED" + recommendedBooksList.size());

            List<BooksDTO> booksList = new ArrayList<BooksDTO>();

            for (RecommendBooksDTO recommendBooksDTO : recommendedBooksList) {
                BooksDTO booksDTO = recommendBooksDTO.getBooksDTO();
                booksList.add(booksDTO);
            }
            booksList=checkIfBookIsRequested(recommendedBooksList,userDTO);

            return booksList;

        }
        catch (HibernateException e) 
        {
            LOGGER.error("EXCEPTION IN RECOMMEND BOOKS DAO" + e);
            throw new DaoException(e);
        }
        finally 
        {
            session.close();
        }
    }
    
    
    
    /**
     * Check if book is requested.
     *
     * @param recommendBooksList the recommend books list
     * @param user the user
     * @return the list
     * @throws DaoException the dao exception
     */
    public List<BooksDTO> checkIfBookIsRequested(List<RecommendBooksDTO> recommendBooksList,UserDTO user) throws DaoException
    {
        Session session=Utility.getSessionFactory().openSession();
     try
     {
         List<BooksDTO> booksList=new ArrayList<BooksDTO>();
         for(RecommendBooksDTO recommendedBook:recommendBooksList)
         {
             recommendedBook.getBooksDTO().setIsRequested("false");
             Criteria requestCriteria=session.createCriteria(RequestBookDTO.class);
             requestCriteria.add(Restrictions.eq("userDTO",user));
             requestCriteria.add(Restrictions.disjunction()
                            .add(Restrictions.eq(REQUEST_STATUS,DaoConstants.APPROVED))
                            .add(Restrictions.eq(REQUEST_STATUS,DaoConstants.RETURN_REQUEST))
                            .add(Restrictions.eq(REQUEST_STATUS,DaoConstants.PENDING)));
            List<RequestBookDTO> requestedBooksList=requestCriteria.list();
            for(RequestBookDTO requestedBook:requestedBooksList)
            {
                 if(requestedBook.getBooksDTO().getBookId()==recommendedBook.getBooksDTO().getBookId())
                 {
                    recommendedBook.getBooksDTO().setIsRequested("true");
                 }
             }
            BooksDTO booksDTO = recommendedBook.getBooksDTO();
            booksList.add(booksDTO);
         }
         return booksList;
     }
     catch(HibernateException e){
         throw new DaoException(e);
     }
    }

    /**
     * (non-Javadoc)
     * 
     * @see com.booksVibe.dao.recommendation.RecommendBooksDao#recommendBooks()
     */
    public void recommendBooks() throws DaoException 
    {
        // TODO Auto-generated method stub
        Session session = Utility.getSessionFactory().openSession();
        try {

            LOGGER.info("IN RECOMMEND BOOK DAO");
            
            Query querybooks = session.createQuery("delete from RecommendBooksDTO");
            querybooks.executeUpdate();

            Criteria allUserCriteria = session.createCriteria(UserDTO.class);
            List<UserDTO> allUsersList = (List<UserDTO>) allUserCriteria.list();

            for (int i = 0; i <= allUsersList.size() - 1; i++) {
                UserDTO userDTO = allUsersList.get(i);
                LOGGER.info("USER" + userDTO.getEmaild());

                if (!userDTO.getRole().equals("admin")) {
                    Criteria criteria = session
                            .createCriteria(RequestBookDTO.class);
                    Criterion statusRestriction = Restrictions
                            .disjunction()
                            .add(Restrictions.eq(REQUEST_STATUS, DaoConstants.APPROVED))
                            .add(Restrictions.eq(REQUEST_STATUS,DaoConstants.RETURN_REQUEST))
                             .add(Restrictions.eq(REQUEST_STATUS,DaoConstants.CLOSE));
                    criteria.add(Restrictions.conjunction()
                            .add(Restrictions.eq("userDTO", userDTO))
                            .add(statusRestriction));
                    List<RequestBookDTO> userInRequestList = (List<RequestBookDTO>) criteria.list();

                    if (userInRequestList.size() > 0) {

                        LOGGER.info("USER FOUND");

                        String category = userInRequestList.get(0)
                                .getBooksDTO().getCategory();

                        Criteria booksCriteria = session
                                .createCriteria(BooksDTO.class);

                        booksCriteria.add(Restrictions.like("category",
                                category, MatchMode.ANYWHERE));
                        booksCriteria.add(Restrictions.sqlRestriction("1=1 order by rand()"));
                        booksCriteria.setMaxResults(MAX);
                        List<BooksDTO> recommendedBooksList = (List<BooksDTO>) booksCriteria.list();
                        LOGGER.info("LIST GENERATED"
                                + recommendedBooksList.size());

                        for (BooksDTO book : recommendedBooksList) {
                            session.beginTransaction();
                            RecommendBooksDTO recommendBooksDTO = new RecommendBooksDTO();
                            recommendBooksDTO.setUserDTO(userDTO);
                            LOGGER.info("User:" + userDTO.getEmaild());
                            LOGGER.info("BOok:" + book.getBookTitle());
                            recommendBooksDTO.setBooksDTO(book);
                            session.saveOrUpdate(recommendBooksDTO);
                            session.getTransaction().commit();
                            LOGGER.info("DATA INSERTED");
                        }

                    }

                }
            }

        }
        catch (HibernateException e) 
        {
            LOGGER.error("EXCEPTION IN DAO" + e);
            throw new DaoException(e);
        } finally
        {
            session.close();
        }
    }

}
