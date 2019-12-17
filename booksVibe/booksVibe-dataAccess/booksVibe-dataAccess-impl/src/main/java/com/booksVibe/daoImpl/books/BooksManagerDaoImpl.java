package com.booksVibe.daoImpl.books;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import com.booksVibe.dao.DTO.BooksDTO;
import com.booksVibe.dao.DTO.ListCarrier;
import com.booksVibe.dao.DTO.RecommendBooksDTO;
import com.booksVibe.dao.DTO.RequestBookDTO;
import com.booksVibe.dao.DTO.UserBookShelfDTO;
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.books.BooksManagerDao;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.exceptions.NoDeleteException;

import com.booksVibe.daoImpl.daoConstants.DaoConstants;
import com.booksVibe.daoImpl.util.Utility;

// TODO: Auto-generated Javadoc
/**
 * The Class BooksManagerDaoImpl.
 */
public class BooksManagerDaoImpl implements BooksManagerDao {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(BooksManagerDaoImpl.class);
    
    /** The Constant SIZE. */
    private static final int SIZE=6;
    
    /** The Constant BOOKSDTO. */
    private static final String BOOKSDTO="booksDTO";
    
    /** The Constant REQUEST_STATUS. */
    private static final String REQUEST_STATUS = "requestStatus";
    
    /**
     * (non-Javadoc).
     *
     * @param booksDTO the books dto
     * @param operator the operator
     * @return the boolean
     * @throws DaoException the dao exception
     * @see com.booksVibe.dao.books.BooksManagerDao#addBooks(com.booksVibe.dao.DTO
     * .BooksDTO)
     */
    public Boolean addBooks(BooksDTO booksDTO,UserDTO operator) throws DaoException 
    {

        SessionFactory sessionFactory = Utility.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
         
               Criteria criteria = session.createCriteria(BooksDTO.class);
               criteria.add(Restrictions.conjunction()
                    .add(Restrictions.eq("author", booksDTO.getAuthor()))
                    .add(Restrictions.eq("bookTitle", booksDTO.getBookTitle())));
               List<BooksDTO> list = criteria.list();

               if (list.size() > 0) {
                    return false;
               } 
               else
               {
                    session.beginTransaction();
                    booksDTO.setOperator(operator);
                    booksDTO.setAvailability(DaoConstants.AVAILABLE);
                    session.save(booksDTO);

                    LOGGER.info("BOOK ADDED SUCCESSFULLY");
                    session.getTransaction().commit();
                return true;
              }

        }
        catch (HibernateException e)
        {
            LOGGER.error("EXCEPTION IN DAO WHILE ADDING BOOK" + e);
            throw new DaoException(e);
        }
        finally{
            session.close();
        }
    }

    /**
     * (non-Javadoc).
     *
     * @param bookId the book id
     * @return the books dto
     * @throws DaoException the dao exception
     * @see com.booksVibe.dao.books.BooksManagerDao#booksById(int)
     */
    public BooksDTO booksById(int bookId) throws DaoException
    {
        SessionFactory sessionFactory = Utility.getSessionFactory();
        Session session = sessionFactory.openSession();
       try 
       {

            BooksDTO booksDTO = null;
           
            booksDTO = (BooksDTO) session.get(BooksDTO.class, bookId);

            return booksDTO;
        } 
        catch (HibernateException e)
        {
            LOGGER.error("EXCEPTION IN DAO WHILE FETCHING BOOK" + e);
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
     * @param booksDTO the books dto
     * @throws DaoException the dao exception
     * @see com.booksVibe.dao.books.BooksManagerDao#updateBooks(com.booksVibe.dao
     * .DTO.BooksDTO)
     */
    public void updateBooks(BooksDTO booksDTO) throws DaoException 
    {
        SessionFactory sessionFactory = Utility.getSessionFactory();
        Session session = sessionFactory.openSession();
      try 
      {
           
            session.beginTransaction();
            booksDTO.setAvailability(DaoConstants.AVAILABLE);
            session.saveOrUpdate(booksDTO);
            session.getTransaction().commit();
            LOGGER.info("BOOK UPDATED SUCCESSFULLY");

         }
         catch (HibernateException e) 
         {
            LOGGER.error("EXCEPTION IN DAO WHILE UPDATING" + e);
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
     * @param start the start
     * @param operator the operator
     * @return the list carrier
     * @throws DaoException the dao exception
     * @see com.booksVibe.dao.books.BooksManagerDao#loadBooksDetails(int)
     */
    public ListCarrier loadBooksDetails(int start,UserDTO operator) throws DaoException {
        SessionFactory sessionFactory = Utility.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            LOGGER.info("LOADING IN DAO.."+operator);
            
            ListCarrier listCarrier = new ListCarrier();
            
           
            Criteria criteria = session.createCriteria(BooksDTO.class);
            criteria.add(Restrictions.eq("operator",operator));
            
            List<BooksDTO> booksListDTO = (ArrayList<BooksDTO>) criteria.list();
            
            LOGGER.info("LIST RECIEVED FROM DATABASE.." + booksListDTO.size());
            
            criteria.setFirstResult(start);
            criteria.setMaxResults(SIZE);
            
            List<BooksDTO> bookListDTO = (ArrayList<BooksDTO>) criteria.list();
            
            listCarrier.setBooksListDTO(bookListDTO);
            listCarrier.setTotalRecords(booksListDTO.size());
            return listCarrier;

        } catch (HibernateException e) {
            LOGGER.info("EXCEPTION IN DAO WHILE FETCHING BOOKS" + e);
            throw new DaoException(e);

        }
        finally{
            session.close();
        }
    }

    /**
     * (non-Javadoc).
     *
     * @param bookId the book id
     * @throws DaoException the dao exception
     * @throws NoDeleteException the no delete exception
     * @see com.booksVibe.dao.books.BooksManagerDao#deleteBooks(int)
     */
    public void deleteBooks(int bookId) throws DaoException, NoDeleteException 
    {
       
      SessionFactory sessionFactory = Utility.getSessionFactory();
      Session session = sessionFactory.openSession();
      try 
      {
             BooksDTO booksDTO = (BooksDTO) session.get(BooksDTO.class, bookId);

               /* if book is requested by any user */
               Criteria criteria = session.createCriteria(RequestBookDTO.class);
               
              criteria.add(Restrictions.eq(BOOKSDTO, booksDTO));
              List<RequestBookDTO> rList=criteria.list();
              if(rList.size()>0){
              
               
                          Criterion book=Restrictions.eq(BOOKSDTO,booksDTO);
                          Criterion close=Restrictions.eq(REQUEST_STATUS,DaoConstants.CLOSE);
                          Criterion cancelled=Restrictions.eq(REQUEST_STATUS,DaoConstants.CANCELLED);
                          criteria.add(Restrictions.and(book,Restrictions.or(close,cancelled)));

                
                  List<RequestBookDTO> requestList = criteria.list();
                   
                  
                 if (requestList.size() > 0) {
                     
                     Criteria cartCriteria=session.createCriteria(UserBookShelfDTO.class);
                     cartCriteria.add(Restrictions.eq(BOOKSDTO,booksDTO));
                     List<UserBookShelfDTO>  cartList=cartCriteria.list();
             
                     if(cartList.size()>0){
                            LOGGER.error("BOOK PRESENT IN USERS CART");
                            throw new NoDeleteException();
                     }
                     else{
                             
                             Criteria recCriteria=session.createCriteria(RecommendBooksDTO.class);
                             recCriteria.add(Restrictions.eq(BOOKSDTO,booksDTO));
                             List<RecommendBooksDTO> list=recCriteria.list();
                             LOGGER.info("DELETING BOOK" +list.size());
                             
                             session.beginTransaction();
             
                             for(RecommendBooksDTO recommendBooksDTO:list){
                                        session.delete(recommendBooksDTO);
                              }
                     
                             for(RequestBookDTO r:requestList){
                                 session.delete(r);
                             }
                             
                              session.delete(booksDTO);

                              session.getTransaction().commit();
                              LOGGER.info("BOOK DELETED");
                      }
                       
                 } else {
                         
                     LOGGER.error("BOOK ALREADY REQUESTED BY USERS");
                     throw new NoDeleteException();

                   }
              }else{
                  session.beginTransaction();
                  session.delete(booksDTO);
                  session.getTransaction().commit();
                  LOGGER.info("BOOK DELETED");
              }
       }
      
      catch (HibernateException e) {
            LOGGER.error("EXCEPTION WHILE DELETING BOOK IN DAO..");
            throw new DaoException(e);
      }
        finally{
            session.close();
        }
    }
      

    /**
     * (non-Javadoc).
     *
     * @param booksDTO the books dto
     * @param start the start
     * @param userEmailId the user email id
     * @return the list carrier
     * @throws DaoException the dao exception
     * @see com.booksVibe.dao.books.BooksManagerDao#searchBooks(com.booksVibe.dao
     * .DTO.BooksDTO, int, int)
     */
    public ListCarrier searchBooks(BooksDTO booksDTO, int start,String userEmailId)throws DaoException 
    {
        Session session = Utility.getSessionFactory().openSession();
      try 
      {

            ListCarrier listCarrier = new ListCarrier();
            LOGGER.info("REQUESTING LIST IN DAO");
          

            session.beginTransaction();


                Criteria criteria = session.createCriteria(BooksDTO.class);
                Criterion category = Restrictions.eq("category",booksDTO.getCategory());
                Criterion author = Restrictions.like("author",booksDTO.getAuthor(), MatchMode.ANYWHERE).ignoreCase();
                Criterion publisher = Restrictions.like("publisher",booksDTO.getPublisher(), MatchMode.ANYWHERE).ignoreCase();
                Criterion bookTitle = Restrictions.like("bookTitle",booksDTO.getBookTitle(), MatchMode.ANYWHERE).ignoreCase();
    
                searchConditions(booksDTO, criteria, category, author, publisher,bookTitle);
                ArrayList<BooksDTO> booksListDTO = (ArrayList<BooksDTO>) criteria.list();
            
            session.getTransaction().commit();
           
            LOGGER.info("RECORD NO:" + start);
            
            criteria.setFirstResult(start);
            criteria.setMaxResults(SIZE);
            
            List<BooksDTO> bookListDTO = (ArrayList<BooksDTO>) criteria.list();
            listCarrier.setBooksListDTO(bookListDTO);
            listCarrier.setTotalRecords(booksListDTO.size());
            
            bookListDTO=checkIfRequestedOrInShelf(bookListDTO,userEmailId);
                    
            LOGGER.info("SIZE OF LIST FETCHED:" + bookListDTO.size());
            return listCarrier;

        }
        catch (HibernateException e) 
        {
            LOGGER.error("ERROR WHILE ACCESSIGN DATA BASE" + e);
            throw new DaoException(e);
        }
        finally
        {
            session.close();
        }

    }

    
    /**
     * Search conditions.
     *
     * @param booksDTO the books dto
     * @param criteria the criteria
     * @param category the category
     * @param author the author
     * @param publisher the publisher
     * @param bookTitle the book title
     */
    private void searchConditions(BooksDTO booksDTO, Criteria criteria,Criterion category, Criterion author, Criterion publisher,Criterion bookTitle)
    {
        if (booksDTO.getBookTitle().isEmpty()&& booksDTO.getPublisher().isEmpty()&& booksDTO.getAuthor().isEmpty()) 
        {
            if (!booksDTO.getCategory().equals("all")) {
                criteria.add(category);
            }
        } 
        else{
            conditions(booksDTO, criteria, author, publisher, bookTitle);
        }
    }

    /**
     * Conditions.
     *
     * @param booksDTO the books dto
     * @param criteria the criteria
     * @param author the author
     * @param publisher the publisher
     * @param bookTitle the book title
     */
    private void conditions(BooksDTO booksDTO, Criteria criteria,Criterion author, Criterion publisher, Criterion bookTitle) 
    {
        if (booksDTO.getBookTitle().isEmpty()&& booksDTO.getPublisher().isEmpty())
        {
              criteria.add(author);

        } else if (booksDTO.getBookTitle().isEmpty()&& booksDTO.getAuthor().isEmpty())
          {
              criteria.add(publisher);

          } else if (booksDTO.getPublisher().isEmpty()&& booksDTO.getAuthor().isEmpty())
            {
               criteria.add(bookTitle);

            } else
              {
                parameterIsEmpty(booksDTO, criteria, author, publisher, bookTitle);
              }
    }

    /**
     * Parameter is empty.
     *
     * @param booksDTO the books dto
     * @param criteria the criteria
     * @param author the author
     * @param publisher the publisher
     * @param bookTitle the book title
     */
    private void parameterIsEmpty(BooksDTO booksDTO, Criteria criteria,Criterion author, Criterion publisher, Criterion bookTitle) 
    {
        
        if (booksDTO.getPublisher().isEmpty()) 
        {
            Criterion result2 = Restrictions.or(bookTitle, author);
            criteria.add(result2);
        } 
        else if (booksDTO.getAuthor().isEmpty()) 
        {
            Criterion result2 = Restrictions.or(bookTitle, publisher);
            criteria.add(result2);

        }
        else if (booksDTO.getBookTitle().isEmpty()) 
        {
            Criterion result2 = Restrictions.or(author, publisher);
            criteria.add(result2);

        }
        else {
            Criterion result2 = Restrictions.or(author, publisher);
            Criterion result1 = Restrictions.or(result2, bookTitle);
            criteria.add(result1);
        }
    }
    
    
    /** (non-Javadoc)
     * @see com.booksVibe.dao.books.BooksManagerDao#newArrivals(java.lang.String)
     */
    public List<BooksDTO> newArrivals(String userEmailId) throws DaoException
    {
        Session session=Utility.getSessionFactory().openSession();
      try {
          
            LOGGER.info("FETCHING NEW ARRIVALS");
            Criteria criteria=session.createCriteria(BooksDTO.class);
            criteria.addOrder(Order.desc("bookId"));
            criteria.setMaxResults(SIZE);
            List<BooksDTO> booksList=criteria.list();
            
            LOGGER.info("LIST SIZE:"+booksList.size());
            booksList=checkIfRequestedOrInShelf(booksList,userEmailId);
            return booksList;
        }
        catch(HibernateException e)
        {
            LOGGER.error("EXCEPTION IN FETCHING NEW ARRIVALS"+e);
            throw new DaoException(e);
        }
        finally{
            session.close();
        }
    }
    
    
  /**
   * Check if requested or in shelf.
   *
   * @param booksListDTO the books list dto
   * @param userEmailId the user email id
   * @return the list
   * @throws DaoException the dao exception
   */
  public List<BooksDTO>checkIfRequestedOrInShelf(List<BooksDTO> booksListDTO,String userEmailId)throws DaoException
  {
      Session session=Utility.getSessionFactory().openSession();
      try
      {
          List<BooksDTO> booksList=new ArrayList<BooksDTO>();
          for(BooksDTO book:booksListDTO)
          {
              book.setInShelf("false");
              book.setIsRequested("false");
                  if(userEmailId!=null)
                  {
                          UserDTO user=new UserDTO();
                          user.setEmaild(userEmailId);
             
                          Criteria shelfCriteria=session.createCriteria(UserBookShelfDTO.class);
                          shelfCriteria.add(Restrictions.eq("userDTO",user));
                          List<UserBookShelfDTO> booksInShelfList=shelfCriteria.list();
                     
                          for(UserBookShelfDTO bookInShelf:booksInShelfList)
                          {
                              if(bookInShelf.getBooksDTO().getBookId()==book.getBookId())
                              {
                                  book.setInShelf("true");
                              }
                          }
                     
                          Criteria requestCriteria=session.createCriteria(RequestBookDTO.class);
                          requestCriteria.add(Restrictions.eq("userDTO",user));
                          requestCriteria.add(Restrictions.disjunction()
                                          .add(Restrictions.eq(REQUEST_STATUS,DaoConstants.APPROVED))
                                          .add(Restrictions.eq(REQUEST_STATUS,DaoConstants.RETURN_REQUEST))
                                          .add(Restrictions.eq(REQUEST_STATUS,DaoConstants.PENDING)));
                          List<RequestBookDTO> requestedBooksList=requestCriteria.list();
                     
                          for(RequestBookDTO requestedBook:requestedBooksList)
                          {
                              if(requestedBook.getBooksDTO().getBookId()==book.getBookId())
                              {
                                  book.setIsRequested("true");
                              }
                          }
                  }
                
                booksList.add(book);
          }
          return booksList;
      }
      catch(HibernateException e){
          throw new DaoException(e);
      }
  }

}
