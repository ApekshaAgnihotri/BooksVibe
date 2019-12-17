package com.booksVibe.service.userBookShelf;

import java.util.List;

import com.booksVibe.service.exceptions.AlreadyInShelfServiceException;
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.valueObject.UserBookShelfVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface CartManager.
 */
public interface UserBookShelfManager {

    /**
     * Adds the to Shelf.
     * Adds a book in the user's shelf
     * @param userBookShelfVO
     *            the user book shelf vo
     * @throws ServiceException
     *             the service exception
     * @throws AlreadyInShelfServiceException
     *             the already in shelf service exception
     */
    void addToShelf(UserBookShelfVO userBookShelfVO) throws ServiceException,AlreadyInShelfServiceException;

    /**
     * Delete from shelf.
     * Deletes a book from the user's shelf
     * @param userBookShelfVO
     *            the shelf vo
     * @throws ServiceException
     *             the service exception
     */
    void deleteFromShelf(UserBookShelfVO userBookShelfVO) throws ServiceException;

    /**
     * View my shelf.
     * 
     * @param userBookShelfVO
     *            the user Book shelf vo
     * @return the list containing books in user's shelf
     * @throws ServiceException
     *             the service exception
     */
    List<UserBookShelfVO> viewMyShelf(UserBookShelfVO userBookShelfVO) throws ServiceException;
}
