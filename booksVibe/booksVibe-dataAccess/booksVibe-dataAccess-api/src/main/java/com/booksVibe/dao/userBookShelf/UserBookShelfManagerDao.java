package com.booksVibe.dao.userBookShelf;

import java.util.List;

import com.booksVibe.dao.DTO.UserBookShelfDTO;
import com.booksVibe.dao.exceptions.AlreadyInShelfException;
import com.booksVibe.dao.exceptions.DaoException;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserBookShelfManagerDao.
 */
public interface UserBookShelfManagerDao {

    /**
     * Adds the book in the user's shelf.
     * 
     * @param userBookShelfDTO
     *            the user book shelf dto
     * @throws DaoException
     *             the dao exception
     * @throws AlreadyInShelfException
     *             the already in shelf exception
     */
    void addToShelf(UserBookShelfDTO userBookShelfDTO) throws DaoException,
            AlreadyInShelfException;

    /**
     * Delete a book from the user's shelf.
     * 
     * @param userBookShelfDTO
     *            the user book shelf dto
     * @throws DaoException
     *             the dao exception
     */
    void deleteFromShelf(UserBookShelfDTO userBookShelfDTO) throws DaoException;

    /**
     * View my shelf.
     * Fetches the list of the books in user's shelf.
     * @param userBookShelfDTO
     *            the user book shelf dto
     * @return the list
     * @throws DaoException
     *             the dao exception
     */
    List<UserBookShelfDTO> viewMyShelf(UserBookShelfDTO userBookShelfDTO) throws DaoException;
}
