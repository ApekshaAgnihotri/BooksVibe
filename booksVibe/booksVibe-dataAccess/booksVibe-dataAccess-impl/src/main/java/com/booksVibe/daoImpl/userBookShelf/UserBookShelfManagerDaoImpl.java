package com.booksVibe.daoImpl.userBookShelf;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.booksVibe.dao.DTO.RequestBookDTO;
import com.booksVibe.dao.DTO.UserBookShelfDTO;
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.exceptions.AlreadyInShelfException;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.userBookShelf.UserBookShelfManagerDao;
import com.booksVibe.daoImpl.daoConstants.DaoConstants;
import com.booksVibe.daoImpl.util.Utility;

// TODO: Auto-generated Javadoc
/**
 * The Class CartManagerDaoImpl.
 */
public class UserBookShelfManagerDaoImpl implements UserBookShelfManagerDao {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger.getLogger(UserBookShelfManagerDaoImpl.class);
    
    /** The Constant USER_DTO. */
    private static final String REQUEST_STATUS="requestStatus",USER_DTO="userDTO";

    /**
     * (non-Javadoc).
     *
     * @param userBookShelfDTO the user book shelf dto
     * @throws DaoException the dao exception
     * @throws AlreadyInShelfException the already in shelf exception
     * @see com.booksVibe.dao.userBookShelf.UserBookShelfManagerDao#addToShelf(com.booksVibe.dao.DTO
     * .UserBookShelfDTO)
     */
    public void addToShelf(UserBookShelfDTO userBookShelfDTO) throws DaoException,AlreadyInShelfException 
    {
        // TODO Auto-generated method stub
        Session session = Utility.getSessionFactory().openSession();
     try {
            LOGGER.info("IN DAO LAYER..");

            Criteria criteria = session.createCriteria(UserBookShelfDTO.class);
            session.beginTransaction();
            
               Criterion userRestriction = Restrictions.eq(USER_DTO,userBookShelfDTO.getUserDTO());
               Criterion bookRestriction = Restrictions.eq("booksDTO",userBookShelfDTO.getBooksDTO());
               criteria.add(Restrictions.and(userRestriction, bookRestriction));
               List<UserBookShelfDTO> list = (List<UserBookShelfDTO>) criteria.list();

               LOGGER.info("LIST SIZE" + list.size());
               if (list.size() > 0) 
               {
                   LOGGER.info("BOOK ALREADY IN THE SHELF");
                   throw new AlreadyInShelfException();
               }
               else
               {
                   LOGGER.info("ADDING BOOK IN THE SHELF");
                   session.save(userBookShelfDTO);
               }
               
           session.getTransaction().commit();
        } 
        catch (HibernateException e) 
        {
            throw new DaoException(e);
        }
        finally 
        {
            session.close();
        }
    }

    /**
     * (non-Javadoc).
     *
     * @param userBookShelfDTO the user book shelf dto
     * @throws DaoException the dao exception
     * @see com.booksVibe.dao.userBookShelf.UserBookShelfManagerDao#deleteFromCart(com.booksVibe.dao
     * .DTO.UserCartDTO)
     */
    public void deleteFromShelf(UserBookShelfDTO userBookShelfDTO) throws DaoException 
    {
        // TODO Auto-generated method stub
        Session session = Utility.getSessionFactory().openSession();
       try 
       {
            LOGGER.info("IN DAO LAYER..");
            Criteria criteria = session.createCriteria(UserBookShelfDTO.class);
            session.beginTransaction();
               Criterion userRestriction = Restrictions.eq(USER_DTO,userBookShelfDTO.getUserDTO());
               Criterion bookRestriction = Restrictions.eq("booksDTO",userBookShelfDTO.getBooksDTO());
               criteria.add(Restrictions.and(userRestriction, bookRestriction));
               UserBookShelfDTO cartsDTO = (UserBookShelfDTO) criteria.uniqueResult();
                     
                session.delete(cartsDTO);
                LOGGER.info("BOOK DELETED");
            
             session.getTransaction().commit();

        }
       catch (HibernateException e) 
       {
            throw new DaoException(e);
       }
       finally 
       {
            session.close();
       }
    }

    /**
     * (non-Javadoc).
     *
     * @param userBookShelfDTO the user book shelf dto
     * @return the list
     * @throws DaoException the dao exception
     * @see com.booksVibe.dao.userBookShelf.UserBookShelfManagerDao#viewMyShelf(com.booksVibe.dao.DTO
     * .UserBookShelfDTO)
     */
    public List<UserBookShelfDTO> viewMyShelf(UserBookShelfDTO userBookShelfDTO)throws DaoException 
    {
        // TODO Auto-generated method stub
        Session session = Utility.getSessionFactory().openSession();
      try {

            Criteria criteria = session.createCriteria(UserBookShelfDTO.class);
            criteria.add(Restrictions.eq(USER_DTO, userBookShelfDTO.getUserDTO()));
            List<UserBookShelfDTO> booksInShelfList = (List<UserBookShelfDTO>) criteria.list();
            
            booksInShelfList=checkRequestedBooksInShelf(booksInShelfList,userBookShelfDTO.getUserDTO());
            
            return booksInShelfList;
        } 
        catch (HibernateException e) 
        {
            throw new DaoException(e);
        }
        finally 
        {
            session.close();
        }
    }

    
    /**
     * Check requested books in shelf.
     * This method determines if a book in the shelf is requested by a user or not
     * @param booksInShelfList the books in shelf list
     * @param user the user
     * @return the list
     */
    public List<UserBookShelfDTO> checkRequestedBooksInShelf(List<UserBookShelfDTO> booksInShelfList,UserDTO user)
    {
        Session session=Utility.getSessionFactory().openSession();
        List<UserBookShelfDTO> booksInShelf=new ArrayList<UserBookShelfDTO>();
        
        for(UserBookShelfDTO userShelf:booksInShelfList)
        {
            userShelf.getBooksDTO().setIsRequested("false");
             Criteria requestCriteria=session.createCriteria(RequestBookDTO.class);
             
             requestCriteria.add(Restrictions.eq(USER_DTO,user));
             requestCriteria.add(Restrictions.disjunction()
                            .add(Restrictions.eq(REQUEST_STATUS,DaoConstants.APPROVED))
                            .add(Restrictions.eq(REQUEST_STATUS,DaoConstants.RETURN_REQUEST))
                            .add(Restrictions.eq(REQUEST_STATUS,DaoConstants.PENDING)));
            List<RequestBookDTO> requestedBooksList=requestCriteria.list();
   
           for(RequestBookDTO requestedBook:requestedBooksList)
           {
                if(requestedBook.getBooksDTO().getBookId()==userShelf.getBooksDTO().getBookId())
                {
                   userShelf.getBooksDTO().setIsRequested("true");
                }
           }
          booksInShelf.add(userShelf);
        }
        return booksInShelf;
    }
        
    
    
}
