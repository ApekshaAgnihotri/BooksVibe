package com.booksVibe.dao.books;

import java.util.List;

import com.booksVibe.dao.DTO.BooksDTO;
import com.booksVibe.dao.DTO.ListCarrier;
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.exceptions.NoDeleteException;


// TODO: Auto-generated Javadoc
/**
 * The Interface BooksManagerDao.
 */
public interface BooksManagerDao {

    /**
     * Adds the books.
     * 
     * @param booksDTO
     *            the books dto
     * @return the boolean
     * @throws DaoException
     *             the dao exception
     */
    Boolean addBooks(BooksDTO booksDTO,UserDTO operator) throws DaoException;

    /**
     * Update books.
     * 
     * @param booksDTO
     *            the books dto
     * @throws DaoException
     *             the dao exception
     */
    void updateBooks(BooksDTO booksDTO) throws DaoException;

    /**
     * Load books details.
     * 
     * @param start
     *            the start
     * @return the list carrier
     * @throws DaoException
     *             the dao exception
     */
    ListCarrier loadBooksDetails(int start,UserDTO operator) throws DaoException;

    /**
     * Books by id.
     * 
     * @param bookId
     *            the book id
     * @return the books dto
     * @throws DaoException
     *             the dao exception
     */
    BooksDTO booksById(int bookId) throws DaoException;

    /**
     * Search books.
     * 
     * @param booksDTO
     *            the books dto
     * @param start
     *            the start
     * @param end
     *            the end
     * @return the list carrier
     * @throws DaoException
     *             the dao exception
     */
    ListCarrier searchBooks(BooksDTO booksDTO, int start,String userEmailId)
            throws DaoException;

    /**
     * Delete books.
     * 
     * @param booksId
     *            the books id
     * @throws DaoException
     *             the dao exception
     * @throws NoDeleteExceptionTest
     *             the no delete exception
     */
    void deleteBooks(int booksId) throws DaoException, NoDeleteException;
    
    List<BooksDTO> newArrivals(String userEmailId) throws DaoException;
}
