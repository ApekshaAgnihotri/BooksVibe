package com.booksVibe.dao.recommendation;

import java.util.List;

import com.booksVibe.dao.DTO.BooksDTO;
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.exceptions.DaoException;

// TODO: Auto-generated Javadoc
/**
 * The Interface RecommendBooksDao.
 */
public interface RecommendBooksDao {

    /**
     * Gets the recommended book.
     * 
     * @param userDTO
     *            the user dto
     * @return the recommended book
     * @throws DaoException
     *             the dao exception
     */
    List<BooksDTO> getRecommendedBook(UserDTO userDTO) throws DaoException;

    /**
     * Recommend books.
     * 
     * @throws DaoException
     *             the dao exception
     */
    void recommendBooks() throws DaoException;
}
