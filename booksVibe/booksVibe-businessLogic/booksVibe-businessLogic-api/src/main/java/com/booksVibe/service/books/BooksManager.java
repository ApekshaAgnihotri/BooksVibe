package com.booksVibe.service.books;

import java.util.List;

import com.booksVibe.service.exceptions.NoDeleteServiceException;
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.valueObject.BooksVO;
import com.booksVibe.service.valueObject.ListCarrierVO;
import com.booksVibe.service.valueObject.UserValueObject;

// TODO: Auto-generated Javadoc
/**
 * The Interface BooksManager.
 */
public interface BooksManager {

    /**
     * Adds the books.
     *
     * @param booksVO            the books vo
     * @param operator the operator
     * @return the boolean
     * @throws ServiceException             the service exception
     */
    Boolean addBooks(BooksVO booksVO,UserValueObject operator) throws ServiceException;

    /**
     * Update books.
     * 
     * @param booksVO
     *            the books vo
     * @throws ServiceException
     *             the service exception
     */
    void updateBooks(BooksVO booksVO) throws ServiceException;

    /**
     * Load books details.
     * 
     * @param start
     *            the start
     * @return the list carrier vo
     * @throws ServiceException
     *             the service exception
     */
    ListCarrierVO loadBooksDetails(int start,UserValueObject operator) throws ServiceException;

    /**
     * Delete books.
     * 
     * @param bookid
     *            the bookid
     * @throws ServiceException
     *             the service exception
     * @throws NoDeleteServiceException
     *             the no delete service exception
     */
    void deleteBooks(int bookid) throws ServiceException,
            NoDeleteServiceException;

    /**
     * Books by id.
     * 
     * @param bookId
     *            the book id
     * @return the books vo
     * @throws ServiceException
     *             the service exception
     */
    BooksVO booksById(int bookId) throws ServiceException;

    /**
     * Search books.
     * 
     * @param booksVO
     *            the books vo
     * @param start
     *            the start
     * @param end
     *            the end
     * @return the list carrier vo
     * @throws ServiceException
     *             the service exception
     */
    ListCarrierVO searchBooks(BooksVO booksVO, int start,String userEmailId) throws ServiceException;
    
     /**
      * New arrivals.
      *
      * @return the list
      * @throws ServiceException the service exception
      */
     List<BooksVO> newArrivals(String userEmailId)throws ServiceException; 
}
