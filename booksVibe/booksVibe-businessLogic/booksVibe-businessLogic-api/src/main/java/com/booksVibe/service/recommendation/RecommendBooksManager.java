package com.booksVibe.service.recommendation;

import java.util.List;

import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.valueObject.BooksVO;
import com.booksVibe.service.valueObject.UserValueObject;

// TODO: Auto-generated Javadoc
/**
 * The Interface RecommendBooksManager.
 */
public interface RecommendBooksManager {

    /**
     * Gets the recommended books.
     * 
     * @param userValueObject
     *            the user value object
     * @return the recommended books
     * @throws ServiceException
     *             the service exception
     */
    List<BooksVO> getRecommendedBooks(UserValueObject userValueObject)
            throws ServiceException;

    /**
     * Recommend books.
     * 
     * @throws ServiceException
     *             the service exception
     */
    void recommendBooks() throws ServiceException;
}
